package com.cipy.examen.converter;

import com.cipy.examen.entity.Alumno;
import com.cipy.examen.entity.Carrera;
import com.cipy.examen.model.request.AlumnoRequest;
import com.cipy.examen.model.response.AlumnoResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AlumnoConverter {
    
    @Autowired
    private CarreraConverter carreraConverter;

    public AlumnoResponse entityToModel(Alumno entity) {
        AlumnoResponse alumno = new AlumnoResponse();
        alumno.setId(entity.getId());
        alumno.setNombre(entity.getNombre());
        alumno.setApellido(entity.getApellido());
        alumno.setCedula(entity.getCedula());
        alumno.setEdad(entity.getEdad());
        alumno.setCarrera(carreraConverter.entityToModel(entity.getCarrerasId()));
        return alumno;
    }
    
    public List<AlumnoResponse> entitiesToModel(List<Alumno> entities){
        
        List<AlumnoResponse> alumnos = new ArrayList<>();
        
        for (Alumno alumno : entities) {
            alumnos.add(entityToModel(alumno));
        }
        return alumnos;
    }
    
    public Alumno modelToEntity(AlumnoRequest model) {
        Alumno alumno = new Alumno();
        alumno.setId(model.getId());
        alumno.setNombre(model.getNombre());
        alumno.setApellido(model.getApellido());
        alumno.setCedula(model.getCedula());
        alumno.setEdad(model.getEdad());
        Carrera carrera = new Carrera();
        carrera.setCarrerasId(model.getCarrera());
        alumno.setCarrerasId(carrera);
        return alumno;
    }

}
