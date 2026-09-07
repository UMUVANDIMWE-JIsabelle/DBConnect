package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbconnect";
        String user = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "UPDATE students SET address = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, "999 Elm Street"); // new address
            stmt.setInt(2, 2); // update student with id=2
            int rows = stmt.executeUpdate();

            System.out.println(rows + " student(s) updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
