package com.example.projekt2_gruppe_2.repository;

import com.example.projekt2_gruppe_2.model.Wish;
import com.example.projekt2_gruppe_2.model.WishCategories;
import com.example.projekt2_gruppe_2.model.WishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class WishRepo {
    @Autowired
    DataSource dataSource;

    public ArrayList<WishCategories> getWishCategories() {
        ArrayList<WishCategories> wishCategories = new ArrayList<>();

        String sql = "SELECT * FROM wishcategories";
        try (Connection con = dataSource.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("categoryID");
                String title = rs.getString("title");
                String image = rs.getString("image");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  wishCategories;
    }

    public ArrayList<WishList> getWishLists(int userid) {
        ArrayList<WishList> wishLists = new ArrayList<>();

        String sql = "SELECT * FROM wishlist WHERE userID = ?";
        try (Connection con = dataSource.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("listID");
                String title = rs.getString("title");
                String description = rs.getString("description");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  wishLists;
    }

    public ArrayList<Wish> getWishes(int listid) {
        ArrayList<Wish> wishes = new ArrayList<>();

        String sql = "SELECT * FROM wishlist WHERE listID = ?";
        try (Connection con = dataSource.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, listid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("listID");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int userid = rs.getInt("userID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  wishes;
    }

    public ArrayList<WishList> getWishListsByEmail(String email) {
        ArrayList<WishList> wishlists = new ArrayList<>();

        String sql = "SELECT * FROM user JOIN wishlist ON user.userID = wishlist.userID WHERE user.email = ?";


        return wishlists;


    }
}
