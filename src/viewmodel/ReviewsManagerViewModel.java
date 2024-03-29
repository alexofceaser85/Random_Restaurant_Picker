package src.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import src.error_messages.ErrorMessages;
import src.model.MainManager;
import src.model.Review;
import src.model.ReviewManager;

/**
 * This is the view model class for the review manager.
 * 
 * @author Alex DeCesare
 * @version Fall 2020
 */

public class ReviewsManagerViewModel {

	private ReviewManager theReviewManager;
	private StringProperty restaurantName;
	
	/**
	 * The one-parameter constructor for the reviews manager view model
	 * 
	 * @precondition mainManager != null
	 * @postcondition 
	 * 		this.theReviewManager = new ReviewManager
	 * 
	 * @param mainManager the MainManager of the application
	 */
	
	public ReviewsManagerViewModel(MainManager mainManager) {
		if (mainManager == null) {
			throw new IllegalArgumentException(ErrorMessages.MAIN_MANAGER_SHOULD_NOT_BE_NULL);
		}
		this.theReviewManager = mainManager.getReviewManager();	
		this.restaurantName = new SimpleStringProperty();
	}
	
	/**
	 * Adds a review to the review manager.
	 * 
	 * @precondition none
	 * @postcondition this.theReviewManager.size() == this.theReviewManager.size() + 1
	 * 
	 * @param reviewer the person who has given the review.
	 * @param reviewContent the content of the body review.
	 * @param reviewScore the score of the review.
	 */
	public void addReview(String reviewer, String reviewContent, double reviewScore) {
		Review theReviewToAdd = new Review(reviewer, reviewContent, reviewScore);
		this.theReviewManager.add(theReviewToAdd);	
	}
	
	/**
	 * Gets the size of the review manager.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the size of the review manager.
	 */
	
	public int size() {
		return this.theReviewManager.size();
	}
	
	/**
	 * Gets the reviewer name for a given review.
	 * 
	 * @param index index of review
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the reviewer name for a given review.
	 */
	
	public String getReviewer(int index) {
		return this.theReviewManager.getReview(index).getReviewerName();
	}
	
	/**
	 * Gets the review content for a given review.
	 * 
	 * @param index index of review
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the review content for a given review.
	 */
	
	public String getReviewContent(int index) {
		return this.theReviewManager.getReview(index).getReviewContent();
	}
	
	/**
	 * Gets the review score for a given review.
	 * 
	 * @param index index of review
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the review score for a given review.
	 */
	
	public double getReviewScore(int index) {
		return this.theReviewManager.getReview(index).getReviewScore();
	}
	
	/**
	 * Gets the restaurant name for the review manager.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the restaurant name for the review manager.
	 */
	
	public StringProperty getRestaurantName() {
		return this.restaurantName;
	}
	
	/**
	 * Returns the string representation of the review manager.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the string representation of the review manager.
	 */
	
	@Override
	public String toString() {
		return this.theReviewManager.toString();
	}
}
