package src.view;

import com.sun.prism.paint.Color;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
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
		super.getController().activate("Restaurant");
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
    	
    	for (int counter = 0; counter < this.viewmodel.size(); counter++) {
    		this.reviewPane = new VBox();
    		VBox.setMargin(this.reviewPane, new Insets(0,50,0,50));
    		
    		this.reviewPane.setSpacing(15);
    		this.reviewPane.setPadding(new Insets(10, 10, 10, 10));
    		this.reviewPane.setMaxWidth(400);

    		this.reviewPane.setStyle("-fx-background-color: #dddddd;"
    				+ "-fx-border-width: 2;"
    				+ "-fx-background-radius: 15;"
    				+ "-fx-alignment: center;");
    		
    		Label reviewerName = new Label("Reviewed By: " + this.viewmodel.getReviewer(counter));
    		Label reviewScore = new Label("Score: " + this.viewmodel.getReviewScore(counter));
    		Label reviewContent = new Label(this.viewmodel.getReviewContent(counter));   
    		
    		reviewContent.setWrapText(true);
    		
    		this.reviewPane.getChildren().add(reviewerName);
    		this.reviewPane.getChildren().add(reviewScore);
    		this.reviewPane.getChildren().add(reviewContent);
    		
    		this.reviewsContainer.setAlignment(Pos.CENTER);
    		this.reviewsContainer.getChildren().add(this.reviewPane);
    	}
    	
    	this.contentPane.getChildren().add(this.reviewsContainer);
	}
}
