package es.chatgpt.code.tasks_api.services;

import es.chatgpt.code.tasks_api.models.Task;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final Map<Long, Task> tasks = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public TaskService() {
        save(new Task("Study Spring Boot", false));
        save(new Task("Review exercises", true));
    }

    public Collection<Task> findAll() {
        return tasks.values();
    }

    public Task findById(long id) {
        return tasks.get(id);
    }

    public void save(Task task) {
        if (task.getId() == null || task.getId() == 0) {
            task.setId(nextId.getAndIncrement());
        }
        tasks.put(task.getId(), task);
    }

    public void deleteById(long id) {
        tasks.remove(id);
    }
}
