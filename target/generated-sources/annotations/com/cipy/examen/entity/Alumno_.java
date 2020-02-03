package com.cipy.examen.entity;

import com.cipy.examen.entity.Carrera;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-06T14:19:23")
@StaticMetamodel(Alumno.class)
public class Alumno_ { 

    public static volatile SingularAttribute<Alumno, String> cedula;
    public static volatile SingularAttribute<Alumno, Carrera> carrerasId;
    public static volatile SingularAttribute<Alumno, String> apellido;
    public static volatile SingularAttribute<Alumno, Integer> id;
    public static volatile SingularAttribute<Alumno, String> nombre;
    public static volatile SingularAttribute<Alumno, Integer> edad;

}