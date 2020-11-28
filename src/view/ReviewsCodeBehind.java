package src.view;

import com.sun.prism.paint.Color;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import src.model.Review;
import src.viewmodel.ReviewsManagerViewModel;

public class ReviewsCodeBehind extends BaseCodeBehind {
	
	private ReviewsManagerViewModel viewmodel = new ReviewsManagerViewModel("Mcdonalds", "tnhfDv5Il8EaGSXZGiuQGg");
	
    @FXML
    private AnchorPane mainPane;

    @FXML
    private GridPane mainGrid;

    @FXML
    private Label restaurantHeaderLabel;

    @FXML
    private Pane contentPane;

    private VBox reviewsContainer;
    private VBox reviewPane;
    
    public ReviewsCodeBehind() {
    	
    }
    
    public void initialize() {
    	this.viewmodel.addReview("John Smith", "you betcha yeah", 4.0);
    	this.viewmodel.addReview("Jimmy Smith", "you betcha bi", 2.0);
    	
    	this.restaurantHeaderLabel.textProperty().bind(this.viewmodel.getRestaurantName());
    	this.reviewsContainer = new VBox();
    	
    	this.reviewsContainer.setSpacing(15);
    	
    	for (int counter = 0; counter < viewmodel.size(); counter++) {
    		this.reviewPane = new VBox();
    		VBox.setMargin(this.reviewPane, new Insets(0,50,0,50));
    		
    		this.reviewPane.setSpacing(15);
    		
    		this.reviewPane.setStyle("-fx-background-color: #dddddd;"
    				+ "-fx-border-width: 2;"
    				+ "-fx-background-radius: 15;"
    				+ "-fx-alignment: center;");
    		
    		Label reviewerName = new Label("Reviewed By: " + viewmodel.getReviewer(counter));
    		Label reviewContent = new Label(viewmodel.getReviewContent(counter));   
    		Label reviewScore = new Label("Score: " + viewmodel.getReviewScore(counter));
    		
    		this.reviewPane.getChildren().add(reviewerName);
    		this.reviewPane.getChildren().add(reviewContent);
    		this.reviewPane.getChildren().add(reviewScore);
    		
    		this.reviewsContainer.getChildren().add(this.reviewPane);
    	}
    	
    	this.contentPane.getChildren().add(this.reviewsContainer);
    }

	@Override
	public void onActivation() {
		// TODO Add all the reviews from mainManager to reviews container
		
	}
}
