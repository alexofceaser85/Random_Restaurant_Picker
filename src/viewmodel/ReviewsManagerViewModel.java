package src.viewmodel;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import src.error_messages.ErrorMessages;
import src.model.RestaurantManager;
import src.model.Review;
import src.model.ReviewManager;

/**
 * This is the view model class for the restaurant manager
 * 
 * @author Alex DeCesare
 * @version 26-Nov-2020
 */

public class ReviewsManagerViewModel {

	private ReviewManager theReviewManager;
	private StringProperty restaurantName;
	
	/**
	 * The constructor for the reviews manager view model
	 * 
	 * @precondition none
	 * 
	 * @postcondition 
	 * 		this.theReviewManager = new ReviewManager
	 * 		
	 * @param restaurantName the name of the restaurant which the reviews apply to
	 */
	
	public ReviewsManagerViewModel(String restaurantName) {
		this.theReviewManager = new ReviewManager(restaurantName);	
		this.restaurantName = new SimpleStringProperty();
		this.restaurantName.set(restaurantName);
	}
	
	/**
	 * Adds a review to the review manager
	 * 
	 * @precondition none
	 * @postcondition this.theReviewManager.size() == this.theReviewManager.size() + 1
	 */
	
	public void addReview(String reviewer, String reviewContent, double reviewScore) {
		
		Review theReviewToAdd = new Review(reviewer, reviewContent, reviewScore);
		this.theReviewManager.addReview(theReviewToAdd);	
	}
	
	/**
	 * Gets the size of the review manager
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the size of the review manager
	 */
	
	public int size() {
		return this.theReviewManager.size();
	}
	
	/**
	 * Gets the reviewer name for a given review
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the reviewer name for a given review
	 */
	
	public StringProperty getReviewer(int index) {
		Review theReview = this.theReviewManager.getReview(index);
		StringProperty theReviewer = new SimpleStringProperty(theReview.getReviewerName());
		return theReviewer;
	}
	
	/**
	 * Gets the review content for a given review
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the review content for a given review
	 */
	
	public StringProperty getReviewContent(int index) {
		Review theReview = this.theReviewManager.getReview(index);
		StringProperty theReviewContent = new SimpleStringProperty(theReview.getReviewContent());
		return theReviewContent;
	}
	
	/**
	 * Gets the review score for a given review
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the review score for a given review
	 */
	
	public DoubleProperty getReviewScore(int index) {
		Review theReview = this.theReviewManager.getReview(index);
		DoubleProperty theReviewScore = new SimpleDoubleProperty(theReview.getReviewScore());
		return theReviewScore;
	}
	
	/**
	 * Gets the restaurant name for the review manager
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the restaurant name for the review manager
	 */
	
	public StringProperty getRestaurantName() {
		return this.restaurantName;
	}
	
	/**
	 * Returns the string representation of the review manager
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the string representation of the review manager
	 */
	
	@Override
	public String toString() {
		return this.theReviewManager.toString();
	}
}
