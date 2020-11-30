/**
 * 
 */
package src.test.urlbuilder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.data.URLBuilder;

/**
 *
 * @author Furichous Jones IV
 * @version Fall 2020
 */
class TestConstructor {

	@Test
	void TestValidHostAndProtocol() {
			URLBuilder testURLBuilder = new URLBuilder("maps.google.com","https");
			assertEquals("maps.google.com",testURLBuilder.getURL().getHost());
			assertEquals("https",testURLBuilder.getURL().getProtocol());
	}
	@Test
	void TestNullHost() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new URLBuilder(null,"https");
		});
	}
	@Test
	void TestBlankHost() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new URLBuilder("","https");
		});
	}
	@Test
	void TestNullProtocol() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new URLBuilder("maps.google.com",null);
		});
	}
	@Test
	void TestBlankProtocol() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new URLBuilder("maps.google.com","");
		});
	}
}
