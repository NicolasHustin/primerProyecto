
package com.cipy.examen.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "alumnos")

public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    // el Id al ser entre otras palabras el id no precisa del not null, ya que esta NO puede ser null
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //el basic funciona para que en caso de null te tire null y no un error
    @Basic(optional = false)
    //el column es para llamar a la tabla
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    //not null es para que no permita que ese campo sea null
    @NotNull
    //size seria el tamaño del String
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido")
    private String apellido;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cedula")
    private String cedula;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    
    //aqui podemos ver como se crea la relacion 
    @JoinColumn(name = "carreras_id", referencedColumnName = "carreras_id")
    @ManyToOne(optional = false)
    private Carrera carrerasId;

    //constructor para alumno
    public Alumno() {
    }

    public Alumno(Integer id) {
        this.id = id;
    }

    //Constructor para alumno
    public Alumno(Integer id, String nombre, String apellido, String cedula, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
    }

    //respectivos getter and setter para los atributos de Alumnos
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Carrera getCarrerasId() {
        return carrerasId;
    }

    public void setCarrerasId(Carrera carrerasId) {
        this.carrerasId = carrerasId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cipy.examen.Alumnos[ id=" + id + " ]";
    }

}
