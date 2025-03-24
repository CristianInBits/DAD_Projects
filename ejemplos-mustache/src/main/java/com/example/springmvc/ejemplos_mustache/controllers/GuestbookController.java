package com.example.springmvc.ejemplos_mustache.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springmvc.ejemplos_mustache.models.Message;

@Controller
public class GuestbookController {

    private List<Message> messages = new ArrayList<>();
    private long nextId = 1;

    // Página principal - listado de mensajes
    @GetMapping("/homee")
    public String showGuestbook(Model model) {
        model.addAttribute("messages", messages);
        return "guestbook/main";
    }

    // Formulario para añadir un nuevo mensaje
    @GetMapping("/messages/new")
    public String showNewMessageForm() {
        return "guestbook/new_message";
    }

    // Guardar el mensaje recibido desde el formulario
    @PostMapping("/messages")
    public String saveMessage(Message message, Model model) {
        message.setId(nextId++);
        messages.add(message);
        model.addAttribute("message", message);
        return "guestbook/message_saved";
    }

    // Eliminar un mensaje por su id
    @GetMapping("/messages/{id}/delete")
    public String deleteMessage(@PathVariable long id, Model model) {
        messages.removeIf(m -> m.getId() == id);
        model.addAttribute("id", id);
        return "guestbook/message_deleted";
    }
}