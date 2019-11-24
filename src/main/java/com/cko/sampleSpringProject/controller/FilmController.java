package com.cko.sampleSpringProject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilmController {
    @GetMapping("/film/create")
    public String showCreateFilm(){
        return "CreateFilm";
    }
    @GetMapping("/film/all")
    public String showAllFilms(){
        return "AllFilms";
    }
    @GetMapping("/film/edit")
    public String showEditFilm(){
        return "EditFilm";
    }
}
