package es.chatgpt.code.appointment_manager.services;

import es.chatgpt.code.appointment_manager.models.Appointment;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AppointmentService {

    private final ConcurrentMap<Long, Appointment> appointments = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong();

    public AppointmentService() {
        save(new Appointment("Juan Pérez", "Dr. López", "2025-04-10", "10:00", "Dolor de cabeza"));
        save(new Appointment("Ana Ruiz", "Dra. Martínez", "2025-04-11", "12:30", "Chequeo general"));
    }

    public void save(Appointment appointment) {
        long id = nextId.getAndIncrement();
        appointment.setId(id);
        appointments.put(id, appointment);
    }

    public Collection<Appointment> findAll() {
        return appointments.values();
    }

    public Appointment findById(long id) {
        return appointments.get(id);
    }

    public void deleteById(long id) {
        appointments.remove(id);
    }
}
