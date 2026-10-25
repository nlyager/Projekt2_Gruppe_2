package com.example.projekt2_gruppe_2.model;

public class User {
    final int userID;
    private String name;
    private String email;
    private String password;



    public User(int userID, String name, String email, String password) {
        this.userID = userID;
        this.name = name;
        this.email =email;
        this.password = password;
}

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }


}
