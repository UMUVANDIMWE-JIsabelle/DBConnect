package org.example;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class StudentLookup extends JFrame {
    private final JTextField idField = new JTextField(8);
    private final JLabel nameLabel = new JLabel("-");
    private final JLabel addressLabel = new JLabel("-");
    private final JLabel msgLabel = new JLabel(" ");

    public StudentLookup() {
        setTitle("Student Lookup");
        setSize(420, 260);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buildUI();
    }

    private void buildUI() {
        JPanel form = new JPanel(new FlowLayout());
        form.add(new JLabel("Student ID:"));
        form.add(idField);
        JButton btn = new JButton("Search");
        form.add(btn);

        JPanel info = new JPanel(new GridLayout(2, 2, 6, 6));
        info.add(new JLabel("Name:"));
        info.add(nameLabel);
        info.add(new JLabel("Address:"));
        info.add(addressLabel);

        setLayout(new BorderLayout());
        add(form, BorderLayout.NORTH);
        add(info, BorderLayout.CENTER);
        add(msgLabel, BorderLayout.SOUTH);

        btn.addActionListener(e -> search());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentLookup().setVisible(true));
    }

    private void search() {
        String input = idField.getText().trim();
        if (input.isEmpty()) {
            msgLabel.setText("Please enter an ID.");
            return;
        }
        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            msgLabel.setText("ID must be a whole number.");
            return;
        }
        String sql = "SELECT * FROM students WHERE id = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nameLabel.setText(rs.getString("name"));
                    addressLabel.setText(rs.getString("address"));
                    msgLabel.setText("Student found.");
                } else {
                    msgLabel.setText("No student with id " + id);
                }
            }
        } catch (SQLException ex) {
            msgLabel.setText("DB error: " + ex.getMessage());
        }
    }
}
