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

        String sql = "SELECT wishlist.* FROM user JOIN wishlist ON user.userID = wishlist.userID WHERE user.email = ?";

        try (Connection con = dataSource.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("listID");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int userId = rs.getInt("userID");
                String image = rs.getString("image");

                wishlists.add(new WishList(id, title, description, userId, image));
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
                int userId = rs.getInt("userID");
                String image = rs.getString("image");

                wishLists.add(new WishList(id, title, description, userId, image));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wishLists;
    }

    public void deleteWishList(int userId, int listId) {
        String deleteSharesSql = "DELETE FROM wishlistsharedwith WHERE listID = ? "
                + "AND EXISTS (SELECT 1 FROM wishlist WHERE listID = ? AND userID = ?)";
        String deleteWishesSql = "DELETE FROM wish WHERE listID = ? "
                + "AND EXISTS (SELECT 1 FROM wishlist WHERE listID = ? AND userID = ?)";
        String deleteWishListSql = "DELETE FROM wishlist WHERE listID = ? AND userID = ?";

        try (Connection con = dataSource.getConnection()) {
            con.setAutoCommit(false);
            try {
                try (PreparedStatement deleteShares = con.prepareStatement(deleteSharesSql)) {
                    deleteShares.setInt(1, listId);
                    deleteShares.setInt(2, listId);
                    deleteShares.setInt(3, userId);
                    deleteShares.executeUpdate();
                }

                try (PreparedStatement deleteWishes = con.prepareStatement(deleteWishesSql)) {
                    deleteWishes.setInt(1, listId);
                    deleteWishes.setInt(2, listId);
                    deleteWishes.setInt(3, userId);
                    deleteWishes.executeUpdate();
                }

                try (PreparedStatement deleteWishList = con.prepareStatement(deleteWishListSql)) {
                    deleteWishList.setInt(1, listId);
                    deleteWishList.setInt(2, userId);
                    deleteWishList.executeUpdate();
                }

                con.commit();
            } catch (SQLException e) {
                try {
                    con.rollback();
                } catch (SQLException rollbackError) {
                    e.addSuppressed(rollbackError);
                }
                throw e;
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Could not delete wishlist", e);
        }
    }
}
