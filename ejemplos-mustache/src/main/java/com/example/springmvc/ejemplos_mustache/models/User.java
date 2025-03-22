package com.example.springmvc.ejemplos_mustache.models;

public class User {
    
    private String name;
    private String profilePic; // URL de la foto de perfil (puede ser null)
    private boolean active;

    public User(String name, String profilePic, boolean active) {
        this.name = name;
        this.profilePic = profilePic;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public boolean isActive(){
        return active;
    }
}
