package java_course_03_02;

import java.util.ArrayList; // import the ArrayList class
import java.util.HashMap;


public class java_course_03_02{
	public static void main(String[] args) {
		ArrayList<String> cars = new ArrayList<String>();
	    cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("Mazda");
	    System.out.println(cars);
	    System.out.println(cars.contains("Mazda"));
	    
	    HashMap<String, String> capitalCities = new HashMap<String, String>();

	    // Add keys and values (Country, City)
	    capitalCities.put("England", "London");
	    capitalCities.put("Germany", "Berlin");
	    capitalCities.put("Norway", "Oslo");
	    capitalCities.put("USA", "Washington DC");
	    capitalCities.put("Taiwan", "Taipei");
	    System.out.println(capitalCities);
	}
}
