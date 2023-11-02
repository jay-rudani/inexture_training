package org.icc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.icc.model.ConversionHistory;
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
    public String convert(@RequestParam(required = false) String convertFrom, @RequestParam(required = false) String convertTo, @RequestParam String amount, Model model) throws JsonProcessingException {

        if (convertFrom == null || convertFrom.isEmpty()) {
            model.addAttribute("isConvertFromSelected", false);
            return "redirect:/";
        }

        if (convertTo == null || convertTo.isEmpty()) {
            model.addAttribute("isConvertToSelected", false);
            return "redirect:/";
        }

        model.addAttribute("isConvertFromSelected", true);
        model.addAttribute("isConvertToSelected", true);
        ConversionHistory result = service.convert(convertFrom, convertTo, Double.parseDouble(amount));
        String returnUrl = "result=" + result.getConvertedAmount() + "&from=" + result.getSourceCurrency() + "&to=" + result.getTargetCurrency() + "&rate=" + result.getExchangeRate() + "&amount=" + result.getAmount();
        return "redirect:/?" + returnUrl;
    }

    @GetMapping("/history")
    public String getHistory(Model model) {
        model.addAttribute("histories", service.getHistory());
        return "history";
    }
}
