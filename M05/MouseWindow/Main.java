package application;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.stage.StageStyle;
import javafx.scene.input.KeyCode;
import javafx.stage.Screen;
import javafx.scene.robot.Robot;
import javafx.scene.image.WritableImage;
import javafx.geometry.Rectangle2D;
import javafx.geometry.Side;
import javafx.scene.image.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;


public class Main extends Application {
	
	// Variables
	private static Boolean showZoomWindow = false;
	private static BorderPane header = new BorderPane();
	private static Screen screen = Screen.getPrimary();
	
	Robot robot = new Robot();
	Rectangle2D windowRect = new Rectangle2D(0, 0, (int)screen.getBounds().getWidth(), (int)screen.getBounds().getHeight());
	WritableImage bgCapture = new WritableImage((int)screen.getBounds().getWidth(), (int)screen.getBounds().getHeight());
	WritableImage imgReturn = robot.getScreenCapture(bgCapture, windowRect);
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		try {
			
			// Set the stage to transparent 
			// When scene is set to opacity of 0.01, the window is not visible
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			
			// Set title at top of window for the stage
			primaryStage.setTitle("Mouse Zoom");
						
			// Create a VBox layout to add objects to vertically
			VBox vBox = new VBox(buildDraggableHeader());
			
			Scene scene = new Scene(vBox, 400, 400);
			
	        // Create a label and add to VBox
	        Label appTitle = new Label("Mouse Zoom");
	        vBox.getChildren().add(appTitle);
	        
	        //Creating the settings button to open the app settings
	        Button settingsButton = new Button("Settings");
	        vBox.getChildren().add(settingsButton);
	        
	        // Action event for settings button pressed
	        EventHandler<ActionEvent> settingsBtnEvent = new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent e)
	            {
	 // ***** Add settings button logic
	            }
	        };
	  
	        // when button is pressed
	        settingsButton.setOnAction(settingsBtnEvent);
	        
	        //Creating the capture button to get a screen capture
	        Button captureButton = new Button("Capture");
	        vBox.getChildren().add(captureButton);
	        
	        // Action event for capture button pressed
	        EventHandler<ActionEvent> captureBtnEvent = new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent e)
	            {
	            	// Hide the scene and children and set the stage to full screen
	            	// This allows the mouse to track the entire window 
	            	scene.setFill(Color.TRANSPARENT);
	    			primaryStage.setFullScreen(true);
	    			appTitle.setVisible(false);
	    			captureButton.setVisible(false);
	    			settingsButton.setVisible(false);
	    			
	    			// Set header opacity vs visible due to window not showing 
	    			// when all objects in pane are set visible = false
	    			header.setOpacity(0.01);
	    			
	 // ***** Add capture button logic
	    			
	    			vBox.setBackground(new Background(
	    	                new BackgroundImage(
	    	                		bgCapture,
	    	                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
	    	                        new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
	    	                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true))));

	            }
	        };
	        
	        // when button is pressed
	        captureButton.setOnAction(captureBtnEvent);
			
			// Set the VBox spacing between objects
			vBox.setSpacing(50);
	        vBox.setAlignment(Pos.CENTER);			
	
			// Create a mouse pressed handler 
		    vBox.setOnMousePressed(e -> {
				
				// Set boolean to toggle showing zoom window with mouse click
				if (showZoomWindow == true) {
					showZoomWindow = false;
				}else {
					showZoomWindow = true;
					
					//***** Create zoom window at mouse point 
				} 
			});
			
		    vBox.setOnMouseMoved(e -> {
				if (showZoomWindow == true) {
					System.out.println(e.getScreenX());
					System.out.println(e.getScreenY());	    			
	    			
//	    			vBox.setBackground(new Background(
//	    	                new BackgroundImage(
//	    	                		bgCapture,
//	    	                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
//	    	                        new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
//	    	                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true))));
					
					//WritableImage newImage = new WritableImage(bgCapture.getPixelReader(), 0, 0, 200, 200);
					
					ImageView imageView = new ImageView(bgCapture);
					Rectangle2D cropRect = new Rectangle2D(0, 0, 200, 200);
					imageView.setViewport(cropRect);
					imageView.setFitWidth(2);
					imageView.setFitHeight(2);
					imageView.setSmooth(true);
					
					imageView.setX(e.getScreenX()); 
				    imageView.setY(e.getScreenY());
					
					Pane pane = new Pane(imageView);
					Scene offScreenScene = new Scene(pane);
					WritableImage croppedImage = imageView.snapshot(null, null);
					
					Canvas canvas = new Canvas((int)screen.getBounds().getWidth(), (int)screen.getBounds().getHeight());
					GraphicsContext gc = canvas.getGraphicsContext2D();
					gc.drawImage(croppedImage, e.getScreenX(), e.getScreenY());

				}
			});
		    
		    vBox.setOnKeyPressed(keyEvent -> {
		        KeyCode key = keyEvent.getCode();
		        if (key == KeyCode.ESCAPE) {
		        	appTitle.setText("Test Escape Button");
	            	scene.setFill(Color.WHITE);
	    			primaryStage.setFullScreen(false);
	    			header.setOpacity(1);
	    			appTitle.setVisible(true);
	    			captureButton.setVisible(true);
	    			settingsButton.setVisible(true);
		        }
		    });
		    
		    vBox.setStyle("-fx-background-color: rgba(255, 255, 255, 0.01);"); 
					    
			primaryStage.setTitle("Mouse Zoom Window"); // Set the stage title
			primaryStage.setScene(scene); // Place the scene in the stage
			primaryStage.show(); // Display the stage
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private Node buildDraggableHeader() {
		
		// Create a border pane as a header
        header.setMinHeight(24);
        
        // Create a close button
        Button xButton = new Button("X");
        header.getChildren().add(xButton);
        
        // Action event for settings button pressed
        EventHandler<ActionEvent> xBtnEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
            	System.exit(0);
            }
        };
        
        // Set action event for xButton pressed
        xButton.setOnAction(xBtnEvent);
        
        // Set move x button to the right on the header
        header.setRight(new HBox(xButton));
        
        StackPane title = new StackPane(new Label("Mouse Zoom"));
        title.setStyle("-fx-font-weight:bold;");
        title.setAlignment(Pos.CENTER_LEFT);
        header.setLeft(title);
        header.setStyle("-fx-background-color:#999999;-fx-border-width: 0 0 2 0;-fx-border-color:#555555;");
        header.setPadding(new Insets(0, 0, 0, 3));
        // EXPLICITLY INCLUDING THE DRAG LOGIC !!!
        DoubleProperty x = new SimpleDoubleProperty();
        DoubleProperty y = new SimpleDoubleProperty();
        header.setOnMousePressed(e -> {
            x.set(e.getSceneX());
            y.set(e.getSceneY());
        });
        header.setOnMouseDragged(e -> {
            header.getScene().getWindow().setX(e.getScreenX() - x.get());
            header.getScene().getWindow().setY(e.getScreenY() - y.get());
        });
        return header;
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}

