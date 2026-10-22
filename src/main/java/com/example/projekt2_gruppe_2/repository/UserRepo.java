package com.example.projekt2_gruppe_2.repository;

import com.example.projekt2_gruppe_2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class UserRepo {
    @Autowired
    DataSource dataSource;

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();

        String sql = "SELECT * FROM user";
        try (Connection con = dataSource.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("userID");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public Optional<User> findByCredentials(String email, String password) {
        String sql = "SELECT userID, name, email, password FROM user WHERE email = ? AND password = ?";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User user = new User(
                            rs.getInt("userID"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("password")
                    );
                    return Optional.of(user);
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Could not check user credentials", e);
        }

        return Optional.empty();
    }
}
