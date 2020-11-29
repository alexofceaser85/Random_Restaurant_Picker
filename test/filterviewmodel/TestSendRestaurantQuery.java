package test.filterviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.model.MainManager;
import src.model.Radius;
import src.viewmodel.FilterViewModel;

class TestSendRestaurantQuery {

	@Test
	void testInvalidQuery() {
		FilterViewModel viewModel = new FilterViewModel(new MainManager(null));
		viewModel.locationAddressProperty().setValue("Uuga Buuga");
		
		assertThrows(NullPointerException.class, () -> viewModel.sendRestaurantQuery());
	}
	
	@Test
	void testValidQuery() {
		FilterViewModel viewModel = new FilterViewModel(new MainManager(null));
		viewModel.locationAddressProperty().setValue("Carrollton, GA");
		viewModel.selectedRadiusProperty().setValue(Radius.TWENTY);
		viewModel.categoriesProperty().setValue("chinese");
		viewModel.reviewScoreProperty().setValue(2.0);
		viewModel.sendRestaurantQuery();
		
		assertNotEquals(0, viewModel.getMainManager().getRestaurantManager().size());
	}

}
