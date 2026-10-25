package com.example.projekt2_gruppe_2.repository;

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
public class WishListRepo {

    @Autowired
    DataSource dataSource;

    public ArrayList<WishList> getWishListsByEmail(String email) {
        ArrayList<WishList> wishlists = new ArrayList<>();

        String sql = "SELECT * FROM user JOIN wishlist ON user.userID = wishlist.userID WHERE user.email = ?";

        try (Connection con = dataSource.getConnection()) {
             PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("listID");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    String image = rs.getString("image");

                    WishList wishList = new WishList(id, title, description, image);

                    wishlists.add(wishList);
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wishlists;
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


}
