package com.example.springmvc.ejemplos_mustache.models;

public class Post {
    private long id;
    private String name;
    private String subject;
    private String content;

    public Post() {
        
    }

    public Post(long id, String name, String subject, String content) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setId(long id) {
        this.id = id;
    }
}