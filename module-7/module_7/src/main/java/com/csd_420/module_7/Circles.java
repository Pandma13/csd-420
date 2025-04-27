/*Megan Wheeler
Assignment 7
Follow the directions below:

1. Create an external CSS style sheet that defines a class for white fill and
    black stroke color and an ID for red and green color.
2. Write a JavaFX program that displays four circles and uses the style class
    and ID. The sample run of the program is shown in the following image.
3. Use the mystyle.css found early in Chapter 31.
4. Write test code that ensures your code functions correctly.*/

package com.csd_420.module_7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Circles extends Application {
    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox(5);
        Scene scene = new Scene(hBox, 300, 250);
        scene.getStylesheets().add(getClass().getResource("/com/csd_420/module_7/mystyle.css").toExternalForm());
        
        Pane pane1 = new Pane();
        Circle circle1 = new Circle(39, 125, 30);
        pane1.getChildren().add(circle1);
        pane1.getStyleClass().add("border");
        
        circle1.getStyleClass().add("plaincircle");
        
        Pane pane2 = new Pane();
        Circle circle2 = new Circle(30, 125, 30);
        Circle circle3 = new Circle(95, 125, 30);
        Circle circle4 = new Circle(165, 125, 30);
        circle2.getStyleClass().add("plaincircle");
        circle3.setId("redcircle");
        circle4.getStyleClass().addAll("circleborder", "plaincircle");
        circle4.setId("greencircle");
        pane2.getChildren().addAll(circle2, circle3, circle4);
//        pane2.getStyleClass().add("border");
        
        hBox.getChildren().addAll(pane1, pane2);
        
        primaryStage.setTitle("Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}