package test;

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
		checker.contains(45, list);
        assertTrue(checker.contains(45, list));
	}

}
