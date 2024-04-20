package com.aulanosa.api.services.impl;

import com.aulanosa.api.dtos.EquipoDTO;
import com.aulanosa.api.dtos.JugadorDTO;
import com.aulanosa.api.mappers.JugadorMapper;
import com.aulanosa.api.repositories.JugadorRepository;
import com.aulanosa.api.services.EquipoService;
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
@Service
@Lazy
@Component
public class JugadorServiceImpl implements JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;


    private List<JugadorDTO> insertarJugadores(){

        List<JugadorDTO> jugadores = new ArrayList<>();
        int cursor = 1301;
        try {
            URL url = new URL("https://api.balldontlie.io/v1/players?cursor=" + cursor + "&per_page=100");
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
                    JugadorDTO jugadorDTO = new JugadorDTO();
                    jugadorDTO.setIdJugador(jsonObject.getInt("id"));
                    jugadorDTO.setIdEquipo(jsonObject.getJSONObject("team").getInt("id"));
                    jugadorDTO.setNombreJugador(jsonObject.getString("first_name"));
                    jugadorDTO.setApellidoJugador(jsonObject.getString("last_name"));
                    jugadorDTO.setPosicionJugador(jsonObject.getString("position"));
                    // Altura del jugador
                    if (!jsonObject.isNull("height")) {
                        jugadorDTO.setAlturaJugador(jsonObject.getString("height"));
                    }

                    // Peso del jugador
                    if (!jsonObject.isNull("weight")) {
                        jugadorDTO.setPesoJugador(jsonObject.optInt("weight",0));
                    }

                    // Número de camiseta
                    if (!jsonObject.isNull("jersey_number")) {
                        jugadorDTO.setNumeroCamiseta(jsonObject.optInt("jersey_number",-1));
                    }

                    // Universidad del jugador
                    if (!jsonObject.isNull("college")) {
                        jugadorDTO.setUniversidad(jsonObject.getString("college"));
                    }

                    // Procedencia del jugador
                    if (!jsonObject.isNull("country")) {
                        jugadorDTO.setProcedenciaJugador(jsonObject.getString("country"));
                    }

                    // Año de draft
                    if (!jsonObject.isNull("draft_year")) {
                        jugadorDTO.setAnioDraft(jsonObject.getInt("draft_year"));
                    }

                    // Ronda de draft
                    if (!jsonObject.isNull("draft_round")) {
                        jugadorDTO.setRondaDraft(jsonObject.getInt("draft_round"));
                    }

                    // Número de draft
                    if (!jsonObject.isNull("draft_number")) {
                        jugadorDTO.setNumeroDraft(jsonObject.getInt("draft_number"));
                    }
                    jugadores.add(jugadorDTO);
                }

                System.out.println("TODO BIEN");
                System.out.println(new JSONObject(information.toString()).getJSONObject("meta").getInt("next_cursor"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jugadores;
    }
    @Override
    @Scheduled(cron = "0 59 23 23 10 ?")
    public void almacenarJugadores() {

        List<JugadorDTO> jugadores = insertarJugadores();
        for (JugadorDTO jugador: jugadores) {
            jugadorRepository.save(JugadorMapper.convertirAModelo(jugador));
        }

    }

    @Override
    public List<Integer> obtenerJugadoresTemporada() {
        List<Integer> ids = jugadorRepository.listarJugadores();
        return ids;
    }
}
