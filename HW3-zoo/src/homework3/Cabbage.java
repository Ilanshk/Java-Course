package homework3;

import homework3.MessageUtility;

/**
 * @author baroh
 *
 */
public class Cabbage extends Plant {
	public Cabbage() {
		MessageUtility.logConstractor("Cabbage", "Cabbage");
	}
	
	
	/**
	 * Constructor of the cabbage with the height of the cabbage,the default location of the cabbage and the weight of the cabbage.
	 * @param height - height of the cabbage.
	 * @param point - default location of the cabbage.
	 * @param weight - weight of the cabbage.
	 */
	public Cabbage(double height,Point point,double weight) {
		this.setLocation(point);
		this.setHeight(height);
		this.setWeight(weight);
		super.loadImages("cabbage");
		MessageUtility.logConstractor("Cabbage", "Cabbage");
	}
	

	
	
	/**
	 * Returns the name of the class as a string.
	 * @return name of the class.
	 */
	public  String get_name_of_class() {
		return "Cabbage";
	}
	
	
	/**
	 * Returns the color of the cabbage.
	 * @return color of cabbage.
	 */
	public String getColor() {
		return "Green";
	}

}
