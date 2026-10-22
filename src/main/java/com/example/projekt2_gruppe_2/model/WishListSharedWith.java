package com.example.projekt2_gruppe_2.model;

public class WishListSharedWith {
    private int categoryId;
    private String title;
    private String image;

    public WishListSharedWith(String title, String image) { }

    public WishListSharedWith(int categoryId, String title, String image) {
        this.categoryId = categoryId;
        this.title = title;
        this.image = image;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
