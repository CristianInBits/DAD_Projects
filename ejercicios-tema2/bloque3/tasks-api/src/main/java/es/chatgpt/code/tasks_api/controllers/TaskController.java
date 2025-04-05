package es.chatgpt.code.tasks_api.controllers;

import es.chatgpt.code.tasks_api.models.Task;
import es.chatgpt.code.tasks_api.services.TaskService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/")
    public Collection<Task> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable long id) {
        Task task = service.findById(id);
        if (task != null) {
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Task> create(@RequestBody Task task) {
        service.save(task);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(location).body(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> replace(@PathVariable long id, @RequestBody Task newTask) {
        Task task = service.findById(id);
        if (task != null) {
            newTask.setId(id);
            service.save(newTask);
            return ResponseEntity.ok(newTask);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> delete(@PathVariable long id) {
        Task task = service.findById(id);
        if (task != null) {
            service.deleteById(id);
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.notFound().build();
    }
}
