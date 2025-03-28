package es.chatgpt.code.book_library.models;

public class Book {

    private Long id;
    private String title;
    private String author;
    private int year;
    private String summary;

    public Book() {
    }

    public Book(String title, String author, String summary, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public Long getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
