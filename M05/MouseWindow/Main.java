package application;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Main extends Application {
	
	// Variables
	protected Boolean track = false;
	
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
				if (track == true) {
					track = false;
				}else {
					track = true;
				}
			});
			
			pane.setOnMouseMoved(e -> {
				if (track == true) {
					System.out.println(e.getScreenX());
					System.out.println(e.getScreenY());
				}
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

