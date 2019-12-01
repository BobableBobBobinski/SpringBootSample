package com.cko.sampleSpringProject.controller;
import com.cko.sampleSpringProject.dao.FilmDAO;
import com.cko.sampleSpringProject.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class FilmController {
    @Autowired
    FilmDAO filmDAO;
    @GetMapping("/film/create")
    public String showCreateFilm() { return "CreateFilm"; }
    @GetMapping("/film/all")
    public ModelAndView showAllFilms(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("AllFilms");
        List<Film> filmList = filmDAO.findAll();
        modelAndView.addObject("films", filmList);
        return modelAndView;
    }
    @GetMapping("/film/edit")
    public ModelAndView showEditFilm(@RequestParam Long id){
        ModelAndView modelAndView = new ModelAndView();
        Film film = filmDAO.findFilmById(id);
        modelAndView.addObject("film", film);
        modelAndView.setViewName("EditFilm");
        return modelAndView;
    }
    @GetMapping("film/delete")
    public RedirectView DeleteFilm(@RequestParam Long id) {
        filmDAO.deleteById(id);
        return new RedirectView("/film/all");
    }
    @PostMapping("/film/create")
    public RedirectView CreateFilm(Film film) {
        filmDAO.save(film);
        return new RedirectView("/film/all");
    }
    @PostMapping("/film/edit")
    public RedirectView EditFilm(Film film) {
        filmDAO.save(film);
        return new RedirectView("/film/all");
    }
    @GetMapping("/testT")
    public ModelAndView showFirstFilm(){
        ModelAndView modelAndView = new ModelAndView();
        Film film = filmDAO.findFilmById((long) 1);
        modelAndView.addObject("film", film);
        modelAndView.setViewName("TestT");
        return modelAndView;
    }

}
