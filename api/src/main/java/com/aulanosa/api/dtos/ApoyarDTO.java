package com.aulanosa.api.dtos;
/**
 * Esta clase representa los datos de la tabla que relaciona los usuarios con los equipos
 */
public class ApoyarDTO {
    private int idUsuario;
    private int idEquipo;

    /**
     * Constructor vacío
     */
    public ApoyarDTO() {

    }

    /**
     * Concstructor completo
     * @param idUsuario identificador del usuario
     * @param idEquipo identificador del equipo
     */
    public ApoyarDTO(int idUsuario, int idEquipo) {
        this.idUsuario = idUsuario;
        this.idEquipo = idEquipo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
}
