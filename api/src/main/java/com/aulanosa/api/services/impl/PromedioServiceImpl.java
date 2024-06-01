package com.aulanosa.api.services.impl;

import com.aulanosa.api.dtos.JugadorDTO;
import com.aulanosa.api.dtos.PromedioDTO;
import com.aulanosa.api.error.IdNotFoundException;
import com.aulanosa.api.mappers.PromedioMapper;
import com.aulanosa.api.repositories.PromedioRepository;
import com.aulanosa.api.services.PromedioService;
import com.aulanosa.api.services.SeguirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Lazy
@Component
public class PromedioServiceImpl implements PromedioService {
    @Autowired
    private PromedioRepository promedioRepository;
    @Autowired
    private SeguirService seguirService;

    /**
     * Este método permite obtener los máximos anotadores de la liga
     * @return lista de objetos PromedioDTO
     */
    @Override
    public List<PromedioDTO> getMaximosAnotadores() {
        return PromedioMapper.convertirLista(promedioRepository.getMaximosAnotadores());
    }

    /**
     * Este método permite obtener los máximos asistentes de la liga
     * @return lista de obejtos PromedioDTO
     */
    @Override
    public List<PromedioDTO> getMaximosAsistentes() {
        return PromedioMapper.convertirLista(promedioRepository.getMaximosAsistentes());
    }

    /**
     * Este método permite obtener los máximos reboteadores de la liga
     * @return lista de objetos PromedioDTO
     */
    @Override
    public List<PromedioDTO> getMaximosReboteadores() {
        return PromedioMapper.convertirLista(promedioRepository.getMaximosReboteadores());
    }

    /**
     * Este método permite obtener los jugadores con más pérdidas
     * @return lista de objetos PromedioDTO
     */
    @Override
    public List<PromedioDTO> getMaxPerdidas() {
       return PromedioMapper.convertirLista(promedioRepository.getMaxPerdidas());
    }

    /**
     * Este método permite obtener los jugadores con más robos
     * @return lista de objetos PromedioDTO
     */
    @Override
    public List<PromedioDTO> getMaxRobos() {
        return PromedioMapper.convertirLista(promedioRepository.getMaxRobos());
    }

    /**
     * Este método permite obtener los jugadores con más tapones
     * @return lista de objetos PromedioDTO
     */
    @Override
    public List<PromedioDTO> getMaximosTaponadores() {
        return PromedioMapper.convertirLista(promedioRepository.getMaximosTaponadores());
    }

    /**
     * Este método permite obtener los promedios de los jugadores que sigue un usuario
     * @param idUsuario identificador del usuario
     * @return lista de obejtos PromedioDTO
     * @throws IdNotFoundException Excepción personalizada que se lanza cuando el identificador del usuario no existe
     */
    @Override
    public List<PromedioDTO> getPromedioJugadoresSeguidos(int idUsuario) throws IdNotFoundException {
        List<PromedioDTO> promedios = new ArrayList<>();
        List<JugadorDTO> jugadores;
        try {
            jugadores = seguirService.obtenerJugadoresSeguidos(idUsuario);
            for (JugadorDTO jugadorDTO: jugadores) {
                promedios.addAll(PromedioMapper.convertirLista(promedioRepository.getPromedioJugadoresSeguidos(jugadorDTO.getIdJugador())));
            }
            return promedios;
        }catch (RuntimeException e){
            throw new IdNotFoundException("El id no existe");
        }
    }
}
