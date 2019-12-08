package com.cko.sampleSpringProject;

import com.cko.sampleSpringProject.dao.FilmDAO;
import com.cko.sampleSpringProject.dao.ProductDAO;
import com.cko.sampleSpringProject.model.Authority;
import com.cko.sampleSpringProject.model.Film;
import com.cko.sampleSpringProject.model.Product;
import com.cko.sampleSpringProject.model.User;
import com.cko.sampleSpringProject.service.AuthorityService;
import com.cko.sampleSpringProject.service.SMSCService;
import com.cko.sampleSpringProject.service.UserService;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitData {

    @Autowired
    UserService userService;

    @Autowired
    AuthorityService authorityService;

    @Autowired
    SMSCService smscSender;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    Faker faker = new Faker();

    @Autowired
    FilmDAO filmDAO;

    public void initData() {


//        smscSender.send_sms("89775548911","TEST MESSAGE",1, "", "", 0, "", "");
        initFilms();
        initUserAndRoles();
        initProducts();

    }

    @Autowired
    ProductDAO productDAO;

    private void initFilms() {
        for (int i = 0; i < 10; i++) {
            Film film = new Film(faker.superhero().name(), i, i * 2);
            filmDAO.save(film);
        }
    }

    private void initUserAndRoles() {
        Authority adminAuthority = new Authority("ROLE_ADMIN");
        Authority userAuthority = new Authority("ROLE_USER");
        authorityService.insert(adminAuthority);
        authorityService.insert(userAuthority);

        List<Authority> authorities = new ArrayList<Authority>();
        authorities.add(adminAuthority);

        for (int i = 0; i < 10; i++) {
            userService.insert(new User(i + "@mail.ru", bCryptPasswordEncoder.encode(String.valueOf(i)), authorities));
        }


    }

    public void initProducts() {

        for (int j = 0; j < 10; j++) {
            Product product = new Product(faker.book().title(), faker.number().numberBetween(100, 3500), faker.number().numberBetween(10, 30));
            productDAO.save(product);
        }
    }
}
