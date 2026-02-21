package ru.itis.spring_11_402.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.spring_11_402.dto.UserForm;
import ru.itis.spring_11_402.services.SignUpService;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUp")
    public String getSignUpPage(){
        return "sign_up_page";
    }

    @PostMapping("/signUp")
    public String sigUp(UserForm form){
        signUpService.addUser(form);
        return "redirect:/signUp";
    }
}
