package es.chatgpt.code.dog_image_api.models;

public class DogImageResponse {

    private String message;
    private String status;

    public DogImageResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}