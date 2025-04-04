package es.chatgpt.code.forum_service.models;

public class Post {

    private Long id;
    private String title;
    private String author;
    private String content;

    public Post() {
    }

    public Post(String title, String author, String content) {
        // super();
        this.title = title;
        this.author = author;
        this.content = content;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /*@Override
    public String toString() {
        return "Post [id=" + id + ", author=" + author + ", title=" + title + ", conntent=" + content + "]";
    }*/
}
