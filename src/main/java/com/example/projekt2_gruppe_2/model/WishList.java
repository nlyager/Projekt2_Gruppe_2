package com.example.projekt2_gruppe_2.model;

public class WishList {
    final int listID;
    private String title;
    private String description;
    private int userID;
    private String image;
    private String sharedBy;

    public WishList(int listID, String title, String description, int userID, String image) {
        this.listID = listID;
        this.title = title;
        this.description = description;
        this.userID = userID;
        this.image = image;
    }

    public WishList(int listID, String title, String description, int userID, String image, String sharedBy) {
        this(listID, title, description, userID, image);
        this.sharedBy = sharedBy;
    }

    public WishList(int listID, String title, String description, String image) {
        this.listID = listID;
        this.title = title;
        this.description = description;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public String getSharedBy() {
        return sharedBy;
    }
}
