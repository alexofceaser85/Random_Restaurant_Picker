package src.model;

/**
 * Models the radius for distance from location.
 * 
 * @author Alexander Ayers
 * @version Fall 2020
 *
 */
public enum Radius {
	FIVE(8000, "5 Miles"), TEN(16000, "10 Miles"), FIFTEEN(24000, "15 Miles"), TWENTY(32000, "20 Miles"),
	TWENTYFIVE(40000, "25 Miles");

	private String display;

	private int meters;

	Radius(int meters, String display) {
		this.display = display;
		this.meters = meters;
	}

	/**
	 * Gets the text display of the radius.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the text display of the radius.
	 */
	public String getDisplay() {
		return this.display;
	}

	/**
	 * Gets the number of meters respective to the number of miles.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of meters.
	 */
	public int getMeters() {
		return this.meters;
	}
	
	@Override
	public String toString() {
		return this.display;
		
	}
}
