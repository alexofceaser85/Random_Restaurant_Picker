package src.viewmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import src.error_messages.ErrorMessages;
import src.model.Review;

/**
 * This is the view model class for the reviews class
 * 
 * @author Alex DeCesare
 * @version 25-Nov-2020
 */

public class ReviewsViewModel {

	private StringProperty reviewer;
	private StringProperty reviewContent;
	private DoubleProperty reviewScore;
	private Review review;
	
	/**
	 * This is the constructor for the Reviews View Model
	 * 
	 * @precondition review != null
	 * @postcondition 
	 * 		this.reviewer == review.getReviewerName()
	 * 		this.reviewContent == review.getReviewContent()
	 * 		this.reviewScore == review.getReviewScore()
	 * 
	 * @param review the review for the view model
	 */
	
	public ReviewsViewModel(String reviewer, String reviewContent, double reviewScore) {
		
		this.review = new Review(reviewer, reviewContent, reviewScore);
		
		this.reviewer = new SimpleStringProperty();
		this.reviewContent = new SimpleStringProperty();
		this.reviewScore = new SimpleDoubleProperty();
		
		this.reviewer.set(reviewer);
		this.reviewContent.set(reviewContent);
		this.reviewScore.set(reviewScore);
	}
	
	/**
	 * This is the getter for the reviewer string property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the reviewer string property
	 */
	
	public StringProperty getReviewer() {
		return this.reviewer;
	}
	
	/**
	 * This is the getter for the review content string property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the review content string property
	 */
	
	public StringProperty getContent() {
		return this.reviewContent;
	}
	
	/**
	 * This is the getter for the review score double property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the review score double property
	 */
	
	public DoubleProperty getReviewScore() {
		return this.reviewScore;
	}
	
	/**
	 * Returns the string representation of the view model
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	@Override
	public String toString() {
		return this.review.toString();
	}
	
}
