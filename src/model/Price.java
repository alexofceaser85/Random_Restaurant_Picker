package src.model;

/**
 * Models the price component for use with the Yelp API.
 * @author Alexander Ayers
 *
 */
public enum Price {
	Any("Any"),
	$("1"),
	$$("2"),
	$$$("3"),
	$$$$("4");

	public final String value;
	
	Price(String value) {
		this.value = value;
	}
}
