package com.portfolio.prueba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.portfolio.prueba.model.PersonalInfo;
import com.portfolio.prueba.service.IPersonalInfoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PortfolioController {
    private final IPersonalInfoService personalInfoService;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("personalInfo", new PersonalInfo());
        return "form";
    }

    @PostMapping("/personal-info-save")
    public String savePerosnalInfo(@ModelAttribute("personalInfo") PersonalInfo personalInfo) {
        personalInfoService.save(personalInfo);
        return "redirect:/";
    }

}
