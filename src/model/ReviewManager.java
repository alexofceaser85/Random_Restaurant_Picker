package src.model;

import java.util.ArrayList;
import java.util.List;

import src.error_messages.ErrorMessages;

/**
 * This class holds the data for holding and managing the reviews
 * 
 * @author Alex DeCesare
 * @version 24-Nov-20
 */

public class ReviewManager {

	private List<Review> reviews;
	
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
	 */
	
	public ReviewManager() {
		
		this.reviews = new ArrayList<Review>();
	}
	
	/**
	 * Gets the restaurant reviews
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the restaurant reviews
	 */
	
	public List<Review> getReviews() {
		return this.reviews;
	}
	
	/**
	 * Adds a review to the reviews array
	 * 
	 * @precondition reviewToAdd != null
	 * @postcondition reviews.size() = reviews.size() + 1
	 * 
	 * @param reviewToAdd the review to add to the reviews array
	 */
	
	public void addReview(Review reviewToAdd) {
		
		if (reviewToAdd == null) {
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
		
		if (reviewToRemove == null) {
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
	 * @param index index of review
	 * @precondition index >= 0
	 * @postcondition none
	 * @return review at index
	 */
	public Review getReview(int index) {
		
		if (index < 0) {
			throw new IllegalArgumentException(ErrorMessages.REVIEW_INDEX_CANNOT_BE_LESS_THAN_ZERO);
		}
		
		return this.reviews.get(index);
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
	
	/**
	 * Sets the reviews for the review manager to hold
	 * 
	 * @precondition reviews != null
	 * @postcondition this.reviews = reviews
	 * 
	 * @param reviews the reviews for the manager to hold
	 */

	public void setReviews(List<Review> reviews) {
		
		if (reviews == null) {
			throw new IllegalArgumentException(ErrorMessages.REVIEWS_TO_SET_CANNOT_BE_NULL);
		}
		
		this.reviews = reviews;
	}
}
