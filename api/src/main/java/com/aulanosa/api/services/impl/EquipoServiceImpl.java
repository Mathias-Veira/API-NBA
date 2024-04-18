package com.aulanosa.api.services.impl;

import com.aulanosa.api.dtos.EquipoDTO;
import com.aulanosa.api.mappers.EquipoMapper;
import com.aulanosa.api.models.Equipo;
import com.aulanosa.api.repositories.EquipoRepository;
import com.aulanosa.api.services.EquipoService;
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

    /**
     * Este método recupera los equipos de la base de datos
     * @return lista de EquipoDTO
     */
    @Override
    public List<EquipoDTO> getTeams(){
        return EquipoMapper.convertirLista(equipoRepository.findAll());
    }

    /**
     * Este método realiza una petición a una api externa y actualiza los equipos con información
     * actualizada de las clasificaciones
     * @return lista de equipoDTO
     */
    private List<EquipoDTO> updateTeams() {
        List<EquipoDTO> equipos = EquipoMapper.convertirLista(equipoRepository.findAll());
        try {
            /*
            URL url = new URL("https://sports-information.p.rapidapi.com/nba/standings?year=2023&group=conference\"");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("X-RapidAPI-Host", "sports-information.p.rapidapi.com");
            connection.setRequestProperty("X-RapidAPI-Key", System.getenv("SPORTS_INFORMATION"));
            connection.setRequestMethod("GET");

            connection.connect();

            int code = 200;



            if (code != 200) {
                System.out.println("Se produjo un error: " + code);
                System.out.println(connection.getResponseMessage());
            } else {
                StringBuilder information = new StringBuilder();
                Scanner sc = new Scanner(connection.getInputStream());

                while (sc.hasNext()) {
                    information.append(sc.nextLine());
                }
                System.out.println(information.toString());
                sc.close();

             */
            StringBuilder information = new StringBuilder();
            information.append("{\n" +
                    "    \"uid\": \"s:40~l:46~g:7\",\n" +
                    "    \"id\": \"7\",\n" +
                    "    \"name\": \"National Basketball Association\",\n" +
                    "    \"abbreviation\": \"NBA\",\n" +
                    "    \"shortName\": \"NBA\",\n" +
                    "    \"standings\": {\n" +
                    "        \"id\": \"1\",\n" +
                    "        \"name\": \"expanded\",\n" +
                    "        \"displayName\": \"Expanded Standings\",\n" +
                    "        \"links\": [\n" +
                    "            {\n" +
                    "                \"language\": \"en-US\",\n" +
                    "                \"rel\": [\n" +
                    "                    \"standings\",\n" +
                    "                    \"desktop\"\n" +
                    "                ],\n" +
                    "                \"href\": \"https://www.espn.com/nba/standings/_/group/7\",\n" +
                    "                \"text\": \"Table\",\n" +
                    "                \"shortText\": \"Standings\",\n" +
                    "                \"isExternal\": false,\n" +
                    "                \"isPremium\": false\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"season\": 2024,\n" +
                    "        \"seasonType\": 2,\n" +
                    "        \"seasonDisplayName\": \"2023-24\",\n" +
                    "        \"entries\": [\n" +
                    "            {\n" +
                    "                \"team\": {\n" +
                    "                    \"id\": \"25\",\n" +
                    "                    \"uid\": \"s:40~l:46~t:25\",\n" +
                    "                    \"location\": \"Oklahoma City\",\n" +
                    "                    \"name\": \"Thunder\",\n" +
                    "                    \"abbreviation\": \"OKC\",\n" +
                    "                    \"displayName\": \"Oklahoma City Thunder\",\n" +
                    "                    \"shortDisplayName\": \"Thunder\",\n" +
                    "                    \"isActive\": true,\n" +
                    "                    \"logos\": [\n" +
                    "                        {\n" +
                    "                            \"href\": \"https://a.espncdn.com/i/teamlogos/nba/500/scoreboard/okc.png\",\n" +
                    "                            \"width\": 500,\n" +
                    "                            \"height\": 500,\n" +
                    "                            \"alt\": \"\",\n" +
                    "                            \"rel\": [\n" +
                    "                                \"full\",\n" +
                    "                                \"scoreboard\"\n" +
                    "                            ],\n" +
                    "                            \"lastUpdated\": \"2023-08-28T20:32Z\"\n" +
                    "                        },\n" +
                    "                        {\n" +
                    "                            \"href\": \"https://a.espncdn.com/i/teamlogos/nba/500-dark/scoreboard/okc.png\",\n" +
                    "                            \"width\": 500,\n" +
                    "                            \"height\": 500,\n" +
                    "                            \"alt\": \"\",\n" +
                    "                            \"rel\": [\n" +
                    "                                \"full\",\n" +
                    "                                \"scoreboard\",\n" +
                    "                                \"dark\"\n" +
                    "                            ],\n" +
                    "                            \"lastUpdated\": \"2023-08-28T20:39Z\"\n" +
                    "                        }\n" +
                    "                    ],\n" +
                    "                    \"links\": [\n" +
                    "                        {\n" +
                    "                            \"language\": \"en-US\",\n" +
                    "                            \"rel\": [\n" +
                    "                                \"clubhouse\",\n" +
                    "                                \"desktop\",\n" +
                    "                                \"team\"\n" +
                    "                            ],\n" +
                    "                            \"href\": \"https://www.espn.com/nba/team/_/name/okc/oklahoma-city-thunder\",\n" +
                    "                            \"text\": \"Clubhouse\",\n" +
                    "                            \"shortText\": \"Clubhouse\",\n" +
                    "                            \"isExternal\": false,\n" +
                    "                            \"isPremium\": false\n" +
                    "                        }\n" +
                    "                    ]\n" +
                    "                },\n" +
                    "                \"stats\": [\n" +
                    "                    {\n" +
                    "                        \"name\": \"avgPointsAgainst\",\n" +
                    "                        \"displayName\": \"Opponent Points Per Game\",\n" +
                    "                        \"shortDisplayName\": \"OPP PPG\",\n" +
                    "                        \"description\": \"Opponent Points Per Game\",\n" +
                    "                        \"abbreviation\": \"OPP PPG\",\n" +
                    "                        \"type\": \"avgpointsagainst\",\n" +
                    "                        \"value\": 112.67073,\n" +
                    "                        \"displayValue\": \"112.7\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"name\": \"avgPointsFor\",\n" +
                    "                        \"displayName\": \"Points Per Game\",\n" +
                    "                        \"shortDisplayName\": \"PPG\",\n" +
                    "                        \"description\": \"Points Per Game\",\n" +
                    "                        \"abbreviation\": \"PPG\",\n" +
                    "                        \"type\": \"avgpointsfor\",\n" +
                    "                        \"value\": 120.085365,\n" +
                    "                        \"displayValue\": \"120.1\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"name\": \"clincher\",\n" +
                    "                        \"displayName\": \"Clincher\",\n" +
                    "                        \"shortDisplayName\": \"CLINCH\",\n" +
                    "                        \"description\": \"Clinched Conference\",\n" +
                    "                        \"abbreviation\": \"CLINCH\",\n" +
                    "                        \"type\": \"clincher\",\n" +
                    "                        \"value\": 3,\n" +
                    "                        \"displayValue\": \"z\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"name\": \"differential\",\n" +
                    "                        \"displayName\": \"Average Point Differential\",\n" +
                    "                        \"shortDisplayName\": \"DIFF\",\n" +
                    "                        \"description\": \"Average Point Differential\",\n" +
                    "                        \"abbreviation\": \"DIFF\",\n" +
                    "                        \"type\": \"differential\",\n" +
                    "                        \"value\": 7.3999999999999915,\n" +
                    "                        \"displayValue\": \"+7.4\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"name\": \"divisionWinPercent\",\n" +
                    "                        \"displayName\": \"Division Win Percentage\",\n" +
                    "                        \"shortDisplayName\": \"DPCT\",\n" +
                    "                        \"description\": \"Division Winning Percentage\",\n" +
                    "                        \"abbreviation\": \"DPCT\",\n" +
                    "                        \"type\": \"divisionwinpercent\",\n" +
                    "                        \"value\": 0.75,\n" +
                    "                        \"displayValue\": \"0.750\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"name\": \"gamesBehind\",\n" +
                    "                        \"displayName\": \"Games Back\",\n" +
                    "                        \"shortDisplayName\": \"GB\",\n" +
                    "                        \"description\": \"Games Back\",\n" +
                    "                        \"abbreviation\": \"GB\",\n" +
                    "                        \"type\": \"gamesbehind\",\n" +
                    "                        \"value\": 7,\n" +
                    "                        \"displayValue\": \"7\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"name\": \"leagueWinPercent\",\n" +
                    "                        \"displayName\": \"League Win Percentage\",\n" +
                    "                        \"shortDisplayName\": \"LPCT\",\n" +
                    "                        \"description\": \"League Winning Percentage\",\n" +
                    "                        \"abbreviation\": \"LPCT\",\n" +
                    "                        \"type\": \"leaguewinpercent\",\n" +
                    "                        \"value\": 0.6923077,\n" +
                    "                        \"displayValue\": \"0.692\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"name\": \"losses\",\n" +
                    "                        \"displayName\": \"Losses\",\n" +
                    "                        \"shortDisplayName\": \"L\",\n" +
                    "                        \"description\": \"Losses\",\n" +
                    "                        \"abbreviation\": \"L\",\n" +
                    "                        \"type\": \"losses\",\n" +
                    "                        \"value\": 25,\n" +
                    "                        \"displayValue\": \"25\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"name\": \"playoffSeed\",\n" +
                    "                        \"displayName\": \"Position\",\n" +
                    "                        \"shortDisplayName\": \"POS\",\n" +
                    "                        \"description\": \"Projected seed in the NBA Playoffs, according to BPI\",\n" +
                    "                        \"abbreviation\": \"SEED\",\n" +
                    "                        \"type\": \"playoffseed\",\n" +
                    "                        \"value\": 1,\n" +
                    "                        \"displayValue\": \"1\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"name\": \"pointDifferential\",\n" +
                    "                        \"displayName\": \"Point Differential\",\n" +
                    "                        \"shortDisplayName\": \"DIFF\",\n" +
                    "                        \"description\": \"Point Differential\",\n" +
                    "                        \"abbreviation\": \"DIFF\",\n" +
                    "                        \"type\": \"pointdifferential\",\n" +
                    "                        \"value\": 608,\n" +
                    "                        \"displayValue\": \"+608\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"name\": \"streak\",\n" +
                    "                        \"displayName\": \"Streak\",\n" +
                    "                        \"shortDisplayName\": \"STRK\",\n" +
                    "                        \"description\": \"Current Streak\",\n" +
                    "                        \"abbreviation\": \"STRK\",\n" +
                    "                        \"type\": \"streak\",\n" +
                    "                        \"value\": 5,\n" +
                    "                        \"displayValue\": \"W5\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"name\": \"winPercent\",\n" +
                    "                        \"displayName\": \"Win Percentage\",\n" +
                    "                        \"shortDisplayName\": \"PCT\",\n" +
                    "                        \"description\": \"Winning Percentage\",\n" +
                    "                        \"abbreviation\": \"PCT\",\n" +
                    "                        \"type\": \"winpercent\",\n" +
                    "                        \"value\": 0.69512194,\n" +
                    "                        \"displayValue\": \".695\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"name\": \"wins\",\n" +
                    "                        \"displayName\": \"Wins\",\n" +
                    "                        \"shortDisplayName\": \"W\",\n" +
                    "                        \"description\": \"Wins\",\n" +
                    "                        \"abbreviation\": \"W\",\n" +
                    "                        \"type\": \"wins\",\n" +
                    "                        \"value\": 57,\n" +
                    "                        \"displayValue\": \"57\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"id\": \"904\",\n" +
                    "                        \"name\": \"League Standings\",\n" +
                    "                        \"abbreviation\": \"League\",\n" +
                    "                        \"type\": \"leaguestandings\",\n" +
                    "                        \"summary\": \"57-25\",\n" +
                    "                        \"displayValue\": \"57-25\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"id\": \"902\",\n" +
                    "                        \"name\": \"Three Points\",\n" +
                    "                        \"abbreviation\": \"3 PT Games\",\n" +
                    "                        \"displayName\": \"Games Decided by 3 Points or Less\",\n" +
                    "                        \"shortDisplayName\": \"3 PT Games\",\n" +
                    "                        \"description\": \"Record in games decided by 3 points or less\",\n" +
                    "                        \"type\": \"threepoints\",\n" +
                    "                        \"summary\": \"6-3\",\n" +
                    "                        \"displayValue\": \"6-3\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"id\": \"903\",\n" +
                    "                        \"name\": \"Ten Points\",\n" +
                    "                        \"abbreviation\": \"10 PT Games\",\n" +
                    "                        \"displayName\": \"Games Decided by 10 Points or more\",\n" +
                    "                        \"shortDisplayName\": \"10 PT Games\",\n" +
                    "                        \"description\": \"Record in games decided by 10 points or more\",\n" +
                    "                        \"type\": \"tenpoints\",\n" +
                    "                        \"summary\": \"32-10\",\n" +
                    "                        \"displayValue\": \"32-10\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"id\": \"84\",\n" +
                    "                        \"name\": \"vs. .500 or Better\",\n" +
                    "                        \"abbreviation\": \"vs. .500 and Up\",\n" +
                    "                        \"displayName\": \"vs. Teams .500 and Above\",\n" +
                    "                        \"shortDisplayName\": \"vs. .500 and Above\",\n" +
                    "                        \"description\": \"Record against Teams .500 and Above\",\n" +
                    "                        \"type\": \"vsorbetter\",\n" +
                    "                        \"summary\": \"33-20\",\n" +
                    "                        \"displayValue\": \"33-20\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"id\": \"85\",\n" +
                    "                        \"name\": \"vs. Below .500\",\n" +
                    "                        \"abbreviation\": \"vs. Below .500\",\n" +
                    "                        \"displayName\": \"vs. Teams Below .500\",\n" +
                    "                        \"shortDisplayName\": \"vs. Below .500\",\n" +
                    "                        \"description\": \"Record against Teams below .500\",\n" +
                    "                        \"type\": \"vsbelow\",\n" +
                    "                        \"summary\": \"24-5\",\n" +
                    "                        \"displayValue\": \"24-5\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"id\": \"307\",\n" +
                    "                        \"name\": \"In Overtime Games\",\n" +
                    "                        \"abbreviation\": \"OT\",\n" +
                    "                        \"displayName\": \"In Overtime Games\",\n" +
                    "                        \"shortDisplayName\": \"OT\",\n" +
                    "                        \"description\": \"Record in overtime games\",\n" +
                    "                        \"type\": \"inovertimegames\",\n" +
                    "                        \"summary\": \"3-1\",\n" +
                    "                        \"displayValue\": \"3-1\"\n" +
                    "                    }\n" +
                    "                ]\n" +
                    "            }\n" +
                    "        ]\n" +
                    "    }\n" +
                    "}\n");
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
    @PostConstruct
    public void almacenarEquipos() {
        /*
        List<EquipoDTO> equipos = obtenerEquipos();
        for (EquipoDTO equipo: equipos) {
            equipoRepository.save(EquipoMapper.convertirAModelo(equipo));
        }

         */


    }

    /**
     * Este método permite actualizar los equipos de la NBA que están en la base de datos con la información
     * necesaria para las clasificaciones
     */
    @Override
    //@Scheduled(cron = "@monthly")
    @PostConstruct
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


}
