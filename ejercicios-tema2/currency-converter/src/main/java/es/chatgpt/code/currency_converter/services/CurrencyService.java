package es.chatgpt.code.currency_converter.services;

import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    public double convert(double amount, String currency) {
        return switch (currency) {
            case "USD" -> amount * 1.1;
            case "GBP" -> amount * 0.87;
            case "JPY" -> amount * 150.75;
            default -> amount;
        };
    }

    public String getSymbol(String currency) {
        return switch (currency) {
            case "USD" -> "$";
            case "GBP" -> "£";
            case "JPY" -> "¥";
            default -> "€";
        };
    }
}
