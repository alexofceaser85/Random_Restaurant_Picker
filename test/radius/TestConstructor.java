package test.radius;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.model.Radius;

class TestConstructor {

	@Test
	void testValidData() {
		Radius testRadius = Radius.FIVE;
		
		assertEquals("5 Miles", testRadius.toString());
		assertEquals("5 Miles", testRadius.getDisplay());
		assertEquals(8000, testRadius.getMeters());
	}

}
