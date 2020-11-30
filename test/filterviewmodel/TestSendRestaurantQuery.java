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
	void testValidQueryPricesTrue() {
		FilterViewModel viewModel = new FilterViewModel(new MainManager(null));
		viewModel.locationAddressProperty().setValue("Carrollton, GA");
		viewModel.selectedRadiusProperty().setValue(Radius.TWENTY);
		viewModel.categoriesProperty().setValue("chinese");
		viewModel.reviewScoreProperty().setValue(2.0);
		viewModel.price1Property().setValue(true);
		viewModel.price2Property().setValue(true);
		viewModel.price3Property().setValue(true);
		viewModel.price4Property().setValue(true);
		viewModel.sendRestaurantQuery();
		
		assertNotEquals(0, viewModel.getMainManager().getRestaurantManager().size());
	}
	
	@Test
	void testValidQueryPricesFalse() {
		FilterViewModel viewModel = new FilterViewModel(new MainManager(null));
		viewModel.locationAddressProperty().setValue("Carrollton, GA");
		viewModel.selectedRadiusProperty().setValue(Radius.TWENTY);
		viewModel.categoriesProperty().setValue("chinese");
		viewModel.reviewScoreProperty().setValue(2.0);
		viewModel.price1Property().setValue(false);
		viewModel.price2Property().setValue(false);
		viewModel.price3Property().setValue(false);
		viewModel.price4Property().setValue(false);
		viewModel.sendRestaurantQuery();
		
		assertNotEquals(0, viewModel.getMainManager().getRestaurantManager().size());
	}

}
