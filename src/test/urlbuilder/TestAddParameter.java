/**
 * 
 */
package src.test.urlbuilder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.data.URLBuilder;

/**
 *
 * @author Furichous Jones IV
 * @version Fall 2020
 */
class TestAddParameter {
	
	private URLBuilder testURLBuilder;
	@BeforeEach
	void SetupURLBuilder() {
		this.testURLBuilder = new URLBuilder("maps.google.com","https");
	}
	
	@Test
	void TestValidParameter() {
		this.testURLBuilder.addParameter("parameter1","value1");
			assertEquals("parameter1=value1",testURLBuilder.getURL().getQuery());
	}
	
	@Test
	void TestValidParameters() {
		this.testURLBuilder.addParameter("parameter1","value1");
		this.testURLBuilder.addParameter("parameter2","value2");
			assertEquals("parameter1=value1&parameter2=value2",testURLBuilder.getURL().getQuery());
	}
	
	@Test
	void TestNullParameter() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.testURLBuilder.addParameter(null,"value");
		});
	}
	@Test
	void TestBlankParameter() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.testURLBuilder.addParameter("","value");
		});
	}
	@Test
	void TestNullValue() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.testURLBuilder.addParameter("parameter",null);
		});
	}
	@Test
	void TestBlankValue() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.testURLBuilder.addParameter("parameter","");
		});
	}
}
