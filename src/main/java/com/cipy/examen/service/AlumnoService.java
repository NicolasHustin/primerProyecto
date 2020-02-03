
package com.cipy.examen.service;

import com.cipy.examen.converter.AlumnoConverter;
import com.cipy.examen.entity.Alumno;
import com.cipy.examen.model.request.AlumnoRequest;
import com.cipy.examen.model.response.AlumnoResponse;
import com.cipy.examen.repository.AlumnoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {
    
    @Autowired
    private AlumnoRepository alumnoRepository;
    
    @Autowired
    private AlumnoConverter alumnoConverter;
    
    public List<AlumnoResponse> getAll(){
        List<Alumno> alumnos = alumnoRepository.findAll();
        
        if(alumnos != null && !alumnos.isEmpty()){
            return alumnoConverter.entitiesToModel(alumnos);
        }
        return null;
    }
    
    public AlumnoResponse saveOne(AlumnoRequest arequest){
        
        Alumno alumno = alumnoConverter.modelToEntity(arequest);
        alumno = alumnoRepository.save(alumno);
        
                return alumnoConverter.entityToModel(alumno);
    }
    
    public AlumnoResponse updateOne(AlumnoRequest arequest){
        
        
        Alumno alumno = alumnoRepository.findById(arequest.getId()).get();
        
        if (alumno == null){
            return null ;
        }
        
        alumno = alumnoConverter.modelToEntity(arequest);
        alumno = alumnoRepository.save(alumno);
        
        return alumnoConverter.entityToModel(alumno) ;
    }
    
    public void deleteOne(Integer id){
        alumnoRepository.deleteById(id);
    }
    
    public AlumnoResponse getById(Integer id){
        
        Optional<Alumno> alumno=alumnoRepository.findById(id);
        
        if(alumno.isPresent()){
           return alumnoConverter.entityToModel(alumno.get());
        }
        return null;
    }
    
}
