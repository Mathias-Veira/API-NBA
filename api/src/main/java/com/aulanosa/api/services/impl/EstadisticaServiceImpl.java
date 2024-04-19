package com.aulanosa.api.services.impl;

import com.aulanosa.api.dtos.EquipoDTO;
import com.aulanosa.api.dtos.EstadisticaDTO;
import com.aulanosa.api.repositories.EstadisticaRepository;
import com.aulanosa.api.services.EstadisticaService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EstadisticaServiceImpl implements EstadisticaService {

    @Autowired
    private EstadisticaRepository estadisticaRepository;

    private List<EstadisticaDTO> obtenerPromedios(){
        List<EstadisticaDTO> promedios = new ArrayList<>();
        try {
            URL url = new URL("https://api.balldontlie.io/v1/season_averages");
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

                for (int i = 0; i < jsonArray.length() - 15; i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    EquipoDTO equipoDTO = new EquipoDTO();
                    equipoDTO.setIdEquipo(jsonObject.getInt("id"));
                    equipoDTO.setConferenciaEquipo(jsonObject.getString("conference"));
                    equipoDTO.setDivisionEquipo(jsonObject.getString("division"));
                    equipoDTO.setCiudadEquipo(jsonObject.getString("city"));
                    equipoDTO.setNombreEquipo(jsonObject.getString("name"));
                    equipoDTO.setAbreviacionEquipo(jsonObject.getString("abbreviation"));
                    equipoDTO.setImagenEquipo("assets/img_teams/" + equipoDTO.getCiudadEquipo() + " " + equipoDTO.getNombreEquipo() + ".png");
                    equipoDTO.setPuestoConferencia(0);
                    equipoDTO.setPuestoDivision(0);
                    equipoDTO.setnVictorias(0);
                    equipoDTO.setnDerrotas(0);
                    equipoDTO.setPorcentajeVictorias(0.0);
                    //promedios.add(equipoDTO);
                }
                System.out.println("TODO BIEN");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return promedios;
    }

    @Override
    public void insertarEstadisticas() {

    }
}
