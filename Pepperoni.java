

//Pepperoni class extends Cheese
//Pepperoni is a shallow class and only contains static final values and passes them to the Meat super constructor
public class Pepperoni extends Meat{
	public static final int calories = 250;
public static final Money cost = new Money(0,95);
public static final String description = "pepperoni ";

	//Constructor calls Meat constructor with super
	public Pepperoni() {
		super(description, cost, calories);
	}

}
