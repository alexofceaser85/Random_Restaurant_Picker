package src.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import src.model.Radius;

public class FilterCodeBehind {

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
	    
	    public FilterCodeBehind() {
	    	
	    }

	    @FXML
	    void handleBegin(ActionEvent event) {

	    }
	    
	    @FXML
	    void handleBack(ActionEvent event) {

	    }

	    @FXML
	    void handleSubmit(ActionEvent event) {

	    }

	}

