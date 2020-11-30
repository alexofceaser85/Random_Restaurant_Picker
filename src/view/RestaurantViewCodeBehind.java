package src.view;


import java.awt.Desktop;
import java.net.URL;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import src.controller.Activatable;
import src.data.JSONLoader;
import src.viewmodel.RestaurantViewModel;

/**
 * Code Behind for the Restaurant View.
 * @author Alexander Ayers
 * @version Fall 2020
 *
 */

public class RestaurantViewCodeBehind extends BaseCodeBehind implements Activatable {

    @FXML
    private Text restaurantNameText;

    @FXML
    private Text restaurantDistanceText;

    @FXML
    private ImageView restaurantImage;
    
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
    
    private StringProperty menuURLProperty;
    private StringProperty imageURLProperty;
    
	/**
	 * Zero-parameter constructor
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param viewModel the viewModel for the restaurant class.
	 */
    public RestaurantViewCodeBehind(RestaurantViewModel viewModel) {
    	this.viewModel = viewModel;
    	this.menuURLProperty = new SimpleStringProperty();
    	this.imageURLProperty = new SimpleStringProperty();
    	this.menuURLProperty.bind(this.viewModel.menuURLProperty());
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
    	this.imageURLProperty.bind(this.viewModel.imageURLProperty());
    }
    
    @FXML
    void grabNewRestaurant(ActionEvent event) {
    	this.onActivation();
    }

    @FXML
    void resetFilters(ActionEvent event) {
    	this.viewModel.resetFilters();
    	super.getController().activate("Location");
    }

    @FXML
    void seeRestaurantMenu(ActionEvent event) {
    	try {
			Desktop.getDesktop().browse(new URL(this.menuURLProperty.get()).toURI());
		} catch (Exception e) {
			// swallow catch
		}
    }

    @FXML
    void seeRestaurantReviews(ActionEvent event) {
    	if (this.viewModel.sendReviewsQuery()) {
    		super.getController().activate("Reviews");
    	} else {
    		super.getController().show("ReviewsError");
    	}
    }


	@Override
	public void onActivation() {
		if (this.viewModel.pickARestaurant()) {
			String imageURL = this.imageURLProperty.get();
			Image image;
			try {
				image = new Image(imageURL);
			} catch (Exception e) {
				image = new Image(JSONLoader.DEFAULT_IMAGE);
			}
			this.restaurantImage.setImage(image);
			this.viewModel.removePickedRestaurant();
		} else {
			super.getController().show("RestaurantError");
		}
	}

}

