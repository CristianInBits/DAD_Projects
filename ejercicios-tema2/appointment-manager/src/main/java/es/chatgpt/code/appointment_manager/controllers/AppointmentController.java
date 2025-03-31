package es.chatgpt.code.appointment_manager.controllers;

import es.chatgpt.code.appointment_manager.services.AppointmentService;
import es.chatgpt.code.appointment_manager.models.Appointment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/appointments")
    public String listAppointments(Model model) {
        model.addAttribute("appointments", appointmentService.findAll());
        return "appointments/list";
    }

    @GetMapping("/appointments/new")
    public String showNewForm() {
        return "appointments/new";
    }

    @PostMapping("/appointments")
    public String saveAppointment(@ModelAttribute Appointment appointment, Model model) {
        appointmentService.save(appointment);
        model.addAttribute("appointment", appointment);
        return "appointments/detail";
    }

    @GetMapping("/appointments/{id}")
    public String showAppointment(@PathVariable long id, Model model) {
        Appointment appointment = appointmentService.findById(id);
        if (appointment != null) {
            model.addAttribute("appointment", appointment);
            return "appointments/detail";
        }
        return "redirect:/appointments";
    }

    @GetMapping("/appointments/{id}/delete")
    public String deleteAppointment(@PathVariable long id, Model model) {
        appointmentService.deleteById(id);
        model.addAttribute("id", id);
        return "appointments/deleted";
    }
}
