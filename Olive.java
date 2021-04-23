import java.awt.Color;


//Olive class extends Cheese
//Olive is a shallow class and only contains static final values and passes them to the Vegetable super constructor
public class Olive extends Vegetable{
	public static final int calories = 75;
	public static final Money cost = new Money(0,75);
    public static final String description = "Olives";
	
	//Constructor calls Cheese constructor with super
	public Olive(Color color) {
		super(description, cost, calories, color);
	}

}
