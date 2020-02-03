
package com.cipy.examen.model.response;

import java.io.Serializable;


public class AlumnoResponse implements Serializable{
    
    private static final long serialVersionUID = 1L ;
    private Integer id ;
    private String nombre ;
    private String apellido;
    private String cedula ;
    private Integer edad ;
    private CarreraResponse carrera;

    public CarreraResponse getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraResponse carrera) {
        this.carrera = carrera;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    
    
    
}
