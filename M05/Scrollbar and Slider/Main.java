// M05 - Assignment 2
// Chapter 16  Exercise 16.17
// Create scrollbar and slider to select color of text

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;


public class Main extends Application {
	
	// Create text to show the color changing
	protected Text text = new Text("Watch Me Change! ☺");
	
	protected Slider slRed = new Slider();
	protected Slider slGreen = new Slider();
	protected Slider slBlue = new Slider();
	protected Slider slOpacity = new Slider();
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		// Set the font size
		text.setFont(new Font(40));
		
		// Set the slider sizes by setting one slider
		slRed.setPrefSize(400, 40);
		slGreen.setPrefSize(400, 40);
		slBlue.setPrefSize(400, 40);
		slOpacity.setPrefSize(400, 40);
		
		// Create a stack pane for text
		StackPane paneForText = new StackPane(text);
		paneForText.setPadding(new Insets(20, 20, 10, 20));

		// Set slider min and max properties
		slRed.setMin(0.0);
		slRed.setMax(1.0);
		slGreen.setMin(0.0);
		slGreen.setMax(1.0);
		slBlue.setMin(0.0);
		slBlue.setMax(1.0);
		slOpacity.setMin(0.0);
		slOpacity.setMax(1.0);
		
		// Set the slider tick marks
		slRed.setShowTickLabels(true);
		slRed.setShowTickMarks(true);
		slRed.setMajorTickUnit(.5);
		slGreen.setShowTickLabels(true);
		slGreen.setShowTickMarks(true);
		slGreen.setMajorTickUnit(.5);
		slBlue.setShowTickLabels(true);
		slBlue.setShowTickMarks(true);
		slBlue.setMajorTickUnit(.5);
		slOpacity.setShowTickLabels(true);
		slOpacity.setShowTickMarks(true);
		slOpacity.setMajorTickUnit(.5);

		// Create slider event listeners to set color
		slRed.valueProperty().addListener(ov -> setColor());
		slGreen.valueProperty().addListener(ov -> setColor());
		slBlue.valueProperty().addListener(ov -> setColor());
		slOpacity.valueProperty().addListener(ov -> setColor());
		slOpacity.setValue(1);


		// Create a grid pane for labeled sliders
		GridPane paneForSliders = new GridPane();
		paneForSliders.setAlignment(Pos.CENTER);
		paneForSliders.setVgap(5);
		paneForSliders.setHgap(5);
		paneForSliders.add(new Label("Red"), 0, 0);
		paneForSliders.add(slRed, 1, 0);
		paneForSliders.add(new Label("Green"), 0, 1);
		paneForSliders.add(slGreen, 1, 1);
		paneForSliders.add(new Label("Blue"), 0, 2);
		paneForSliders.add(slBlue, 1, 2);
		paneForSliders.add(new Label("Opacity"), 0, 3);
		paneForSliders.add(slOpacity, 1, 3);

		// Place nodes in a border pane
		BorderPane pane = new BorderPane();
		pane.setTop(paneForText);
		pane.setCenter(paneForSliders);

		// Create a scene from the border pane containing text and slider panes 
		// Create the stage with a title and scene and display it 
		Scene scene = new Scene(pane, 500, 300);
		primaryStage.setTitle("Slider Color Changer"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	// Set the text color from listeners
	private void setColor() {
		text.setFill(new Color(slRed.getValue(), 
							   slGreen.getValue(), 
							   slBlue.getValue(), 
							   slOpacity.getValue()));
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
