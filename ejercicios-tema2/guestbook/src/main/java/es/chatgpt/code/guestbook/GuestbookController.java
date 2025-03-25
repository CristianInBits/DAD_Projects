package es.chatgpt.code.guestbook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GuestbookController {

    private final List<Message> messages = new ArrayList<>();
    private long nextId = 1;

    // Página principal - listado de mensajes
    @GetMapping("/")
    public String showGuestbook(Model model) {
        model.addAttribute("messages", messages);
        return "index";
    }

    // Formulario para añadir un nuevo mensaje
    @GetMapping("/messages/new")
    public String showNewMessageForm() {
        return "new_message";
    }

    // Guarda el mensaje recibido desde el formulario
    @PostMapping("/messages")
    public String saveMessage(@ModelAttribute Message message, Model model) {
        message.setId(nextId++);
        messages.add(message);
        model.addAttribute("message", message);
        return "message_saved";
    }

    // Muestra un mensaje por su ID
    @GetMapping("/messages/{id}")
    public String showMessage(Model model, @PathVariable long id) {
        for (Message m : messages) {
            if (m.getId() == id) {
                model.addAttribute("message", m);
                return "message";
            }
        }
        return "redirect:/"; // No encontrado
    }

    // Elimina un mensaje por su ID
    @GetMapping("/messages/{id}/delete")
    public String deleteMessage(@PathVariable long id, Model model) {
        messages.removeIf(m -> m.getId() == id);
        model.addAttribute("id", id);
        return "message_deleted";
    }
}
