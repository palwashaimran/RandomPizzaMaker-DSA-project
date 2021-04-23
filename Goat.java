

//Goat class extends Cheese
//Goat is a shallow class and only contains static final values and passes them to the Cheese super constructor
public class Goat extends Cheese{
public static final int calories = 120;
public static final Money cost = new Money(1,0);
public static final String description = "Goat cheese ";
	
	//Constructor calls Cheese constructor with super
	public Goat() {
		super(description, cost, calories);
	}

}