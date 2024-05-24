package com.aulanosa.api.services.impl;

import com.aulanosa.api.dtos.EquipoDTO;
import com.aulanosa.api.dtos.JugadorDTO;
import com.aulanosa.api.mappers.EquipoMapper;
import com.aulanosa.api.models.Equipo;
import com.aulanosa.api.repositories.EquipoRepository;
import com.aulanosa.api.services.EquipoService;
import com.aulanosa.api.services.JugadorService;
import jakarta.annotation.PostConstruct;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.time.*;

import org.json.JSONObject;

@Service
@Lazy
@Component
public class EquipoServiceImpl implements EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;
    @Autowired
    private JugadorService jugadorService;

    /**
     * Este método devuelve el ranking de la liga general
     *
     * @return lista de EquipoDTO
     */
    @Override
    public List<EquipoDTO> getLeagueRanking() {
        return EquipoMapper.convertirLista(equipoRepository.getLeagueRanking());
    }

    /**
     * Este método devuelve el ranking por la conferencia
     *
     * @param conference conferencia de la liga
     * @return lista de equipos dto con el ranking por esa conferencia
     */
    @Override
    public List<EquipoDTO> getConferenceRanking(String conference) {
        return EquipoMapper.convertirLista(equipoRepository.getConferenceRanking(conference));
    }

    /**
     * Este método devuelve el ranking de la división
     *
     * @param division división de la que se quiere saber el ranking
     * @return lista de equipo dto con el ranking
     */
    @Override
    public List<EquipoDTO> getDivisionRanking(String division) {
        return EquipoMapper.convertirLista(equipoRepository.getDivisionRanking(division));
    }

    @Override
    public EquipoDTO getTeamById(int idJugador) {
        JugadorDTO jugadorDTO = jugadorService.getJugadorById(idJugador);
        return EquipoMapper.convertirADTO(equipoRepository.getTeamById(jugadorDTO.getIdEquipo()));
    }

    /**
     * Este método realiza una petición a una api externa y actualiza los equipos con información
     * actualizada de las clasificaciones
     *
     * @return lista de equipoDTO
     */
    private List<EquipoDTO> updateTeams() {
        List<EquipoDTO> equipos = EquipoMapper.convertirLista(equipoRepository.findAll());
        StringBuilder information = new StringBuilder();
        try {

            URL url = new URL("https://sports-information.p.rapidapi.com/nba/standings?year=2023&group=conference");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("X-RapidAPI-Host", "sports-information.p.rapidapi.com");
            connection.setRequestProperty("X-RapidAPI-Key", System.getenv("API_NBA"));
            connection.setRequestMethod("GET");

            connection.connect();

            int code = connection.getResponseCode();


            if (code != 200) {
                System.out.println("Se produjo un error: " + code);
                System.out.println(connection.getResponseMessage());
            } else {

                Scanner sc = new Scanner(connection.getInputStream());

                while (sc.hasNext()) {
                    information.append(sc.nextLine());
                }

                sc.close();
            }


            JSONObject standings = new JSONObject(information.toString()).getJSONObject("standings");
            JSONArray jsonArray = standings.getJSONArray("entries");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                for (int j = 0; j < equipos.size(); j++) {
                    if (jsonObject.getJSONObject("team").getString("abbreviation").equals(equipos.get(j).getAbreviacionEquipo())) {
                        JSONArray stats = jsonObject.getJSONArray("stats");
                        for (int k = 0; k < stats.length(); k++) {
                            JSONObject statsObject = stats.getJSONObject(k);
                            if (statsObject.getString("displayName").equals("Position")) {
                                equipos.get(j).setPuestoConferencia(statsObject.getInt("value"));

                            } else if (statsObject.getString("displayName").equals("Wins")) {
                                equipos.get(j).setnVictorias(statsObject.getInt("value"));

                            } else if (statsObject.getString("displayName").equals("Losses")) {
                                equipos.get(j).setnDerrotas(statsObject.getInt("value"));
                            } else if (statsObject.getString("displayName").equals("Win Percentage")) {
                                equipos.get(j).setPorcentajeVictorias(statsObject.getDouble("value"));
                                break;
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return equipos;
    }

    /**
     * Este método obtiene los equipos que están en base de datos y mediante una petición a otra api externa
     * actualiza los datos de los puestos en sus diferentes clasificaciones
     *
     * @return lista de equiposDTO con los datos de los equipos actualizados
     */
    private List<EquipoDTO> actualizarEquipos() {
        List<EquipoDTO> equipos = EquipoMapper.convertirLista(equipoRepository.findAll());
        try {
            URL url = new URL("https://api-nba-v1.p.rapidapi.com/standings?league=standard&season=2023");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com");
            connection.setRequestProperty("X-RapidAPI-Key", System.getenv("API_NBA"));
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

                JSONArray jsonArray = new JSONObject(information.toString()).getJSONArray("response");

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    for (int j = 0; j < equipos.size(); j++) {
                        if (jsonObject.getJSONObject("team").getString("code").equals(equipos.get(j).getAbreviacionEquipo())) {
                            equipos.get(j).setPuestoConferencia(jsonObject.getJSONObject("conference").getInt("rank"));
                            equipos.get(j).setPuestoDivision(jsonObject.getJSONObject("division").getInt("rank"));
                            equipos.get(j).setnVictorias(jsonObject.getJSONObject("conference").getInt("win"));
                            equipos.get(j).setnDerrotas(jsonObject.getJSONObject("conference").getInt("loss"));
                            equipos.get(j).setPorcentajeVictorias(jsonObject.getJSONObject("win").getDouble("percentage"));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return equipos;
    }

    /**
     * Este método permite hacer una petición a una api externa y almacenar en una lista los equipos de la NBA
     *
     * @return lista de equiposDTO con los 30 equipos de la NBA
     */
    private List<EquipoDTO> obtenerEquipos() {
        List<EquipoDTO> equipos = new ArrayList<>();
        try {
            URL url = new URL("https://api.balldontlie.io/v1/teams");
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
                    equipos.add(equipoDTO);
                }
                System.out.println("TODO BIEN");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return equipos;
    }

    /**
     * Este método permite almacenar la lista con los equipos de la NBA en la base de datos
     */
    @Override
    @Scheduled(cron = "0 59 23 23 10 ?")
    public void almacenarEquipos() {
        List<EquipoDTO> equipos = obtenerEquipos();
        for (EquipoDTO equipo : equipos) {
            equipoRepository.save(EquipoMapper.convertirAModelo(equipo));
        }

    }

    /**
     * Este método permite actualizar los equipos de la NBA que están en la base de datos con la información
     * necesaria para las clasificaciones
     */
    @Override
    @Scheduled(cron = "0 59 23 23 10 ?")
    public void updateEquipos() {
        List<EquipoDTO> equipos = updateTeams();
        for (EquipoDTO equipoDTO : equipos) {
            Optional<Equipo> equipoRecuperado = equipoRepository.findById(equipoDTO.getIdEquipo());
            if (equipoRecuperado.isPresent()) {
                Equipo equipo = equipoRecuperado.get();
                try {
                    equipo.setNombreEquipo(equipoDTO.getNombreEquipo());
                    equipo.setCiudadEquipo(equipoDTO.getCiudadEquipo());
                    equipo.setAbreviacionEquipo(equipoDTO.getAbreviacionEquipo());
                    equipo.setImagenEquipo(equipoDTO.getImagenEquipo());
                    equipo.setConferenciaEquipo(equipoDTO.getConferenciaEquipo());
                    equipo.setDivisionEquipo(equipoDTO.getDivisionEquipo());
                    equipo.setPuestoConferencia(equipoDTO.getPuestoConferencia());
                    equipo.setPuestoDivision(equipoDTO.getPuestoDivision());
                    equipo.setnVictorias(equipoDTO.getnVictorias());
                    equipo.setnDerrotas(equipoDTO.getnDerrotas());
                    equipo.setPorcentajeVictorias(equipoDTO.getPorcentajeVictorias());
                    equipoRepository.save(equipo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }


    }

    @Override
    public List<EquipoDTO> getAllTeams() {
        return EquipoMapper.convertirLista(equipoRepository.findAll());
    }


}
