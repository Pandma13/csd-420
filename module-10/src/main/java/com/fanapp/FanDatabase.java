package com.fanapp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FanDatabase extends JFrame {
    private JTextField idField, firstNameField, lastNameField, favoriteTeamField;
    private JButton displayButton, updateButton;
    private Connection connection;

    public FanDatabase() {
        // Set up the frame
        setTitle("Fan Database Management");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Create main panel with padding
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Initialize components
        idField = new JTextField();
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        favoriteTeamField = new JTextField();
        displayButton = new JButton("Display Record");
        updateButton = new JButton("Update Record");

        // Add components to panel
        mainPanel.add(new JLabel("ID:"));
        mainPanel.add(idField);
        mainPanel.add(new JLabel("First Name:"));
        mainPanel.add(firstNameField);
        mainPanel.add(new JLabel("Last Name:"));
        mainPanel.add(lastNameField);
        mainPanel.add(new JLabel("Favorite Team:"));
        mainPanel.add(favoriteTeamField);
        mainPanel.add(displayButton);
        mainPanel.add(updateButton);

        // Create container panel with outer padding
        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        containerPanel.add(mainPanel, BorderLayout.CENTER);

        // Add container panel to frame
        add(containerPanel, BorderLayout.CENTER);

        // Add action listeners
        displayButton.addActionListener(e -> displayRecord());
        updateButton.addActionListener(e -> updateRecord());

        // Initialize database connection
        initializeDatabase();

        // Center the frame
        setLocationRelativeTo(null);
    }

    private void initializeDatabase() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            String url = "jdbc:mysql://localhost:3306/databasedb";
            String username = "student1";
            String password = "pass";
            connection = DriverManager.getConnection(url, username, password);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database connection error: " + e.getMessage());
        }
    }

    private void displayRecord() {
        try {
            String id = idField.getText();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter an ID");
                return;
            }

            String query = "SELECT * FROM fans WHERE ID = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                firstNameField.setText(rs.getString("firstname"));
                lastNameField.setText(rs.getString("lastname"));
                favoriteTeamField.setText(rs.getString("favoriteteam"));
            } else {
                JOptionPane.showMessageDialog(this, "No record found with ID: " + id);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error displaying record: " + e.getMessage());
        }
    }

    private void updateRecord() {
        try {
            String id = idField.getText();
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String favoriteTeam = favoriteTeamField.getText();

            if (id.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || favoriteTeam.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields");
                return;
            }

            String query = "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, favoriteTeam);
            pstmt.setString(4, id);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Record updated successfully");
            } else {
                JOptionPane.showMessageDialog(this, "No record found with ID: " + id);
            }

            pstmt.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating record: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FanDatabase().setVisible(true);
        });
    }
}
