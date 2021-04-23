
//Alfredo class that inherits from Base class
//Alfredo is a shallow class and only contains static final values and passes them to the Base super constructor
public class Alfredo extends Base{
public static final int calories = 150;
public static final Money cost = new Money(0,50);
public static final String description = "Alfredo ";
	
	//Constructor calls Base constructor with super
	public Alfredo() {
		super(description, cost, calories);
	}

}
