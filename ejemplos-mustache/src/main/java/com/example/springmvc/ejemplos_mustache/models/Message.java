package com.example.springmvc.ejemplos_mustache.models;

public class Message {
    
    private long id;
    private String author;
    private String content;

    public Message(){

    }

    public Message(long id, String author, String content){
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public long getId() {
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(long id) {
        this.id = id;
    }
}
