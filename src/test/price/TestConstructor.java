package src.test.price;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.model.Price;

class TestConstructor {

	@Test
	void testValueEqualsStringOutput() {
		Price actual = Price.$$;
		
		String expected = "$$";
		assertEquals(expected, actual.toString());
	}

}
