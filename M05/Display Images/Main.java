// M05 - Assignment 1
// Chapter 14  Exercise 14.1
// Display images in a grid utilizing javaFX

package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class Main extends Application {
	
	// Call the start method by passing in the primary stage
	public void start(Stage primaryStage) {
		try {

			// Load images
			Image imageOne = new Image(getClass().getResourceAsStream("images/us.gif"));
			Image imageTwo = new Image(getClass().getResourceAsStream("images/ca.gif"));
			Image imageThree = new Image(getClass().getResourceAsStream("images/uk.gif"));
			Image imageFour = new Image(getClass().getResourceAsStream("images/china.gif"));
			
			// Create image views
			ImageView viewOne = new ImageView();
			ImageView viewTwo = new ImageView();
			ImageView viewThree = new ImageView();
			ImageView viewFour = new ImageView();
			
			// Set image view images from loaded images
			viewOne.setImage(imageOne);
			viewTwo.setImage(imageTwo);
			viewThree.setImage(imageThree);
			viewFour.setImage(imageFour);
			
			// Create a grid pane to organize images in
			GridPane pane = new GridPane();
			
			// Add the image views to the grid pane and set coordinates 
			pane.add(viewOne, 0, 0);
			pane.add(viewTwo, 1, 0);
			pane.add(viewThree, 0, 1);
			pane.add(viewFour, 1, 1);

			// Create a scene from the grid pane. 
			// Create the stage with a title and scene and display it 
			Scene scene = new Scene(pane);
			primaryStage.setTitle("Display Imagae"); // Set the stage title
			primaryStage.setScene(scene); // Place the scene in the stage
			primaryStage.show(); // Display the stage.
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
