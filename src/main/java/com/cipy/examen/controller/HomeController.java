package com.cipy.examen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

   String tit="Pagina Principal";
   @GetMapping(value="/")
    public String home(Model model) {
        model.addAttribute("titulo", tit);
    
        return "/layout/home";
    }
    
}
