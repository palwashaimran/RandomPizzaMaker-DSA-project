
//Mozzarella class extends Cheese
//Mozzarella is a shallow class and only contains static final values and passes them to the Cheese super constructor
public class Mozzarella extends Cheese{
	public static final int calories = 100;
	public static final Money cost = new Money(0,75);
    public static final String description = "Mozzarella  ";
	
	//Constructor calls Cheese constructor with super
	public Mozzarella() {
		super(description, cost, calories);
	}

}
