
package com.cipy.examen.service;

import com.cipy.examen.converter.CarreraConverter;
import com.cipy.examen.entity.Carrera;
import com.cipy.examen.model.request.CarreraRequest;
import com.cipy.examen.model.response.CarreraResponse;
import com.cipy.examen.repository.CarreraRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraService {
    
    @Autowired
    private CarreraRepository carreraRepository;
    
    @Autowired
    private CarreraConverter carreraConverter;
    
    public List<CarreraResponse> getAll(){
        
        List<Carrera> carrera = carreraRepository.findAll();
        
        if(carrera != null && !carrera.isEmpty()){
            return carreraConverter.entitiesToModel(carrera);
        }
        return null ;
        
    }
    
    public CarreraResponse saveOne(CarreraRequest crequest){
        
        Carrera carrera = carreraConverter.modelToEntity(crequest);
        carrera = carreraRepository.save(carrera);
        
     CarreraResponse cr = carreraConverter.entityToModel(carrera);
        
        return cr;
    }
    
}
