package com.example.projekt2_gruppe_2.repository;

import com.example.projekt2_gruppe_2.model.Wish;
import com.example.projekt2_gruppe_2.model.WishCategories;
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
                wishCategories.add(new WishCategories(id, title, image));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  wishCategories;
    }


    public ArrayList<Wish> getWishes(int listID) {
        ArrayList<Wish> wishes = new ArrayList<>();

        String sql = "SELECT * FROM wish WHERE listID = ?";
        try (Connection con = dataSource.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, listID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int wishID = rs.getInt("wishID");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int price = rs.getInt("price");
                int reserveId = rs.getInt("reserveID");
                int listId = rs.getInt("listID");
                int categoryId = rs.getInt("categoryID");
                wishes.add(new Wish(wishID, title, description, price, reserveId, listId, categoryId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  wishes;
    }

    public void addWish(
            Integer listID,
            String title,
            String description,
            Integer price,
            String link,
            Integer categoryID) {

        String sql = """
            INSERT INTO wish (title, description, price, link, listID, categoryID)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        try (Connection con = dataSource.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, description);
            ps.setInt(3, price);
            ps.setString(4, (link == null || link.isBlank()) ? null : link);
            ps.setInt(5, listID);
            ps.setInt(6, categoryID);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reserveWish(int wishID, int listID, int userID) {
        String sql = "UPDATE wish SET reserveID = ? WHERE wishID = ? AND listID = ? AND reserveID IS NULL";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userID);
            ps.setInt(2, wishID);
            ps.setInt(3, listID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void unreserveWish(int wishID, int listID, int userID) {
        String sql = "UPDATE wish SET reserveID = NULL WHERE wishID = ? AND listID = ? AND reserveID = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, wishID);
            ps.setInt(2, listID);
            ps.setInt(3, userID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteWish(int wishID, int listID) {
        String sql = "DELETE FROM wish WHERE wishID = ? AND listID = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, wishID);
            ps.setInt(2, listID);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Could not delete wish", e);
        }
    }
}
