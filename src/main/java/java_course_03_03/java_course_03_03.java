package java_course_03_03;

public class java_course_03_03{
	public static void main(String[] args) {
		 // Create a myCar object
	    Car myCar = new Car();

	    // Call the honk() method (from the Vehicle class) on the myCar object
	    myCar.honk();

	    // Display the value of the brand attribute (from the Vehicle class) and the value of the modelName from the Car class
	    System.out.println(myCar.brand + " " + myCar.modelName);

	}
}
class Car extends Vehicle {
	  public String modelName = "Mustang";    // Car attribute
}