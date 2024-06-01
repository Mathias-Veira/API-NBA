package com.aulanosa.api.services.impl;

import com.aulanosa.api.dtos.EquipoDTO;
import com.aulanosa.api.dtos.JugadorDTO;
import com.aulanosa.api.mappers.JugadorMapper;
import com.aulanosa.api.repositories.JugadorRepository;
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
import java.util.*;

@Service
@Lazy
@Component
public class JugadorServiceImpl implements JugadorService {
    @Autowired
    private JugadorRepository jugadorRepository;

    /**
     * Este método permite insertar los jugadores en base de datos mediante una api externa
     * @return devuelve la lista de objetos JugadorDTO
     */
    private List<JugadorDTO> insertarJugadores() {
        boolean playerFinished = false;
        List<JugadorDTO> jugadores = new ArrayList<>();
        int cont = 1;
        int cursor = 0;

        try {
            while (cont <= 30) {
                playerFinished = false;
                cursor = 0;
                while (!playerFinished) {
                    URL url = new URL("https://api.balldontlie.io/v1/players?team_ids[]=" + cont + "&per_page=100&cursor=" + cursor);
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
                        JSONObject meta = new JSONObject(information.toString()).getJSONObject("meta");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            JugadorDTO jugadorDTO = new JugadorDTO();
                            jugadorDTO.setIdJugador(jsonObject.getInt("id"));
                            jugadorDTO.setIdEquipo(jsonObject.getJSONObject("team").getInt("id"));
                            jugadorDTO.setNombreJugador(jsonObject.getString("first_name"));
                            jugadorDTO.setApellidoJugador(jsonObject.getString("last_name"));
                            jugadorDTO.setPosicionJugador(jsonObject.getString("position"));
                            if (!jsonObject.isNull("height")) {
                                jugadorDTO.setAlturaJugador(jsonObject.getString("height"));
                            }

                            if (!jsonObject.isNull("weight")) {
                                jugadorDTO.setPesoJugador(jsonObject.optInt("weight", 0));
                            }
                            if (!jsonObject.isNull("jersey_number")) {
                                jugadorDTO.setNumeroCamiseta(jsonObject.optInt("jersey_number", -1));
                            }

                            if (!jsonObject.isNull("college")) {
                                jugadorDTO.setUniversidad(jsonObject.getString("college"));
                            }

                            if (!jsonObject.isNull("country")) {
                                jugadorDTO.setProcedenciaJugador(jsonObject.getString("country"));
                            }

                            if (!jsonObject.isNull("draft_year")) {
                                jugadorDTO.setAnioDraft(jsonObject.getInt("draft_year"));
                            }
                            if (!jsonObject.isNull("draft_round")) {
                                jugadorDTO.setRondaDraft(jsonObject.getInt("draft_round"));
                            }
                            if (!jsonObject.isNull("draft_number")) {
                                jugadorDTO.setNumeroDraft(jsonObject.getInt("draft_number"));
                            }
                            jugadores.add(jugadorDTO);
                        }
                        if (meta.has("next_cursor")) {
                            cursor = meta.getInt("next_cursor");
                        } else {
                            playerFinished = true;
                        }
                    }
                }
                cont++;
            }
            System.out.println("TODO BIEN JUGADORES");
        } catch (
                Exception e) {
            e.printStackTrace();
        }

        return jugadores;
    }

    /**
     * Este método permite almacenar los jugadores en la base de datos
     */
    @Override
    @Scheduled(cron = "0 59 23 23 10 ?")
    public void almacenarJugadores() {

        List<JugadorDTO> jugadores = insertarJugadores();
        for (JugadorDTO jugador : jugadores) {
            jugadorRepository.save(JugadorMapper.convertirAModelo(jugador));
        }
    }

    /**
     * Este método permite obtener todos los jugadores de esta temporada
     * @return devuelve una lista de objetos JugadorDTO
     */
    @Override
    public List<JugadorDTO> obtenerJugadoresTemporada() {
        return JugadorMapper.convertirLista(jugadorRepository.listarJugadores());
    }

    /**
     * Este método permite obtener un jugador por su id
     * @param idJugador identificador del jugador
     * @return objeto JugadorDTO
     */
    @Override
    public JugadorDTO getJugadorById(int idJugador) {
        return JugadorMapper.convertirADTO(jugadorRepository.getPlayerById(idJugador));
    }

}
