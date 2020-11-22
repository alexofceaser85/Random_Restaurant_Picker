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
    private Button seeRestauarntMenuButton;

    @FXML
    private Button grabNewRestaurantButton;

    @FXML
    private Button resetFiltersButton;
    
    private RestaurantViewModel viewModel;

    @FXML
    void grabNewRestaurant(ActionEvent event) {

    }

    @FXML
    void resetFilters(ActionEvent event) {

    }

    @FXML
    void seeRestaurantButton(ActionEvent event) {

    }

    @FXML
    void seeRestaurantReviews(ActionEvent event) {

    }

}

