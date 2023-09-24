// M05 - Assignment 2
// Chapter 15  Exercise 15.7
// Change the color of a circle with mouse events

package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		try {
	
			// Create a circle and set its properties
			Circle circle = new Circle(150);
			circle.setFill(Color.WHITE);
			circle.setStroke(Color.BLACK);
			
			// Create a stack pane to add circle to
			StackPane pane = new StackPane();
			
			// Add circle to stack pane
			pane.getChildren().add(circle);
	
			// Create a mouse pressed handler 
			// Set fill color when mouse is pressed
			pane.setOnMousePressed(e -> {
				circle.setFill(Color.BLACK);
			});
			
			// Create a mouse released handler 
			// Set fill color when mouse is released 
			pane.setOnMouseReleased(e -> {
				circle.setFill(Color.WHITE);
				circle.setStroke(Color.BLACK);
			});
	
			// Create a scene from the stack pane. 
			// Create the stage with a title and scene and display it 
			Scene scene = new Scene(pane, 400, 400);
			primaryStage.setTitle("Change Color Using a Mouse"); // Set the stage title
			primaryStage.setScene(scene); // Place the scene in the stage
			primaryStage.show(); // Display the stage
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
