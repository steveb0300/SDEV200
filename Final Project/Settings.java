package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Settings implements DefaultSettings {
	private double zoomLevel = DEFAULT_ZOOM_LEVEL;
	private double zoomWindowWidth = ZOOM_WINDOW_WIDTH;
	private double zoomWindowHeight = ZOOM_WINDOW_HEIGHT;

    public double getZoomLevel() {
        return zoomLevel;
    }
    
    public double getZoomWindowWidth() {
    	return zoomWindowWidth;
    } 
    
    public double getZoomWindowHeight() {
    	return zoomWindowHeight;
    }
    
    public void setZoomLevel(double z) {
    	zoomLevel = z;
    }
    
    public void setZoomWindowWidth(double w) {
    	zoomWindowWidth = w;
    }
    
    public void setZoomWindowHeight(double h) {
    	zoomWindowHeight = h;
    }

    public void zoomIn() {
    	if (zoomLevel <= 10) {
    		zoomLevel *= 1.005; // Increase zoom level
    	}
    }

    public void zoomOut() {
    	if (zoomLevel >= 1) {
    		zoomLevel /= 1.005; // Decrease zoom level
    	}
    }
    
    public void applySettings() {
        try {
            setZoomLevel(Double.parseDouble(Main.zoomTextField.getText()));
            setZoomWindowWidth(Double.parseDouble(Main.widthTextField.getText()));
            setZoomWindowHeight(Double.parseDouble(Main.heightTextField.getText()));
        } catch (NumberFormatException e) {
            // create a alert
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("Wrong Entry");
            a.setHeaderText("Enter numeric values only.");
            a.show();
        }
    }
}
