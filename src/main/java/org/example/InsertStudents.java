
package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertStudents {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbconnect";
        String user = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO students (name, address) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            // First student
            stmt.setString(1, "Alice Second");
            stmt.setString(2, "Germany");
            stmt.executeUpdate();

            // Second student
            stmt.setString(1, "Bob Johnson");
            stmt.setString(2, "France");
            stmt.executeUpdate();

            // Third student
            stmt.setString(1, "Charlie Brown");
            stmt.setString(2, "Rwanda");
            stmt.executeUpdate();

            System.out.println("Students inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
