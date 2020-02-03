package com.cipy.examen.controller;

import com.cipy.examen.converter.AlumnoConverter;
import com.cipy.examen.entity.Alumno;
import com.cipy.examen.entity.Carrera;
import com.cipy.examen.model.request.AlumnoRequest;
import com.cipy.examen.model.response.AlumnoResponse;
import com.cipy.examen.repository.AlumnoRepository;
import com.cipy.examen.repository.CarreraRepository;
import com.cipy.examen.service.AlumnoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/view")
public class AlumnoViewController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private AlumnoConverter alumnoConverter;

    @Autowired
    private AlumnoService alumnoService;


    @GetMapping(value = "/listar")
    public String listar(Model model) {
        List<Alumno> alumn = new ArrayList<Alumno>();
        List<Carrera> carrera = new ArrayList<Carrera>();
        alumn = alumnoRepository.findAll();
        model.addAttribute("alumnos", alumn);
        model.addAttribute("carreras", carrera);
        return "listar";
    }

    //metodo para crear el formulario y estirar desde la vista
    @GetMapping(value = "/form")
    public String obtener(Map<String, Object> model) {
        AlumnoRequest alumn = new AlumnoRequest();
        List<Carrera> carreras = new ArrayList<Carrera>();
        carreras = carreraRepository.findAll();
        model.put("carreras", carreras);
        model.put("alumnos", alumn);
        return "form";
    }

    //metodo para insertar el alumno creado desde la vista en la base de datos
    @PostMapping(value = "/form")
    public String save(AlumnoRequest arequest) {
        alumnoRepository.save(alumnoConverter.modelToEntity(arequest));
        return "redirect:listar";
    }

    @GetMapping(value = "/delete")
    public String obtenerD(Model model) {
        AlumnoRequest alumn = new AlumnoRequest();
        model.addAttribute("aDelete", new AlumnoResponse());
        model.addAttribute("alumnos", alumn);
        return "formDelete";
    }

    @GetMapping(value = "/delette/{id}")
    public String borrar(@PathVariable Integer id) {

        alumnoService.deleteOne(id);
        
        return "listar";
    }
    
    //metodo del put
    
    @GetMapping(value = "/form/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        AlumnoResponse alumn = new AlumnoResponse();
        
       alumn=alumnoService.getById(id);
       model.addAttribute("alumnos", alumn);
       model.addAttribute("carreras", carreraRepository.findAll());
        return "form";
    }
    
//     @GetMapping(value = "/get_for_edit")
//    public String editar(@PathVariable String id) {
//
//        alumnoService.updateOne(Integer.parseInt(id));
//        
//        return "redirect:listar";
//    }
}
