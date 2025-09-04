package com.example.jour2.controller;

import com.example.jour2.model.UserForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {

    @GetMapping("/view")
    public String viewPage(Model model) {
        model.addAttribute("message", "Bienvenue sur la page Thymeleaf !");

        List<Integer> heavenNumbers = new ArrayList<>();
        for (int i = 0; i < 10; i += 2) {
            heavenNumbers.add(i);
        }
        model.addAttribute("heavenNumbers", heavenNumbers);

        model.addAttribute("userForm", new UserForm());
        return "view";
    }

    @PostMapping("/view")
    public String submitForm(@Valid @ModelAttribute("userForm") UserForm form, BindingResult result, Model model) {

        model.addAttribute("message", "Bienvenue sur la page Thymeleaf !");

        List<Integer> heavenNumbers = new ArrayList<>();
        for (int i = 0; i < 10; i += 2) {
            heavenNumbers.add(i);
        }
        model.addAttribute("heavenNumbers", heavenNumbers);

        // En cas d’erreur de validation, on retourne la vue sans afficher de message
        if (result.hasErrors()) {
            return "view";
        }

        // Si tout est OK, on affiche le message personnalisé
        String formMessage = "Bienvenue, " + form.getFirstName() + " " + form.getLastName() + " !";
        model.addAttribute("formMessage", formMessage);

        return "view";
    }

}
