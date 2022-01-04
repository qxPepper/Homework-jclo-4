package ru.netology.homeworkjclo4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.netology.homeworkjclo4.exceptions.InvalidCredentials;
import ru.netology.homeworkjclo4.exceptions.UnauthorizedUser;
import ru.netology.homeworkjclo4.repository.Authorities;
import ru.netology.homeworkjclo4.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentials.class)
    public String handleInvalidCredentials(InvalidCredentials e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    public String handleUnauthorizedUser(UnauthorizedUser e) {
        System.out.println(e.getMessage());
        return e.getMessage();
    }
}

