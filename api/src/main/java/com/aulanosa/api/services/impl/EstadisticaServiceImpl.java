package com.aulanosa.api.services.impl;


import com.aulanosa.api.dtos.EstadisticaDTO;
import com.aulanosa.api.dtos.JugadorDTO;
import com.aulanosa.api.mappers.EstadisticaMapper;
import com.aulanosa.api.repositories.EstadisticaRepository;
import com.aulanosa.api.services.EstadisticaService;
import com.aulanosa.api.services.JugadorService;
import jakarta.annotation.PostConstruct;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Lazy
@Component
public class EstadisticaServiceImpl implements EstadisticaService {

    @Autowired
    private EstadisticaRepository estadisticaRepository;
    @Autowired
    private JugadorService jugadorService;

    /**
     * Este método permite obtener los promedios de todos los jugadores mediante una petición a una api externa
     * @return Lista de objetos EstadisticaDTO
     */
    private List<EstadisticaDTO> obtenerPromedios() {
        List<EstadisticaDTO> promedios = new ArrayList<>();
        List<JugadorDTO> jugadores = jugadorService.obtenerJugadoresTemporada();
        int[] playerIds = jugadores.stream().mapToInt(JugadorDTO::getIdJugador).toArray();


        int midpoint = playerIds.length / 2;
        int[] firstHalf = Arrays.copyOfRange(playerIds, 0, midpoint);
        int[] secondHalf = Arrays.copyOfRange(playerIds, midpoint, playerIds.length);

        String firstHalfParams = IntStream.of(firstHalf)
                .mapToObj(id -> "player_ids[]=" + id)
                .collect(Collectors.joining("&"));

        String secondHalfParams = IntStream.of(secondHalf)
                .mapToObj(id -> "player_ids[]=" + id)
                .collect(Collectors.joining("&"));

        try {
            for (int i = 0; i < 2; i++) {
                URL url = null;
                if(i==0){
                    url = new URL("https://api.balldontlie.io/v1/season_averages?season=2023&" + firstHalfParams);
                }else{
                    url = new URL("https://api.balldontlie.io/v1/season_averages?season=2023&" + secondHalfParams);
                }

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Authorization", System.getenv("BALL_DONT_LIE"));
                connection.setRequestMethod("GET");

                connection.connect();
                int code = connection.getResponseCode();

                if (code != 200) {
                    System.out.println("Se produjo un error: " + code);
                    System.out.println(connection.getResponseMessage());
                } else {
                    StringBuilder information = new StringBuilder();
                    Scanner sc = new Scanner(connection.getInputStream());

                    while (sc.hasNext()) {
                        information.append(sc.nextLine());
                    }

                    sc.close();

                    JSONArray jsonArray = new JSONObject(information.toString()).getJSONArray("data");

                    for (int j = 0; j < jsonArray.length(); j++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(j);
                        EstadisticaDTO estadisticaDTO = new EstadisticaDTO();
                        estadisticaDTO.setIdJugador(jsonObject.getInt("player_id"));
                        estadisticaDTO.setPuntosPorPartido(jsonObject.getDouble("pts"));
                        estadisticaDTO.setAsistenciasPorPartido(jsonObject.getDouble("ast"));
                        estadisticaDTO.setPerdidasPorPartido(jsonObject.getDouble("turnover"));
                        estadisticaDTO.setFaltasPorPartido(jsonObject.getDouble("pf"));
                        estadisticaDTO.setTirosIntentados(jsonObject.getDouble("fga"));
                        estadisticaDTO.setTirosConvertidos(jsonObject.getDouble("fgm"));
                        estadisticaDTO.setTirosLibresIntentados(jsonObject.getDouble("fta"));
                        estadisticaDTO.setTirosLibresConvertidos(jsonObject.getDouble("ftm"));
                        estadisticaDTO.setTriplesIntentados(jsonObject.getDouble("fg3a"));
                        estadisticaDTO.setTriplesConvertidos(jsonObject.getDouble("fg3m"));
                        estadisticaDTO.setRebotesPorPartido(jsonObject.getDouble("reb"));
                        estadisticaDTO.setRebotesOfensivosPorPartido(jsonObject.getDouble("oreb"));
                        estadisticaDTO.setRebotesDefensivosPorPartido(jsonObject.getDouble("dreb"));
                        estadisticaDTO.setRobosPorPartido(jsonObject.getDouble("stl"));
                        estadisticaDTO.setTaponesPorPartido(jsonObject.getDouble("blk"));
                        estadisticaDTO.setPorcentajeTirosDeCampo(jsonObject.getDouble("fg_pct"));
                        estadisticaDTO.setPorcentajeTriples(jsonObject.getDouble("fg3_pct"));
                        estadisticaDTO.setPorcentajeTirosLibres(jsonObject.getDouble("ft_pct"));
                        estadisticaDTO.setMinutosJugados(jsonObject.getString("min"));
                        estadisticaDTO.setPartidosJugados(jsonObject.getInt("games_played"));


                        promedios.add(estadisticaDTO);
                    }
                    System.out.println("ESTADISTICAS TODO BIEN");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return promedios;
    }

    /**
     * Este método permite almacenar las estadísticas de los jugadores en base de datos
     */
    @Override
    @Scheduled(cron = "0 59 23 23 10 ?")
    public void insertarEstadisticas() {
        List<EstadisticaDTO> promedios = obtenerPromedios();
        for (EstadisticaDTO estadisticaDTO : promedios) {
            estadisticaRepository.save(EstadisticaMapper.convertirAModelo(estadisticaDTO));
        }
    }

    /**
     * Este método permite obtener todas las estadísticas de la base de datos
     * @return
     */
    @Override
    public List<EstadisticaDTO> getEstadisticas() {
        return EstadisticaMapper.convertirLista(estadisticaRepository.findAll());
    }

}
