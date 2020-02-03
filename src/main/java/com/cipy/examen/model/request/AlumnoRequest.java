
package com.cipy.examen.model.request;

import java.io.Serializable;


public class AlumnoRequest implements Serializable{
    
    private static final long serialVersionUID = 1L ;
    private Integer id ;
    private String nombre ;
    private String apellido;
    private String cedula ;
    private Integer edad ;
    private Integer carrera;

    public Integer getCarrera() {
        return carrera;
    }

    public void setCarrera(Integer carrera) {
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
