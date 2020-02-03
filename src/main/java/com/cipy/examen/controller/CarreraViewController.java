
package com.cipy.examen.controller;

import com.cipy.examen.entity.Carrera;
import com.cipy.examen.repository.CarreraRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/carrera")
public class CarreraViewController {
    
    @Autowired
    private CarreraRepository carreraRepository;
    
     @GetMapping(value="/listarC")          
    public String listar(Model model){
        List<Carrera> carrera = new ArrayList<Carrera>();
        carrera=carreraRepository.findAll();
        model.addAttribute("carreras", carrera );
                return "listarC";
    }
    
}
