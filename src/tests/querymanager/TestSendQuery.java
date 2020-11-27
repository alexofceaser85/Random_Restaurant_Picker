package src.tests.querymanager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.data.QueryManager;
import src.data.RestaurantsQuery;

class TestSendQuery {

	@Test
	void testValidQuery() {
		RestaurantsQuery testQuery = new RestaurantsQuery("Carrollton,GA", 10, "chinese", 4, null, false, false, false, false, false);
		String jsonReturn = QueryManager.sendQuery(testQuery);
		assertNotNull(jsonReturn);
	}
	@Test
	void testNullQuery() {
		String jsonReturn = QueryManager.sendQuery(null);
		assertNull(jsonReturn);
	}
}