package viewModel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.MainManager;

public class RestaurantViewModel {
	private StringProperty nameProperty;
	private StringProperty imageProperty;
	private StringProperty locationProperty;
	private StringProperty priceRangeProperty;
	private IntegerProperty distanceProperty;
	private IntegerProperty reviewScoreProperty;
	private MainManager mainManager;
	public RestaurantViewModel() {
		this.nameProperty = new SimpleStringProperty();
		this.imageProperty = new SimpleStringProperty();
		this.locationProperty = new SimpleStringProperty();
		this.priceRangeProperty = new SimpleStringProperty();
		this.distanceProperty = new SimpleIntegerProperty();
		this.reviewScoreProperty = new SimpleIntegerProperty();
		this.mainManager = new MainManager();
	}
	
	public void setMainManager(MainManager mainManager) {
		this.mainManager = mainManager;
	}
	
	public void pickAgain() {
		throw new UnsupportedOperationException();
	}
	
	public void resetFilters() {
		throw new UnsupportedOperationException();
	}
	
	public void appendReviewsQuery() {
		throw new UnsupportedOperationException();
	}
	
	public StringProperty nameProperty() {
		return this.nameProperty;
	}
	
	public StringProperty imageProperty() {
		return this.imageProperty;
	}
	
	public StringProperty locationProperty() {
		return this.locationProperty;
	}
	
	public StringProperty priceRangeProperty() {
		return this.priceRangeProperty;
	}
	
	public IntegerProperty distanceProperty() {
		return this.distanceProperty;
	}
	
	public IntegerProperty reviewScoreProperty() {
		return this.reviewScoreProperty;
	}
	
}
