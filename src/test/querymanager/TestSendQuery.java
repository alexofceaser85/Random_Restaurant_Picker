package src.test.querymanager;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import src.data.QueryManager;
import src.data.RestaurantsQuery;
import src.data.ReviewsQuery;

class TestSendQuery {

	@Test
	void testValidQuery() {
		RestaurantsQuery testQuery = new RestaurantsQuery("Carrollton,GA", 10, "chinese", 4, null, false, false, false, false, false);
		String jsonReturn = QueryManager.sendQuery(testQuery);
		assertNotNull(jsonReturn);
	}
	
	@Test
	void testInvalidQuery() {
		ReviewsQuery testQuery = new ReviewsQuery("abc");
		String jsonReturn = QueryManager.sendQuery(testQuery);
		assertNull(jsonReturn);
	}
	
	@Test
	void testNullQuery() {
		assertThrows(IllegalArgumentException.class, () -> {
			QueryManager.sendQuery(null);
		});
	}
}
