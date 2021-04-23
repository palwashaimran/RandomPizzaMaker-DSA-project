
//Sausage class extends Meat
//Sausage is a shallow class and only contains static final values and passes them to the Meat super constructor
public class Sausage extends Meat {
	public static final int calories = 300;	public static final Money cost = new Money(1,05);
public static final String description = "Sausage";

	//Constructor calls Meat constructor with super
	public Sausage() {
		super(description, cost, calories);
	}

}