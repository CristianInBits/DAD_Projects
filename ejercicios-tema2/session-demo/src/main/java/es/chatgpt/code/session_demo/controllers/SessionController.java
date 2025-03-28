package es.chatgpt.code.session_demo.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SessionController {

    private String sharedInfo; // atributo global, compartido entre usuarios

    @GetMapping("/")
    public String showForm() {
        return "form";
    }

    @PostMapping("/save-info")
    public String saveInfo(@RequestParam String info, HttpSession session) {
        session.setAttribute("userInfo", info);   // atributo de sesión
        sharedInfo = info;                        // atributo compartido
        return "saved";
    }

    @GetMapping("/show-info")
    public String showInfo(Model model, HttpSession session) {
        String userInfo = (String) session.getAttribute("userInfo");
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("sharedInfo", sharedInfo);
        return "result";
    }
}
