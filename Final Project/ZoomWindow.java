package application;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class ZoomWindow extends PopupWindow {
	
	public ZoomWindow() {
		
		super();	
	}
	
	public Image createPopupWindow(Rectangle2D r) {
		super.rectBounds = r;	     	
	    WritableImage buffer = new WritableImage(1, 1);
	    Image newImage = this.robot.getScreenCapture(buffer, this.rectBounds);
	    return newImage;
	}
}
