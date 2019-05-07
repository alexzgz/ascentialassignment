package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import demo.CustomNumberEntity;
import demo.ListCustomNumberEntityChecker;


public class ListCustomNumberEntityCheckerTest {

	@Test
	public void testIsInList() {
		ListCustomNumberEntityChecker checker = new ListCustomNumberEntityChecker();
		List<CustomNumberEntity> list = checker.readFromFile("C:\\Users\\aortariz\\Desktop\\ej.json");
        assertTrue(checker.contains(45, list));
	}

	
	@Test
	public void testIsNotInList() {
		ListCustomNumberEntityChecker checker = new ListCustomNumberEntityChecker();
		List<CustomNumberEntity> list = checker.readFromFile("C:\\Users\\aortariz\\Desktop\\ej.json");
        assertFalse(checker.contains(495, list));
	}

	// We tried to run into the array list, and it lasted 37 seconds
	// We tried to use the map, and it lasted 0,001 seconds
	
	
}
