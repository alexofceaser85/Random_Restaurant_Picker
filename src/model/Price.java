package src.model;

/**
 * Models the price component for use with the Yelp API.
 * 
 * @author Alexander Ayers
 * @version Fall 2020
 *
 */
public enum Price {
	Any("Any"), $("1"), $$("2"), $$$("3"), $$$$("4");

	private final String value;

	Price(String value) {
		this.value = value;
	}

	/**
	 * Gets the value of the price.
	 * 
	 * @precondition none
	 * @postconditon none
	 *
	 * @return the value of the price.
	 */
	public String getValue() {
		return this.value;
	}
}
