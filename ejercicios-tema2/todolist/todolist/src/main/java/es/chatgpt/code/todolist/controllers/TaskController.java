package es.chatgpt.code.todolist.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.chatgpt.code.todolist.models.Task;

@Controller
public class TaskController {

    private final List<Task> tasks = new ArrayList<>();
    private long nextId = 1;

    @GetMapping("/")
    public String showTodoList(Model model) {
        model.addAttribute("tasks", tasks);
        return "tasks/main";
    }

    @GetMapping("/tasks/new")
    public String showNewTaskForm() {
        return "tasks/new";
    }

    @PostMapping("/tasks")
    public String saveTask(Model model, @ModelAttribute Task task) {
        task.setId(nextId++);
        tasks.add(task);
        model.addAttribute("task", task);
        return "tasks/task_saved";
    }

    @GetMapping("tasks/{id}")
    public String showTask(Model model, @PathVariable long id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                model.addAttribute("task", task);
                return "tasks/show";
            }
        }
        return "redirect:/";
    }

    @GetMapping("tasks/{id}/delete")
    public String deleteTask(Model model, @PathVariable long id) {
        tasks.removeIf(t -> t.getId() == id);
        return "tasks/task_deleted";
    }

    @GetMapping("tasks/{id}/complete")
    public String completeTask(Model model, @PathVariable long id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDone(true);
                break;
            }
        }
        return "redirect:/";
    }
}
