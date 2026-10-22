package com.example.projekt2_gruppe_2.model;

public class WishListSharedWith {
    private int userID;
    private int listID;

    public WishListSharedWith() { }

    public WishListSharedWith(int userID, int listID) {
        this.userID = userID;
        this.listID = listID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getListID() {
        return listID;
    }

    public void setListID(int listID) {
        this.listID = listID;
    }
}
