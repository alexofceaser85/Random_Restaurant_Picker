package src.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import src.viewmodel.ReviewsManagerViewModel;

public class ReviewsCodeBehind extends BaseCodeBehind {
	
	private ReviewsManagerViewModel viewmodel;
	
    @FXML
    private AnchorPane mainPane;

    @FXML
    private GridPane mainGrid;

    @FXML
    private Label restaurantHeaderLabel;

    @FXML
    private Pane contentPane;
    
    @FXML
    private Button backButton;
    
    @FXML
    void handleBack(ActionEvent event) {
		super.getController().show("Restaurant");
		this.contentPane.getChildren().remove(this.reviewsContainer);
    }

    private VBox reviewsContainer;
    private VBox reviewPane;
    
    public ReviewsCodeBehind(ReviewsManagerViewModel theReviewsManagerViewModel) {
    	this.viewmodel = theReviewsManagerViewModel;
    }
    
    public void initialize() {
    	
    	this.restaurantHeaderLabel.textProperty().bind(this.viewmodel.getRestaurantName());
    }

	@Override
	public void onActivation() {
    	this.reviewsContainer = new VBox();
    	
    	this.reviewsContainer.setSpacing(40);
    	
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
}
