package org.icc.controller;

import org.icc.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private ConversionService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld() {
        return "index";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam String convertFrom, @RequestParam String convertTo, @RequestParam String amount) {
        double result = service.convert(convertFrom, convertTo, Double.parseDouble(amount));
        return "redirect:/?result=" + result + "&from=" + convertFrom.split("_")[1] + "&to=" + convertTo.split("_")[1];
    }

    @GetMapping("/history")
    public String getHistory(Model model) {
        model.addAttribute("histories", service.getHistory());
        return "history";
    }
}
