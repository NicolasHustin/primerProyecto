package com.cipy.examen.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "carreras")

//ver comentarios de la clase Alumnos.
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "carreras_id")
    private Integer carrerasId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carrerasId")
    private Collection<Alumno> alumnosCollection;

    public Carrera() {
    }

    public Carrera(Integer carrerasId) {
        this.carrerasId = carrerasId;
    }

    public Carrera(Integer carrerasId, String descripcion) {
        this.carrerasId = carrerasId;
        this.descripcion = descripcion;
    }

    public Integer getCarrerasId() {
        return carrerasId;
    }

    public void setCarrerasId(Integer carrerasId) {
        this.carrerasId = carrerasId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Alumno> getAlumnosCollection() {
        return alumnosCollection;
    }

    public void setAlumnosCollection(Collection<Alumno> alumnosCollection) {
        this.alumnosCollection = alumnosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carrerasId != null ? carrerasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.carrerasId == null && other.carrerasId != null) || (this.carrerasId != null && !this.carrerasId.equals(other.carrerasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cipy.examen.Carreras[ carrerasId=" + carrerasId + " ]";
    }

}
