package es.chatgpt.code.studentcourse_api.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

public class Course {

    public interface Basic {
    }

    public interface Students {
    }

    @JsonView(Basic.class)
    private long id;

    @JsonView(Basic.class)
    private String title;

    @JsonView(Students.class)
    private List<Student> enrolledStudents = new ArrayList<>();

    public Course() {
    }

    public Course(long id, String title) {
        this.id = id;
        this.title = title;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
}
