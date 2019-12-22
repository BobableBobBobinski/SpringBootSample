package com.cko.sampleSpringProject.controller.rest;

import com.cko.sampleSpringProject.dao.FilmDAO;
import com.cko.sampleSpringProject.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/api/film")
public class FilmRestController {

    @Autowired
    FilmDAO filmDAO;

    @PostMapping("/create")
    public void createFilm(@RequestBody Film film) {
        filmDAO.save(film);
    }

    @GetMapping("/get")
    public Film getFilmById(@RequestParam Long id) {
        Film film = filmDAO.findFilmById(id);

        return film;
    }
    @GetMapping("/delete")
    public void DeleteFilm(@RequestParam Long id) {
        filmDAO.deleteById(id);
    }
    @GetMapping("/all")
    public List<Film> getAllFilms() {
        List<Film> films = filmDAO.findAll();
        return films;
    }

}