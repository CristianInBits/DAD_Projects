package es.chatgpt.code.ejemplo5_db.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private String name;
    private int startYear;

    @OneToOne
    private Project project;

    public Student() {
    }

    public Student(String name, int startYear) {
        super();
        this.name = name;
        this.startYear = startYear;
    }

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

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", startYear=" + startYear + "]";
    }
}