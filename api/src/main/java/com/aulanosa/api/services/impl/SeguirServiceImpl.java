package com.aulanosa.api.services.impl;

import com.aulanosa.api.dtos.JugadorDTO;
import com.aulanosa.api.dtos.SeguirDTO;
import com.aulanosa.api.error.IdNotFoundException;
import com.aulanosa.api.mappers.JugadorMapper;
import com.aulanosa.api.mappers.SeguirMapper;
import com.aulanosa.api.models.Seguir;
import com.aulanosa.api.models.SeguirId;
import com.aulanosa.api.repositories.SeguirRepository;
import com.aulanosa.api.services.SeguirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Lazy
public class SeguirServiceImpl implements SeguirService {
    @Autowired
    private SeguirRepository seguirRepository;

    @Override
    public SeguirDTO seguirJugador (SeguirDTO seguirDTO) throws IdNotFoundException {
        SeguirId seguirId = new SeguirId(seguirDTO.getIdUsuario(), seguirDTO.getIdJugador());
        Seguir seguir = new Seguir(seguirId);
        seguir.setSeguirId(seguirId);

        try {
            return SeguirMapper.convertirADTO(seguirRepository.save(seguir));
        }catch (RuntimeException e){
            throw new IdNotFoundException("Uno de los id no existe");
        }
    }

    @Override
    public List<JugadorDTO> obtenerJugadoresSeguidos(int idUsuario) throws IdNotFoundException {
        try {
            return JugadorMapper.convertirLista(seguirRepository.listarJugadoresSeguidos(idUsuario));
        }catch (RuntimeException e){
            throw new IdNotFoundException("El id no existe");
        }
    }
}
