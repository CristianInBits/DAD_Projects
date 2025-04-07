package es.chatgpt.code.contact_api.controllers;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.chatgpt.code.contact_api.models.Contact;
import es.chatgpt.code.contact_api.services.ContactService;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/")
    public Collection<Contact> getAllContacts() {
        return contactService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable long id) {
        Contact contact = contactService.findById(id);
        if (contact != null) {
            return ResponseEntity.ok(contact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        contactService.save(contact);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(contact.getId()).toUri();
        return ResponseEntity.created(location).body(contact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable long id, @RequestBody Contact newContact) {
        Contact existing = contactService.findById(id);
        if (existing != null) {
            existing.setId(id);
            contactService.save(newContact);
            return ResponseEntity.ok(newContact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Contact> deleteContact(@PathVariable long id) {
        Contact contact = contactService.findById(id);
        if (contact != null) {
            contactService.deleteById(id);
            return ResponseEntity.ok(contact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
