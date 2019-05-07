package demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;


// Constraint 1 -->  Your class MUST implement the provided NumberFinder interface
public class ListCustomNumberEntityChecker implements NumberFinder{

	private FastestComparator comparator;
	
	
	public ListCustomNumberEntityChecker() {
		comparator = new FastestComparator();
	}

	@Override
	// Constraint 3 --> The contains method of your implementation MUST use   
	// the provided FasterComparator.compare method to compare the int value with each  
	// CustomNumberEntity. How you do thisin the fastest possible time is the key. 
	// FastestComparator.compare cannot be modified and no other comparison method should be 
	// used (hashing, indexes etc)
	// ***********************
	// Constraint 4 --> Do not cast or convert provided parameter types, compare method 
	// from FastestComparator will handle this. e.g. do not cast from int to String, or 
	// CustomNumberEntity.number to int (even if is not used for comparison purpose)
	public boolean contains(int valueToFind, List<CustomNumberEntity> list) {
		
		for (CustomNumberEntity customNumberEntity : list) {

			if (comparator.compare(valueToFind, customNumberEntity) == 0)
				return true;
		}
		
		return false;
	}

	
	@Override
	// Constraint 2 --> The list of CustomNumberEntity values should be read from a Json file, a short example is given below
	public List<CustomNumberEntity> readFromFile(String filePath) {

        JsonArray arr = null;
		try {
			arr = new JsonParser().parse(new FileReader(filePath)).getAsJsonArray();
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
		
		List<CustomNumberEntity> listCustomNumberEntity = new ArrayList<CustomNumberEntity>(arr.size());
		
		for (int i = 0; i < arr.size(); i++) {
			JsonElement number = arr.get(i).getAsJsonObject().get("number");
			String numberString = "";
			if (!(number instanceof JsonNull))
				numberString = number.getAsString();
				if (ListCustomNumberEntityChecker.isNumeric(numberString))
				{	
					CustomNumberEntity customNumberEntity = listCustomNumberEntity.get(i);
					customNumberEntity.setNumber(numberString);
					listCustomNumberEntity.set(i, customNumberEntity);
				}	
				
			
        }
		return listCustomNumberEntity;
	}

	public static boolean isNumeric(String strNum) {
		return strNum.matches("-?\\d+(\\.\\d+)?");
	}
	
	public static void main(String[] args) {
		new ListCustomNumberEntityChecker().readFromFile("C:\\Users\\aortariz\\Desktop\\ej.json");
	}
}
