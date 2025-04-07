package es.chatgpt.code.contact_api.services;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import es.chatgpt.code.contact_api.models.Contact;

@Service
public class ContactService {

    private final ConcurrentMap<Long, Contact> contacts = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong();

    public ContactService() {
        save(new Contact("Alice", "alice@example.com", "123456789"));
        save(new Contact("Bob", "bob@example.com", "987654321"));
    }

    public Collection<Contact> findAll() {
        return contacts.values();
    }

    public Contact findById(long id) {
        return contacts.get(id);
    }

    public void save(Contact contact) {
        if (contact.getId() == null || contact.getId() == 0) {
            contact.setId(nextId.getAndIncrement());
        }
        contacts.put(contact.getId(), contact);
    }

    public void deleteById(long id) {
        contacts.remove(id);
    }
}
