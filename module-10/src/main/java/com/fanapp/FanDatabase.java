package com.fanapp;

// Megan Wheeler
// Assignment 10
// 7 May 2025

// This program is a simple database management system for a fan database.
// It allows users to display and update records in the database.

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

    // Initialize components
    private JTextField idField, firstNameField, lastNameField, favoriteTeamField;
    private JButton displayButton, updateButton;
    private Connection connection;

    // Constructor for the FanDatabase class
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

    // Initialize the database connection
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

    // Display a record from the database
    private void displayRecord() {
        // Get the ID from the input field
        try {
            String id = idField.getText();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter an ID");
                return;
            }

            // Create a query to select the record from the database
            String query = "SELECT * FROM fans WHERE ID = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            // If the record is found, set the text fields to the record values
            if (rs.next()) {
                firstNameField.setText(rs.getString("firstname"));
                lastNameField.setText(rs.getString("lastname"));
                favoriteTeamField.setText(rs.getString("favoriteteam"));
            } else {
                JOptionPane.showMessageDialog(this, "No record found with ID: " + id);
            }

            // Close the result set and prepared statement
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error displaying record: " + e.getMessage());
        }
    }

    // Update a record in the database
    private void updateRecord() {
        try {
            // Get the ID from the input field
            String id = idField.getText();
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String favoriteTeam = favoriteTeamField.getText();

            // If any of the fields are empty, show an error message
            if (id.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || favoriteTeam.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields");
                return;
            }

            // Create a query to update the record in the database
            String query = "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, favoriteTeam);
            pstmt.setString(4, id);

            // Execute the update
            int rowsAffected = pstmt.executeUpdate();

            // If the record is updated, show a success message
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Record updated successfully");
            } else {
                JOptionPane.showMessageDialog(this, "No record found with ID: " + id);
            }

            // Close the prepared statement
            pstmt.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating record: " + e.getMessage());
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FanDatabase().setVisible(true);
        });
    }
}
