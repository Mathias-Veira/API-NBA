package com.aulanosa.api.services;

import com.aulanosa.api.dtos.ApoyarDTO;
import com.aulanosa.api.error.IdNotFoundException;

public interface ApoyarService {
    ApoyarDTO apoyarEquipo(ApoyarDTO apoyarDTO) throws IdNotFoundException;
}
