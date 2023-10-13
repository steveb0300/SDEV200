package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Popup;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;


public class Main extends Application {
	
	// Init Settings class
	Settings settings = new Settings();
	
	// Init static fields
	static Rectangle2D popupBounds = new Rectangle2D(0,0,1,1);
	static Boolean showZoomWindow = false;
	static TextField zoomTextField = new TextField();
	static TextField widthTextField = new TextField();
	static TextField heightTextField = new TextField();
	
	// Call main funtion
    public static void main(String[] args) {
        launch(args);
    }
    
    // Override stage function
    @Override
    public void start(Stage primaryStage) {
    	
    	// Set stage title to blank
        primaryStage.setTitle("");
        
        // Create root pane
        Pane root = new Pane();
        Scene scene = new Scene(root, 320, 400);
        primaryStage.setScene(scene);
        
        // Create GridPane to set up user interface
        GridPane graphicsPane = createUIPane(primaryStage, scene);
        root.getChildren().add(graphicsPane);

        // Init a popup window
        Popup popup = new Popup();        
        
        // Create an outline for the zoom window
        Rectangle zoomedOutline = new Rectangle();
        zoomedOutline.setWidth(settings.getZoomWindowWidth());
        zoomedOutline.setHeight(settings.getZoomWindowHeight());
        zoomedOutline.setStyle("-fx-fill: transparent; -fx-stroke: red; -fx-stroke-width: 8;");
        popup.getContent().add(zoomedOutline);
        
        // Create an ImageView to load the screen capture to
        ImageView zoomedImage = new ImageView();
        zoomedImage.setPreserveRatio(false);
        zoomedImage.setFitWidth(settings.getZoomWindowWidth());
        zoomedImage.setFitHeight(settings.getZoomWindowHeight());
        popup.getContent().add(zoomedImage);
        
        // Add event handler for mouse moving event to update zoom window
        scene.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	
            	// Only show window if in start zoom window mode
            	if (showZoomWindow == true) {
            		
            		// Get updated settings
	            	double zoomLevel = settings.getZoomLevel();
	            	double zoomWindowWidth = settings.getZoomWindowWidth();
	                double zoomWindowHeight = settings.getZoomWindowHeight();
	                
	                // Update zoom window outline width and height
	                zoomedOutline.setWidth(zoomWindowWidth);
	                zoomedOutline.setHeight(zoomWindowHeight);
	            	
	                // Update the zoom window image as mouse moves
	            	popupBounds = new Rectangle2D(event.getScreenX() - (zoomWindowWidth/zoomLevel/2), event.getScreenY() - (zoomWindowHeight/zoomLevel/2), zoomWindowWidth/zoomLevel, zoomWindowHeight/zoomLevel);
	       	     	ZoomWindow zWin = new ZoomWindow();
	       	     	zoomedImage.setImage(zWin.createPopupWindow(popupBounds));
	                
	                // Update the popup position based on the mouse location
	                popup.show(primaryStage);
	                
	                // Update zoom window position when close to top of screen
	                if (event.getScreenY() < zoomWindowHeight * 1.6) {
	                	System.out.println(event.getScreenY());
	                	//System.out.println(zoomWindowHeight * 1.6);
	                	popup.setY(event.getScreenY() + zoomWindowHeight/2);
	                } else {
	                	popup.setY(event.getScreenY() - zoomWindowHeight * 1.6);
	                }
	                popup.setX(event.getScreenX() - zoomWindowWidth/2);
	                
            	}
            }
        });
        
        // Add event handler for scrolling mouse will or tack pad
        scene.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
            	double deltaY = event.getDeltaY();
            	
            	// Only allow scroll if in start zoom window mode
            	if (showZoomWindow == true) {
            		
            		// Update settings
            		double zoomLevel = settings.getZoomLevel();
	            	double zoomWindowWidth = settings.getZoomWindowWidth();
	                double zoomWindowHeight = settings.getZoomWindowHeight();
	                
	                // Update zoom image depending on scroll direction
	                if(deltaY < 0) {
	                	//scroll up
	                	event.consume();
	                	settings.zoomIn();
	                	
	                	// Update zoom image
	                	popupBounds = new Rectangle2D(event.getScreenX() - (zoomWindowWidth/zoomLevel/2), event.getScreenY() - (zoomWindowHeight/zoomLevel/2), zoomWindowWidth/zoomLevel, zoomWindowHeight/zoomLevel);
	           	     	ZoomWindow zWin = new ZoomWindow();
		       	     	zoomedImage.setImage(zWin.createPopupWindow(popupBounds));
	                }
	                
	             // Update zoom image depending on scroll direction
	                if(deltaY > 0) {
	                	//scroll down
	                	settings.zoomOut();
	                	
	                	// Update zoom image
	                	popupBounds = new Rectangle2D(event.getScreenX() - (zoomWindowWidth/zoomLevel/2), event.getScreenY() - (zoomWindowHeight/zoomLevel/2), zoomWindowWidth/zoomLevel, zoomWindowHeight/zoomLevel);
	                	ZoomWindow zWin = new ZoomWindow();
		       	     	zoomedImage.setImage(zWin.createPopupWindow(popupBounds));
	                } 
            	}
            }
        });
        
        // Show stage
        primaryStage.show(); 
    }
    
    // Functin to set up user interface
    private GridPane createUIPane(Stage ps, Scene s) {
    	
    	// Init GridPane and set gaps between nodes
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));
        
        // Set labels and text entry fields
        Label mouseZoomLabel = new Label("Mouse Zoom");
        mouseZoomLabel.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));
        GridPane.setColumnSpan(mouseZoomLabel, 2);
        GridPane.setHalignment(mouseZoomLabel, HPos.CENTER);

        Label zoomLabel = new Label("Zoom Level:");
        zoomTextField = new TextField(Double.toString(settings.getZoomLevel()));

        Label widthLabel = new Label("Zoom Window Width:");
        widthTextField = new TextField(Double.toString(settings.getZoomWindowWidth()));

        Label heightLabel = new Label("Zoom Window Height:");
        heightTextField = new TextField(Double.toString(settings.getZoomWindowHeight()));
        
        s.setOnKeyPressed(keyEvent -> {
	        KeyCode key = keyEvent.getCode();
	        if (key == KeyCode.ESCAPE) {
	        	
	        	showZoomWindow = false;
            	
            	ps.setMaximized(false);
            	ps.setOpacity(1);
            	s.setFill(new Color(0,0,1,1));
            	System.out.println("start");
	        }
	    });
        
        // Application instructions
        Label instructionsOne = new Label("Instructions");
        instructionsOne.setFont(Font.font("Amble CN", FontWeight.BOLD, 14));
        GridPane.setColumnSpan(instructionsOne, 2);
        GridPane.setHalignment(instructionsOne, HPos.LEFT);
        
        Label instructionsTwo = new Label("Press ESCAPE twice to exit zoom window.");
        GridPane.setColumnSpan(instructionsTwo, 2);
        GridPane.setHalignment(instructionsTwo, HPos.LEFT);
        
        Label instructionsThree = new Label("Use mouse wheel to zoom in/out.");
        GridPane.setColumnSpan(instructionsThree, 2);
        GridPane.setHalignment(instructionsThree, HPos.LEFT);
        
        // Create apply settings button
        Button applyButton = new Button("Apply Settings");
        applyButton.setStyle("-fx-font: 18 arial; -fx-base: #f5f5f5;");
        applyButton.setOnAction(event -> settings.applySettings());
        applyButton.setMinWidth(200);
        GridPane.setColumnSpan(applyButton, 2);
        GridPane.setHalignment(applyButton, HPos.CENTER);
        
        // Create start zoom window button
        Button startZoomWindowButton = new Button("Start Zoom Window");
        startZoomWindowButton.setStyle("-fx-font: 18 arial; -fx-base: #95e126;");
        startZoomWindowButton.setMinWidth(200);
        startZoomWindowButton.setOnAction(e -> {
        	showZoomWindow = true;
        	ps.setMaximized(true);
        	ps.setOpacity(0.01);
        	s.setFill(new Color(0,0,1,0.01));
        	System.out.println("start");
        });
        GridPane.setColumnSpan(startZoomWindowButton, 2);
        GridPane.setHalignment(startZoomWindowButton, HPos.CENTER);
        
        // Set all user interface nodes in proper rows
        gridPane.addRow(0, mouseZoomLabel);
        gridPane.addRow(1, zoomLabel, zoomTextField);
        gridPane.addRow(2, widthLabel, widthTextField);
        gridPane.addRow(3, heightLabel, heightTextField);
        gridPane.addRow(4, applyButton);
        gridPane.addRow(5, new Text(""));
        gridPane.addRow(6, instructionsOne);
        gridPane.addRow(7, instructionsTwo);
        gridPane.addRow(8, instructionsThree);
        gridPane.addRow(9, new Text(""));
        gridPane.addRow(10, startZoomWindowButton);
        
        //Setting the Grid alignment 
        gridPane.setAlignment(Pos.CENTER);
        
        return gridPane;
    }
}