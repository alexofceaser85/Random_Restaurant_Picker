package model;

/**
 * The class responsible for holding the restaurant information
 * 
 * @author Alex DeCesare
 * @version 18-November-2020
 **/

public class Restaurant {
	
	private String name;
	//private Price price;
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
	 * 		location != null
	 * 		location.isEmpty() == False
	 * 		distance >= 0
	 * 		reviewScore >= 0
	 * 		menuURL != null
	 * 		menuURL.isEmpty() == False
	 * 		imageURL != null
	 * 		imageURL.isEmpty() == False	
	 *		id != null
	 * 		id.isEmpty() == False	
	 * 
	 * @postcondition 
	 * 		this.name = name
	 * 		this.location = location
	 * 		this.distance = distance
	 * 		this.reviewScore = reviewScore
	 * 		this.menuURL = menuURL
	 * 		this.imageURL = imageURL
	 * 		this.id = id
	 * 
	 * @param name the restaurant's name
	 * @param location the restaurant's location
	 * @param distance the restaurant's distance from the user
	 * @param reviewScore the restaurant's review score
	 * @param menuURL the URL to the restaurant's menu
	 * @param imageURL the URL to the restaurant's image
	 * @param id the restaurant's id
	 **/
	
	public Restaurant(String name, String location, int distance, double reviewScore, String menuURL, String imageURL, String id) {
		
		this.name = name;
		this.location = location;
		this.distance = distance;
		this.reviewScore = reviewScore;
		this.menuURL = menuURL;
		this.imageURL = imageURL;
		this.id = id;
	}

}
