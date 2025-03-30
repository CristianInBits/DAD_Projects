package es.chatgpt.code.currency_converter.controllers;

import es.chatgpt.code.currency_converter.services.CurrencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/")
    public String showForm() {
        return "form";
    }

    @PostMapping("/convert")
    public String convertCurrency(
            @RequestParam double amount,
            @RequestParam String currency,
            Model model) {

        double result = currencyService.convert(amount, currency);
        String symbol = currencyService.getSymbol(currency);

        model.addAttribute("amount", amount);
        model.addAttribute("currency", currency);
        model.addAttribute("symbol", symbol);
        model.addAttribute("result", result);

        return "result";
    }
}
