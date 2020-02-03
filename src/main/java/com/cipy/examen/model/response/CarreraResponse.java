package com.cipy.examen.model.response;

import java.io.Serializable;

public class CarreraResponse implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer carreraID;
    private String descripcion;

    public Integer getCarreraID() {
        return carreraID;
    }

    public void setCarreraID(Integer carreraID) {
        this.carreraID = carreraID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
