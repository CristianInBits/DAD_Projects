package es.chatgpt.code.studentcourse_api.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

public class Student {

    public interface Basic {
    }

    public interface Courses {
    }

    @JsonView(Basic.class)
    private long id;

    @JsonView(Basic.class)
    private String name;

    @JsonView(Courses.class)
    private List<Course> enrolledCourses = new ArrayList<>();

    public Student() {
    }

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}
