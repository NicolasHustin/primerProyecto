package com.cipy.examen.controller;

import com.cipy.examen.model.request.AlumnoRequest;
import com.cipy.examen.model.response.AlumnoResponse;
import com.cipy.examen.repository.AlumnoRepository;
import com.cipy.examen.service.AlumnoService;
//import io.swagger.models.Model;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private AlumnoRepository alumnoRepository;

//    @GetMapping(value="/listar")          
//    public String listar(Model model){
//        List<Alumno> alumnos = new ArrayList<Alumno>();
//        alumnos=alumnoRepository.findAll();
//        model.addAttribute("alumnos", alumnos );
//                return "listar";
//    }
//    
    @GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Integer id){
          try {
           AlumnoResponse alumnos = alumnoService.getById(id);
            if (alumnos != null) {
                return new ResponseEntity<>(alumnos, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    @GetMapping(value = "/ver")
    public ResponseEntity<?> getAll() {

        try {
            List<AlumnoResponse> alumnos = alumnoService.getAll();
            if (alumnos != null) {
                return new ResponseEntity<>(alumnos, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(value = "/guardar")
    public ResponseEntity<?> save(@RequestBody AlumnoRequest arequest) {
        try {
            AlumnoResponse alumno = alumnoService.saveOne(arequest);

            return new ResponseEntity<>(alumno, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> updateOne(@RequestBody AlumnoRequest arequest) {
        try {
            AlumnoResponse alumno = alumnoService.updateOne(arequest);
            if (alumno == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(alumno, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable("id") Integer alumno) {
        try {
            alumnoService.deleteOne(alumno);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
