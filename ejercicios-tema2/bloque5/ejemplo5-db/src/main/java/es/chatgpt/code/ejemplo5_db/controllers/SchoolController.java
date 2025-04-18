package es.chatgpt.code.ejemplo5_db.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.chatgpt.code.ejemplo5_db.models.Project;
import es.chatgpt.code.ejemplo5_db.models.Student;
import es.chatgpt.code.ejemplo5_db.repository.ProjectRepository;
import es.chatgpt.code.ejemplo5_db.repository.StudentRepository;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostConstruct
    public void init() {

        Project p1 = new Project("TFG1", 8);
        projectRepository.save(p1);

        Student s1 = new Student("Pepe", 2010);
        s1.setProject(p1);

        Student s2 = new Student("Juan", 2011);

        studentRepository.save(s1);
        studentRepository.save(s2);
    }

    @GetMapping("/students/")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/projects/")
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    // Deleting a student doesn't delete her associated project
    @DeleteMapping("/students/{id}")
    public Student deleteStudent(@PathVariable long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        studentRepository.deleteById(id);
        return student;
    }

    // A project only can be deleted if it has no associated student.
    @DeleteMapping("/projects/{id}")
    public Project deleteProject(@PathVariable long id) {
        Project project = projectRepository.findById(id).orElseThrow();
        projectRepository.deleteById(id);
        return project;
    }

}