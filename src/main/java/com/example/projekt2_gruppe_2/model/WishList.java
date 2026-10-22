package com.example.projekt2_gruppe_2.model;

public class WishList {
    private int listID;
    private String title;
    private String description;
    private int userID;

    public WishList(int listID, String title, String description, int userID) {
        this.listID = listID;
        this.title = title;
        this.description = description;
        this.userID = userID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getListID() {
        return listID;
    }

    public int getUserID() {
        return userID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
