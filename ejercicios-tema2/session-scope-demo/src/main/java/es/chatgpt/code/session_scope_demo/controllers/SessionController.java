package es.chatgpt.code.session_scope_demo.controllers;


import es.chatgpt.code.session_scope_demo.components.UserInfo;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class SessionController {

    private final UserInfo userInfo; // componente por sesión
    private String sharedInfo;       // compartido entre todos los usuarios

    //@Autowired
    public SessionController(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @GetMapping("/")
    public String showForm() {
        return "form";
    }

    @PostMapping("/save-info")
    public String saveInfo(@RequestParam String info) {
        userInfo.setInfo(info);   // por sesión
        sharedInfo = info;        // compartido
        return "saved";
    }

    @GetMapping("/show-info")
    public String showInfo(Model model) {
        model.addAttribute("userInfo", userInfo.getInfo());
        model.addAttribute("sharedInfo", sharedInfo);
        return "result";
    }
}