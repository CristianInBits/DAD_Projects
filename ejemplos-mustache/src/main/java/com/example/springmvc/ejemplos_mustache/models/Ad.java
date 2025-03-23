package com.example.springmvc.ejemplos_mustache.models;

public class Ad {

    private String name;
    private String subject;
    private String comment;

    public Ad() {
    }

    public Ad(String name, String subject, String comment) {
        this.name = name;
        this.subject = subject;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
