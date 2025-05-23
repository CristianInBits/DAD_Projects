package es.chatgpt.code.ejemplo7_db.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import es.chatgpt.code.ejemplo7_db.models.Project;
import es.chatgpt.code.ejemplo7_db.models.Student;
import es.chatgpt.code.ejemplo7_db.repository.ProjectRepository;
import es.chatgpt.code.ejemplo7_db.repository.StudentRepository;
import jakarta.annotation.PostConstruct;

@RestController
public class SchoolController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostConstruct
    public void init() {

        Student s1 = new Student("Pepe", 2010);
        s1.setProject(new Project("TFG1", 8));
        studentRepository.save(s1);

        Student s2 = new Student("Juan", 2011);
        studentRepository.save(s2);
    }

    interface StudentView extends Student.BasicAtt, Student.ProjectAtt, Project.BasicAtt {
    }

    @JsonView(StudentView.class)
    @GetMapping("/students/")
    public List<Student> getStudents() throws Exception {
        return studentRepository.findAll();
    }

    @JsonView(StudentView.class)
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable long id) throws Exception {
        return studentRepository.findById(id).orElseThrow();
    }

    interface ProjectView extends Project.BasicAtt, Project.StudentAtt, Student.BasicAtt {
    }

    @JsonView(ProjectView.class)
    @GetMapping("/projects/")
    public List<Project> getProjects() throws Exception {
        return projectRepository.findAll();
    }

    @JsonView(ProjectView.class)
    @GetMapping("/projects/{id}")
    public Project getProject(@PathVariable long id) throws Exception {
        return projectRepository.findById(id).orElseThrow();
    }

    // Deleting a student delete her associated project
    @JsonView(StudentView.class)
    @DeleteMapping("/students/{id}")
    public Student deleteStudent(@PathVariable Long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        studentRepository.deleteById(id);
        return student;
    }
}
