package com.example.movieclub.web.admin;

import com.example.movieclub.domain.user.UserService;
import com.example.movieclub.domain.user.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.GeneratedValue;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("rejestracja")
    public String registrationForm(Model model){
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        model.addAttribute("user", userRegistrationDto);
        return "registration-form";
    }

    @PostMapping("/rejestracja")
    public String register(UserRegistrationDto userRegistrationDto){
        userService.registerUserWithDefaultRole(userRegistrationDto);
        return "redirect:/";
    }
}
