package src.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.text.Text;
import src.viewModel.RestaurantViewModel;

/**
 * Code Behind for the Restaurant View
 * @author Alexander Ayers
 *
 */

public class RestaurantViewCodeBehind {

    @FXML
    private Text restaurantNameText;

    @FXML
    private Text restaurantDistanceText;

    @FXML
    private Hyperlink restaurantAddressHyperlink;

    @FXML
    private Text restaurantPriceText;

    @FXML
    private Text restaurantReivewScoreText;

    @FXML
    private Button seeRestaurantReviewsButton;

    @FXML
    private Button seeRestauarantMenuButton;

    @FXML
    private Button grabNewRestaurantButton;

    @FXML
    private Button resetFiltersButton;
    
    private RestaurantViewModel viewModel;
    
    
	/**
	 * Zero-parameter constructor
	 * 
	 * @precondition none
	 * @postcondition none
	 */
    public RestaurantViewCodeBehind() {
    	this.viewModel = new RestaurantViewModel();
    }
    
    
	/**
	 * Initializes all properties to needed settings.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
    public void initialize() {
    	this.restaurantNameText.textProperty().bind(this.viewModel.nameProperty());
    	this.restaurantDistanceText.textProperty().bind(this.viewModel.distanceProperty());
    	this.restaurantAddressHyperlink.textProperty().bind(this.viewModel.locationProperty());
    	this.restaurantPriceText.textProperty().bind(this.viewModel.priceRangeProperty());
    	this.restaurantReivewScoreText.textProperty().bind(this.viewModel.reviewScoreProperty());
    }
    
    @FXML
    void grabNewRestaurant(ActionEvent event) {
    	this.viewModel.pickARestaurant();
    }

    @FXML
    void resetFilters(ActionEvent event) {
    	this.viewModel.resetFilters();
    }

    @FXML
    void seeRestaurantMenu(ActionEvent event) {
    	throw new UnsupportedOperationException();
    }

    @FXML
    void seeRestaurantReviews(ActionEvent event) {
    	throw new UnsupportedOperationException();
    }

}

