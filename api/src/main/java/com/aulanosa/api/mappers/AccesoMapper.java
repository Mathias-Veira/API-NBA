package com.aulanosa.api.mappers;

import com.aulanosa.api.dtos.AccesoDTO;
import com.aulanosa.api.models.Usuario;

/**
 * Esta clase representa la conversión de AccesoDTO a Usuario
 */
public class AccesoMapper {
    /**
     * Método que convierte un objeto AccesoDTO a un objeto Usuario
     * @param accesoDTO objeto AccesoDTO a convertir
     * @return objeto Usuario
     */
    public static Usuario convertirAModelo(AccesoDTO accesoDTO){
        return new Usuario(accesoDTO.getIdUsuario(), accesoDTO.getNombreUsuario(), accesoDTO.getPasswordUsuario());
    }
}
