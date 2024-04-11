package com.aulanosa.api.services.impl;

import com.aulanosa.api.dtos.EquipoDTO;
import com.aulanosa.api.mappers.EquipoMapper;
import com.aulanosa.api.repositories.EquipoRepository;
import com.aulanosa.api.services.EquipoService;
import jakarta.annotation.PostConstruct;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;
@Service
@Lazy
public class EquipoServiceImpl implements EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;


    public List<EquipoDTO> obtenerEquipos() {
        List<EquipoDTO> equipos = new ArrayList<>();
        try {
            URL url = new URL("https://api.balldontlie.io/v1/teams");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization","475f2ca9-26a3-4a5b-a3d8-2942adc3f3ad");
            connection.setRequestMethod("GET");

            connection.connect();
            int code = connection.getResponseCode();

            if(code!=200){
                System.out.println("Se produjo un error: " + code);
                System.out.println(connection.getResponseMessage());
            }else{
                StringBuilder information = new StringBuilder();
                Scanner sc = new Scanner(connection.getInputStream());

                while (sc.hasNext()){
                    information.append(sc.nextLine());
                }

                sc.close();

                JSONArray jsonArray = new JSONObject(information.toString()).getJSONArray("data");

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    EquipoDTO equipoDTO = new EquipoDTO();
                    equipoDTO.setIdEquipo(jsonObject.getInt("id"));
                    equipoDTO.setConferenciaEquipo(jsonObject.getString("conference"));
                    equipoDTO.setDivisionEquipo(jsonObject.getString("division"));
                    equipoDTO.setCiudadEquipo(jsonObject.getString("city"));
                    equipoDTO.setNombreEquipo(jsonObject.getString("name"));
                    equipoDTO.setAbreviacionEquipo(jsonObject.getString("abbreviation"));
                    equipos.add(equipoDTO);
                }
                System.out.println("TODO BIEN");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return equipos;
    }



    @Override
    @PostConstruct
    public void almacenarEquipo() {
        List<EquipoDTO> equipos = obtenerEquipos();
        for (EquipoDTO equipo: equipos) {
            equipoRepository.save(EquipoMapper.convertirAModelo(equipo));
        }
    }
}
