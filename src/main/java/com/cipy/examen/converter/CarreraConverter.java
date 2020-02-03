
package com.cipy.examen.converter;

import com.cipy.examen.entity.Carrera;
import com.cipy.examen.model.request.CarreraRequest;
import com.cipy.examen.model.response.CarreraResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


@Component
public class CarreraConverter {
    
    
     public CarreraResponse entityToModel(Carrera entity) {
        CarreraResponse carrera = new CarreraResponse();
        
        carrera.setCarreraID(entity.getCarrerasId());
        carrera.setDescripcion(entity.getDescripcion());
        
        return carrera;
    }
    
    public List<CarreraResponse> entitiesToModel(List<Carrera> entities){
        
        List<CarreraResponse> carreras = new ArrayList<>();
        
        for (Carrera carrera : entities) {
            carreras.add(entityToModel(carrera));
        }
        return carreras;
    }
    
    public Carrera modelToEntity(CarreraRequest crequest){
        Carrera entity = new Carrera();
        entity.setDescripcion(crequest.getDescripcion());
        entity.setCarrerasId(crequest.getId());
        return entity;
        
    }
    
}
