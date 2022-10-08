package homework3;

/**
 * This class represents functionality of movement in space.
 * @author Ilan Shklover, Shira Cohen
 *
 */
public abstract class Mobile implements Ilocatable {
	private Point location;
	/**
	 * Certain location on in 2D hinge system.
	 */
	private double totalDistance;
	/**
	 * Represents all the distance the animal has been through till this moment.
	 */
	
	
	
	/**
	 * Constructor of Mobile - initializes the data members
	 * @param p1 - A certain point object.
	 */
	public Mobile(Point p1) {
	    this.location = new Point(p1);	
		this.totalDistance = 0;
	}
	
	/**
	 * This method updates the total distance the animal has been through.
	 * @param d- Distance the animal moved which need to be added to 
	 * the animal's total distance.
	 */
	public abstract void addTotalDistance(double d);
	
	
	/**
	 * Calculates the distance between the current location and the location received as a parameter.
	 * @param p - A certain point object.
	 * @return
	 */
	public abstract double calcDistance(Point p);
	
	
	
	/**
	 * 
	 * @param p- The destination of an animal.
	 * @return - The distance the animal will move from the current location to the destination received as a parameter.
	 */
	public abstract double move(Point p);
	
	
	/**
	 * Returns the animal's current location.
	 * @return - current location(point)
	 */
	public Point getLocation() {
		return new Point(this.location);
	}
	
	/**
	 * Changes the location.
	 * @param point - the new location.
	 * @return - True if the location changed. Else, if the location did not change returns false.
	 */
	public boolean setLocation(Point point) {
		this.location.set(point.get_x(), point.get_y());
		return true;
		
	}
	
	/**
	 * Returns the total distance the animal was through.
	 * @return-All the distance the animal moved from the beginning.
	 */
	public double get_distance() {
		return this.totalDistance;
	}
	
	
	/**
	 * Updates the animal's total distance with the parameter received.
	 * @param distance - The distance the animal moved from its previous location.
	 * @return- True if the total distance of the animal changed, else false.
	 */
	public boolean set_totalDistance(double distance) {
		if(distance > 0) {
			this.totalDistance = this.get_distance() + distance;
			return true;
		}
		return false;
	}

}
