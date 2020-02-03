package com.cipy.examen.controller;

import com.cipy.examen.model.request.CarreraRequest;
import com.cipy.examen.model.response.CarreraResponse;
import com.cipy.examen.service.CarreraService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carreras")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping(value="/ver")
    public ResponseEntity<?> getAll() {

        try {
            List<CarreraResponse> carreras = carreraService.getAll();
            if (carreras != null) {
                return new ResponseEntity<>(carreras, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    @PostMapping(value="/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody CarreraRequest data){
         try {
            CarreraResponse carreras = carreraService.saveOne(data);
            if (carreras != null) {
                return new ResponseEntity<>(carreras, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
}
