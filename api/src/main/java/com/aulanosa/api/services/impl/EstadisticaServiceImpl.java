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
    private List<EstadisticaDTO> obtenerPromedios(){
        List<EstadisticaDTO> promedios = new ArrayList<>();
        List<JugadorDTO> jugadores = jugadorService.obtenerJugadoresTemporada();
        int[] playerIds = jugadores.stream().mapToInt(JugadorDTO::getIdJugador).toArray();

        String playerIdParams = IntStream.of(playerIds)
                .mapToObj(id -> "player_ids[]=" + id)
                .collect(Collectors.joining("&"));

        try {
            URL url = new URL("https://api.balldontlie.io/v1/season_averages?season=2023&" + playerIdParams);
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

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return promedios;
    }

    @Override
    //@Scheduled(cron = "0 59 23 23 10 ?")
    //@PostConstruct
    public void insertarEstadisticas() {
        List<EstadisticaDTO> promedios = obtenerPromedios();
        for (EstadisticaDTO estadisticaDTO: promedios) {
            estadisticaRepository.save(EstadisticaMapper.convertirAModelo(estadisticaDTO));
        }
    }

}
