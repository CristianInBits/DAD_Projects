package com.example.springmvc.ejemplos_mustache.models;

public class User {
    private String name;
    private String profilePic; // URL de la foto de perfil (puede ser null)

    public User(String name, String profilePic) {
        this.name = name;
        this.profilePic = profilePic;
    }

    public String getName() {
        return name;
    }

    public String getProfilePic() {
        return profilePic;
    }
}
