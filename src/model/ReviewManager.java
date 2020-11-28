package src.model;

import java.util.ArrayList;
import java.util.List;

import src.data.JSONLoader;
import src.data.Query;
import src.data.QueryManager;
import src.data.ReviewsQuery;
import src.error_messages.ErrorMessages;

/**
 * This class holds the data for holding and managing the reviews
 * 
 * @author Alex DeCesare
 * @version 24-Nov-20
 */

public class ReviewManager {

	private String restaurantName;
	private ArrayList<Review> reviews;
	private String restuarantId;
	
	/**
	 * The constructor for the review manager
	 * 
	 * @precondition 
	 * 		restaurantName != null
	 * 		restaurantName.isEmpty == False
	 * 
	 * @postcondition 
	 * 		this.restaurantName = restaurantName
	 * 		this.reviews = ArrayList<Review>
	 * 		
	 * @param restaurantName the name of the restaurant which the reviews apply to
	 */
	
	public ReviewManager(String restaurantName, String restaurantId) {
		
		if(restaurantName == null) {
			throw new IllegalArgumentException(ErrorMessages.REVIEWS_RESTAURANT_NAME_SHOULD_NOT_BE_NULL);
		}
		if(restaurantName.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessages.REVIEWS_RESTAURANT_NAME_SHOULD_NOT_BE_EMPTY);
		}
		
		this.restuarantId = restaurantId;
		this.restaurantName = restaurantName;
		this.reviews = new ArrayList<Review>();
	}
	
	/**
	 * Gets the restaurant name
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the restaurant which the reviews apply to
	 */
	
	public String getRestaurantName() {
		return this.restaurantName;
	}
	
	/**
	 * Gets the restaurant reviews
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the restaurant reviews
	 */
	
	public ArrayList<Review> getReviews() {
		return this.reviews;
	}
	
	/**
	 * Adds a review to the reviews array
	 * 
	 * @precondition reviewToAdd != null
	 * @postcondition reviews.size() = reviews.size() + 1
	 */
	
	public void addReview(Review reviewToAdd) {
		
		if(reviewToAdd == null) {
			throw new IllegalArgumentException(ErrorMessages.REVIEW_TO_ADD_CANNOT_BE_NULL);
		}
		
		this.getReviews().add(reviewToAdd);
	}
	
	/**
	 * Removes a review from the reviews array
	 * 
	 * @precondition reviewToRemove != null
	 * @postcondition reviews.size() = reviews.size() - 1
	 */
	
	public void removeReview(Review reviewToRemove) {
		
		if(reviewToRemove == null) {
			throw new IllegalArgumentException(ErrorMessages.REVIEW_TO_REMOVE_CANNOT_BE_NULL);
		}
		
		this.getReviews().remove(reviewToRemove);
	}
	
	/**
	 * Returns the size of the reviews array
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the size of the reviews array
	 */
	
	public int size() {
		return this.getReviews().size();
	}
	
	/**
	 * Returns a given review
	 * 
	 * @precondition index >= 0
	 * @postcondition none
	 */
	
	public Review getReview(int index) {
		
		if (index < 0) {
			throw new IllegalArgumentException(ErrorMessages.REVIEW_INDEX_CANNOT_BE_LESS_THAN_ZERO);
		}
		
		return this.reviews.get(index);
	}
	
	/**
	 * Populates the reviews array with reviews from a given restaurant
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return none
	 */
	
	public void populateReviews() {
		
		Query theQuery = new ReviewsQuery(this.restuarantId);
		List<Review> reviews = JSONLoader.parseReviews(QueryManager.sendQuery(theQuery));
		
		for (Review review : reviews) {
			this.addReview(review);
		}
	}
	
	/**
	 * Returns the string representation of the reviews array
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return reviewsString the string representation of the reviews array
	 */
	
	@Override
	public String toString() {
		
		String reviewsString = "";
		
		for (Review review : this.getReviews()) {
			reviewsString += review.toString() + System.lineSeparator();
		}
		
		return reviewsString;
	}
}
