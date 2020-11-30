/**
 * 
 */
package src.test.urlbuilder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.data.URLBuilder;

/**
 *
 * @author Furichous Jones IV
 * @version Fall 2020
 */
class TestGetURL {

	private URLBuilder testURLBuilder;
	@BeforeEach
	void SetupURLBuilder() {
		this.testURLBuilder = new URLBuilder("maps.google.com","https");
	}
	
	@Test
	void TestEmptyFolders() {
		this.testURLBuilder.addParameter("parameter1","value1");
		assertEquals("https://maps.google.com?parameter1=value1",testURLBuilder.getURL().toString());
	}
	
	@Test
	void TestEmptyParameters() {
		this.testURLBuilder.addFolder("folder1");
		assertEquals("https://maps.google.com/folder1",testURLBuilder.getURL().toString());
	}
	
	@Test
	void TestEmptyParametersAndFolders() {
		assertEquals("https://maps.google.com",testURLBuilder.getURL().toString());
	}
	
	@Test
	void TestFullyPopulated() {
		this.testURLBuilder.addFolder("folder1");
		this.testURLBuilder.addFolder("folder2");
		this.testURLBuilder.addParameter("parameter1","value1");
		this.testURLBuilder.addParameter("parameter2","value2");
		assertEquals("https://maps.google.com/folder1/folder2?parameter1=value1&parameter2=value2",testURLBuilder.getURL().toString());
	}
	
	@Test
	void TestInvalidProtocol() {
		this.testURLBuilder = new URLBuilder("maps.google.com","test");
		assertNull(testURLBuilder.getURL());
	}
}
