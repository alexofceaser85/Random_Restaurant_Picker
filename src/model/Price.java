package src.model;

/**
 * Models the price component for use with the Yelp API.
 * 
 * @author Alexander Ayers
 *
 */
public enum Price {
	Any("Any"), $("1"), $$("2"), $$$("3"), $$$$("4");

	private final String value;

	Price(String value) {
		this.value = value;
	}

	/**
	 * 
	 * @precondition none
	 * @postconditon none
	 *
	 * @return
	 */
	public String getValue() {
		return this.value;
	}
}
