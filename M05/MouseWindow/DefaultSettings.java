package application;

public interface DefaultSettings {
	
	static Double focalSpotX = 0.0;
	static Double focalSpotY = 0.0;
	static Double focalWidth = 0.0;
	static Double focalHeight = 0.0;
	static Double zoomLevel = 0.0;
	static Double bgBlurLevel = 0.0;
	static Double winOutlineColor[] = new Double[3];
	
	public static Double[] getOutlineColor() {
		// Add get logic here
		Double[] outlineColor = new Double[3];
		return outlineColor;
	}
	
	public static Double getBlurLevel() {
		// Add get logic here
		return 0.0;
	}
	
	public static Double[] getFocalSize() {
		// Add get logic here
		Double[] focalSize = new Double[3];
		return focalSize;
	}
	
	public static Double getZoomLevel() {
		// Add get logic here
		return 0.0;
	}
	
	public static void setOutlineColor(Double r, Double g, Double b) {
		// Add set logic here
	}
	
	public static void setBlurLevel(Double lvl) {
		// Add set logic here
	}
	
	public static void setFocalSize(Double w, Double h) {
		// Add set logic here
	}
	
	public static void setZoomLevel(Double lvl) {
		// Add set logic here
	}
}