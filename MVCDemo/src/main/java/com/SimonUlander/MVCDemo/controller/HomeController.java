package com.SimonUlander.MVCDemo.controller;

import com.SimonUlander.MVCDemo.model.Job;
import com.SimonUlander.MVCDemo.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/")
public class HomeController {
    private CalculatorService calculatorService;

    public HomeController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping // Returns the home.html page when "/" is requested.
    String getHomePage(Job job, Model model) {
        model.addAttribute("Job", this.calculatorService.getJob());
        return "home";
    }

    @PostMapping // Takes in form postings and sends it to the model and then updates the view.
    public String calculateInput(Job job, Model model) {

        calculatorService.calculate(job);
        model.addAttribute("Job", this.calculatorService.getJob());
        return "home";
    }
}
