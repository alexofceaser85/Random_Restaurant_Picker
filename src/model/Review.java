package src.model;

import src.error_messages.ErrorMessages;

/**
 * This class holds the data for the restaurant reviews
 * 
 * @author Alex DeCesare
 * @version 22-Nov-20
 */

public class Review {
	
	private static final int MINIMUM_REVIEW_SCORE = 1;
	private static final int MAXIMUM_REVIEW_SCORE = 5;

	private String reviewerName;
	private String reviewContent;
	private double reviewScore;
	
	/**
	 * The constructor for the review class
	 * 
	 * @precondition
	 * 		reviewerName != null
	 * 		reviewerName.isEmpty() == false
	 * 		reviewContent != null
	 *      reviewContent.isEmpty() == false
	 *      reviewScore >= 1
	 *      reviewScore <= 5
	 * 
	 * @postcondition
	 * 		this.reviewerName == reviewerName
	 * 		this.reviewContent == reviewContent
	 * 		this.reviewScore == reviewScore
	 * 
	 * @param reviewerName the name of the reviewer
	 * @param reviewContent the content of the review
	 * @param reviewScore the score of the review
	 */
	
	public Review(String reviewerName, String reviewContent, double reviewScore) {
		
		if(reviewerName == null) {
			throw new IllegalArgumentException(ErrorMessages.REVIEWER_NAME_CANNOT_BE_NULL);
		}
		if(reviewerName.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessages.REVIEWER_NAME_CANNOT_BE_EMPTY);
		}
		if(reviewContent == null) {
			throw new IllegalArgumentException(ErrorMessages.REVIEW_CONTENT_CANNOT_BE_NULL);
		}
		if(reviewContent.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessages.REVIEW_CONTENT_CANNOT_BE_EMPTY);
		}
		if(reviewScore < MINIMUM_REVIEW_SCORE) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_REVIEW_SCORE_SHOULD_NOT_BE_LESS_THAN_ONE);
		}
		if(reviewScore > MAXIMUM_REVIEW_SCORE) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_REVIEW_SCORE_SHOULD_NOT_BE_MORE_THAN_FIVE);
		}
		
		this.reviewerName = reviewerName;
		this.reviewContent = reviewContent;
		this.reviewScore = reviewScore;
	}
	
	/**
	 * Gets the name of the reviewer
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the reviewer
	 */
	
	public String getReviewerName() {
		return this.reviewerName;
	}
	
	/**
	 * Gets the content of the review
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the content of the review
	 */
	
	public String getReviewContent() {
		return this.reviewContent;
	}
	
	/**
	 * Gets the score of the review
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the score of the review
	 */
	
	public double getReviewScore() {
		return this.reviewScore;
	}
}
