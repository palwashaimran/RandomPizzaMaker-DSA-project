//package pizzaMainClasses;

public interface PizzaComparable extends Comparable {  //Example of interface inheritance
	
	@Override
	public int compareTo(Object o); 	 		//a.k.a compareToByPrice
	//non-overrides
	public int compareToBySize(Object o); 		//a.k.a. compareToByAreaLeft
	public int compareToByFraction(Object o); 		//a.k.a. compareToByFraction
	public int compareToByCalories(Object o);	
	
}
