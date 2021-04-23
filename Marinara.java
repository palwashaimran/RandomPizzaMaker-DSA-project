

//Marinara class that inherits from Base class
//Marinara is a shallow class and only contains static final values and passes them to the Base super constructor
public class Marinara extends Base{
	public static final int calories = 100;
	public static final Money cost = new Money(0,25);
	public static final String description = "Marinara ";
	
	//Constructor calls Base constructor with super
	public Marinara() {
		super(description, cost, calories);
	}

}
