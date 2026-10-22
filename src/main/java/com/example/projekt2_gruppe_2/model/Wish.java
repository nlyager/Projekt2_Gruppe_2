package com.example.projekt2_gruppe_2.model;

public class Wish {
    private int wishId;
    private String title;
    private String description;
    private double price;
    private int reserveId;
    private int listId;
    private int categoryId;

    public Wish() { }

    public Wish(String title, String description, double price, int reserveId, int listId, int categoryId) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.reserveId = reserveId;
        this.listId = listId;
        this.categoryId = categoryId;
    }

    public Wish(int wishId, String title, String description, double price, int reserveId, int listId, int categoryId) {
        this.wishId = wishId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.reserveId = reserveId;
        this.listId = listId;
        this.categoryId = categoryId;
    }

    public int getWishId() {
        return wishId;
    }

    public void setWishId(int wishId) {
        this.wishId = wishId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getReserveId() {
        return reserveId;
    }

    public void setReserveId(int reserveId) {
        this.reserveId = reserveId;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
