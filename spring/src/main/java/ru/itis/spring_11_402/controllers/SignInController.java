package ru.itis.spring_11_402.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

    @GetMapping("/signIn")
    public String getLoginPage() {
        return "sign_in_page";
    }
}
