package ru.itis.spring_11_402.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ConfirmController {
    @GetMapping("/confirm/{code}")
    public String confirmUser(@PathVariable("code") String code) {
        return null;
    }

}
