package com.aulanosa.api.services;

import com.aulanosa.api.dtos.SeguirDTO;
import com.aulanosa.api.error.IdNotFoundException;

public interface SeguirService {
    SeguirDTO seguirJugador(SeguirDTO seguirDTO) throws IdNotFoundException;
}
