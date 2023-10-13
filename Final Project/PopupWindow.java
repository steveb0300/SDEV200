package application;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.robot.Robot;

public abstract class PopupWindow extends Settings {
	
	protected Rectangle2D rectBounds;
	protected Robot robot;
	
	public PopupWindow() {
		
		rectBounds = new Rectangle2D(0,0,1,1);
		robot = new Robot();
	}
	
	public abstract Image createPopupWindow(Rectangle2D r); 
}
