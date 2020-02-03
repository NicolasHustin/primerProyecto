package com.cipy.examen.entity;

import com.cipy.examen.entity.Alumno;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-06T14:19:23")
@StaticMetamodel(Carrera.class)
public class Carrera_ { 

    public static volatile SingularAttribute<Carrera, String> descripcion;
    public static volatile SingularAttribute<Carrera, Integer> carrerasId;
    public static volatile CollectionAttribute<Carrera, Alumno> alumnosCollection;

}