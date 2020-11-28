package src.view;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import src.viewmodel.ReviewsManagerViewModel;

public class ReviewsCodeBehind {
	
	private ReviewsManagerViewModel viewmodel = new ReviewsManagerViewModel("Mcdonalds");
	
    @FXML
    private Label restaurantHeaderLabel;

    @FXML
    private Label restaurantHeaderLabel1;
    
    @FXML
    private AnchorPane mainPane;

    private VBox reviewsContainer;
    
    public ReviewsCodeBehind() {
    	
    }
    
    public void initialize() {
    	this.restaurantHeaderLabel.textProperty().bind(this.viewmodel.getRestaurantName());
    	this.reviewsContainer = new VBox();
    	Label testLabel = new Label();
    	testLabel.setText("howdy world");
    	
    	System.out.println(this.reviewsContainer.getChildren());
    	this.reviewsContainer.getChildren().add(testLabel);
        System.out.println(this.reviewsContainer.getChildren());
        this.mainPane.getChildren().add(this.reviewsContainer);
    }
}
