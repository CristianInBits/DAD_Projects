package es.chatgpt.code.dog_api.models;

public class DogResponse {
    private String message;
    private String status;

    public DogResponse() {
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}