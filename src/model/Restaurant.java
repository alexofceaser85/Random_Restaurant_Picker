package src.model;

import src.error_messages.ErrorMessages;

/**
 * The class responsible for holding the restaurant information
 * 
 * @author Alex DeCesare
 * @version 18-November-2020
 **/

public class Restaurant {
	
	private static final int RESTURANT_MINIMUM_DISTANCE = 0;
	private static final int RESTURANT_MINIMUM_REVIEW_SCORE = 1;
	private static final int RESTURANT_MAXIMUM_REVIEW_SCORE = 5;
	
	private String name;
	private Price price;
	private String location;
	private int distance;
	private double reviewScore;
	private String menuURL;
	private String imageURL;
	private String id;
	
	/**
	 * The constructor for the resturant class
	 * 
	 * @precondition
	 * 		name != null
	 * 		name.isEmpty() == False
	 * 		price != null
	 * 		location != null
	 * 		location.isEmpty() == False
	 * 		distance >= 0
	 * 		reviewScore >= 1
	 * 		reviewScore <= 5
	 * 		menuURL != null
	 * 		menuURL.isEmpty() == False
	 * 		imageURL != null
	 * 		imageURL.isEmpty() == False	
	 *		id != null
	 * 		id.isEmpty() == False	
	 * 
	 * @postcondition 
	 * 		this.name = name
	 * 		this.price = price
	 * 		this.location = location
	 * 		this.distance = distance
	 * 		this.reviewScore = reviewScore
	 * 		this.menuURL = menuURL
	 * 		this.imageURL = imageURL
	 * 		this.id = id
	 * 
	 * @param name the restaurant's name
	 * @param price the restaurant's price
	 * @param location the restaurant's location
	 * @param distance the restaurant's distance from the user
	 * @param reviewScore the restaurant's review score
	 * @param menuURL the URL to the restaurant's menu
	 * @param imageURL the URL to the restaurant's image
	 * @param id the restaurant's id
	 **/
	
	public Restaurant(String name, Price price, String location, int distance, double reviewScore, String menuURL, String imageURL, String id) {
		
		if(name == null) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_NAME_SHOULD_NOT_BE_NULL);
		}
		if(name.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_NAME_SHOULD_NOT_BE_EMPTY);
		}
		if(price == null) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_PRICE_SHOULD_NOT_BE_NULL);
		}
		if(location == null) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_LOCATION_SHOULD_NOT_BE_NULL);
		}
		if(location.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_LOCATION_SHOULD_NOT_BE_EMPTY);
		}
		if(distance < RESTURANT_MINIMUM_DISTANCE) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_DISTANCE_SHOULD_NOT_BE_LESS_THAN_ZERO);
		}
		if(reviewScore < RESTURANT_MINIMUM_REVIEW_SCORE) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_REVIEW_SCORE_SHOULD_NOT_BE_LESS_THAN_ZERO);
		}
		if(reviewScore > RESTURANT_MAXIMUM_REVIEW_SCORE) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_REVIEW_SCORE_SHOULD_NOT_BE_MORE_THAN_FIVE);
		}
		if(menuURL == null) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_MENU_URL_SHOULD_NOT_BE_NULL);
		}
		if(menuURL.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_MENU_URL_SHOULD_NOT_BE_EMPTY);
		}
		if(imageURL == null) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_IMAGE_URL_SHOULD_NOT_BE_NULL);
		}
		if(imageURL.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_IMAGE_URL_SHOULD_NOT_BE_EMPTY);
		}
		if(id == null) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_ID_SHOULD_NOT_BE_NULL);
		}
		if(id.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_ID_SHOULD_NOT_BE_EMPTY);
		}
		
		this.name = name;
		this.price = price;
		this.location = location;
		this.distance = distance;
		this.reviewScore = reviewScore;
		this.menuURL = menuURL;
		this.imageURL = imageURL;
		this.id = id;
	}

	/**
	 * gets the restaurant name
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the restaurant name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * gets the restaurant price
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the restaurant price
	 */
	
	public Price getPrice() {
		return this.price;
	}
	
	/**
	 * gets the restaurant location
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the restaurant location
	 */
	
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * gets the restaurant distance from user
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the restaurant distance from user
	 */
	
	public int getDistance() {
		return this.distance;
	}
	
	/**
	 * gets the restaurant review score
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the restaurant's review score
	 */
	
	public double getReviewScore() {
		return this.reviewScore;
	}
	
	/**
	 * gets the restaurant's menu URL
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the restaurant's menu URL
	 */
	
	public String getMenuURL() {
		return this.menuURL;
	}
	
	/**
	 * gets the restaurant's image URL
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the restaurant's image URL
	 */
	
	public String getImageURL() {
		return this.imageURL;
	}
	
	/**
	 * gets the restaurant's id
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the restaurant's id
	 */
	
	public String getId() {
		return this.id;
	}
}
