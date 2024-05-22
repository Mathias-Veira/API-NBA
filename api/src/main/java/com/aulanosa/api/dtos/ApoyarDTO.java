package com.aulanosa.api.dtos;

public class ApoyarDTO {
    private int idUsuario;
    private int idEquipo;

    public ApoyarDTO() {

    }

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
