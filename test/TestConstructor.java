package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Price;

class TestConstructor {

	@Test
	void testValueEqualsStringOutput() {
		Price actual = Price.$$;
		
		String expected = "$$";
		assertEquals(expected, actual.toString());
	}

}
