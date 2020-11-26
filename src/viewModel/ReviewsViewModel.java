package src.viewModel;

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

	StringProperty reviewer;
	StringProperty reviewContent;
	DoubleProperty reviewScore;
	
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
	
	public ReviewsViewModel(Review review) {
		
		if (review == null) {
			throw new IllegalArgumentException(ErrorMessages.REVIEW_TO_GET_FOR_VIEW_MODEL_CANNOT_BE_NULL);
		}
		
		this.reviewer = new SimpleStringProperty();
		this.reviewContent = new SimpleStringProperty();
		this.reviewScore = new SimpleDoubleProperty();

		this.reviewer.set(review.getReviewerName());
		this.reviewContent.set(review.getReviewContent());
		this.reviewScore.set(review.getReviewScore());
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
	 * Returns the string representation of the reviews view model
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the string representation of the reviews view model
	 */
	
	@Override
	public String toString() {
		return "Reviewer: " + this.getReviewer().getValue() + " Content: " + this.getContent().getValue() + " Review Score: " + this.getReviewScore().getValue();
	}
}
