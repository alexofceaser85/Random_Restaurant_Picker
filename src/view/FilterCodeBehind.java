package src.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.converter.NumberStringConverter;
import src.controller.Activatable;
import src.controller.SceneController;
import src.model.Radius;
import src.viewmodel.FilterViewModel;

/**
 * Code Behind for the Filter Section of the GUI.
 * 
 * @author Alexander Ayers
 * @version Fall 2020
 *
 */
public class FilterCodeBehind extends BaseCodeBehind implements Activatable {

	@FXML
	private Text enterLocationText;

	@FXML
	private TextField locationAddressTextBox;

	@FXML
	private Text enterRadiusText;

	@FXML
	private ComboBox<Radius> radiusComboBox;

	@FXML
	private Button beginButton;

	@FXML
	private Text categoriesText;

	@FXML
	private TextField categoriesTextBox;

	@FXML
	private TextField reviewScoreTextBox;

	@FXML
	private CheckBox price1Checkbox;

	@FXML
	private CheckBox price2Checkbox;

	@FXML
	private CheckBox price4Checkbox;

	@FXML
	private CheckBox price3Checkbox;

	@FXML
	private CheckBox currentOpenCheckbox;

	@FXML
	private CheckBox handicapAccessibleCheckbox;

	@FXML
	private CheckBox acceptsReservationsCheckbox;

	@FXML
	private CheckBox newRestaurantsCheckbox;

	@FXML
	private CheckBox genderNeutralBathroomsCheckbox;

	@FXML
	private Button backButton;

	@FXML
	private Button submitButton;

	private FilterViewModel viewModel;

	/**
	 * Zero-parameter constructor
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param viewModel the view model for the filter page.
	 */
	public FilterCodeBehind(FilterViewModel viewModel) {
		this.viewModel = viewModel;
	}

	/**
	 * Initializes all properties to needed settings.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void initialize() {
		this.bindToViewModel();
		this.beginButton.disableProperty().bind(this.locationAddressTextBox.textProperty().isEmpty());
	}

	@FXML
	void handleBegin(ActionEvent event) {
		super.getController().show("Filter");
	}

	@FXML
	void handleBack(ActionEvent event) {
		super.getController().show("Location");
	}

	@FXML
	void handleSubmit(ActionEvent event) {
		SceneController controller = super.getController();
		controller.show("RestaurantLoad");
		this.viewModel.sendRestaurantQuery();
		controller.activate("Restaurant");
	}

	private void bindToViewModel() {
		if (this.locationAddressTextBox != null) {
			this.locationAddressTextBox.textProperty().bindBidirectional(this.viewModel.locationAddressProperty());
			this.radiusComboBox.itemsProperty().bind(this.viewModel.radiusProperty());
			this.radiusComboBox.valueProperty().bindBidirectional(this.viewModel.selectedRadiusProperty());
		}
		if (this.categoriesTextBox != null) {
			this.categoriesTextBox.textProperty().bindBidirectional(this.viewModel.categoriesProperty());
			this.acceptsReservationsCheckbox.selectedProperty()
					.bindBidirectional(this.viewModel.acceptsReservationsProperty());
			this.price1Checkbox.selectedProperty().bindBidirectional(this.viewModel.price1Property());
			this.price2Checkbox.selectedProperty().bindBidirectional(this.viewModel.price2Property());
			this.price3Checkbox.selectedProperty().bindBidirectional(this.viewModel.price3Property());
			this.price4Checkbox.selectedProperty().bindBidirectional(this.viewModel.price4Property());
			this.currentOpenCheckbox.selectedProperty().bindBidirectional(this.viewModel.currentlyOpenProperty());
			this.handicapAccessibleCheckbox.selectedProperty()
					.bindBidirectional(this.viewModel.handicapAccessibleProperty());
			this.genderNeutralBathroomsCheckbox.selectedProperty()
					.bindBidirectional(this.viewModel.genderNeutralBathroomProperty());
			this.newRestaurantsCheckbox.selectedProperty().bindBidirectional(this.viewModel.newRestaurantsProperty());
			this.reviewScoreTextBox.textProperty().bindBidirectional(this.viewModel.reviewScoreProperty(),
					new NumberStringConverter());
		}
	}

	@Override
	public void onActivation() {
		this.viewModel.resetProperties();
	}
}
