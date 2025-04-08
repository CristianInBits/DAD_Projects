package es.chatgpt.code.studentcourse_api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import es.chatgpt.code.studentcourse_api.models.Course;
import es.chatgpt.code.studentcourse_api.models.Student;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentCourseController {

    private final List<Student> students = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();

    @PostConstruct
    public void init() {
        Student alice = new Student(1, "Alice");
        Student bob = new Student(2, "Bob");

        Course math = new Course(1, "Mathematics");
        Course physics = new Course(2, "Physics");

        math.getEnrolledStudents().add(alice);
        physics.getEnrolledStudents().add(alice);
        physics.getEnrolledStudents().add(bob);

        alice.getEnrolledCourses().add(math);
        alice.getEnrolledCourses().add(physics);
        bob.getEnrolledCourses().add(physics);

        students.add(alice);
        students.add(bob);

        courses.add(math);
        courses.add(physics);
    }

    @JsonView(Student.Basic.class)
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @JsonView(Course.Basic.class)
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courses;
    }

    interface StudentDetails extends Student.Basic, Student.Courses, Course.Basic {
    }

    @JsonView(StudentDetails.class)
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        return students.get(id - 1);
    }

    public interface CourseDetails extends Course.Basic, Course.Students, Student.Basic {
    }

    @JsonView(CourseDetails.class)
    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable int id) {
        return courses.get(id - 1);
    }
}
