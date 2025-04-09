package es.chatgpt.code.post_image_api.models;

public class Post {

    private Long id;
    private String user;
    private String title;
    private String text;
    private String image;

    public Post() {
    }

    public Post(String user, String title, String text) {
        this.user = user;
        this.title = title;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
