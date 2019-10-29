package com.epam.springadvanced.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilController {

    @GetMapping(value = "/")
    public String main() {
        return "main";
    }

    @GetMapping(value = "/addSubscriber")
    public String addPersonForm(Model model) {
        return "addSubscriber";
    }
}
