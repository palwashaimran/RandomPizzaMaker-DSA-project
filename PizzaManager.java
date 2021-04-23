
import java.util.Scanner;

//Pizza Manager class is the driver of the application.
//It contains a while loop and prompt system asking the user for input
//Users can add pizza, eat and sort them
public class PizzaManager {
	//The Pizza Manager holds an Array List of Pizzas
	//The list type is specified to hold only Pizza objects
	ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
	

	public void start() {
		char selection='q';
		Scanner foo = new Scanner(System.in);
		
		//Beginning of while loop of main program
		while(true) {
			displayAllPizzas();
			displayInstructions();
			char m;
			//Obtain the char of the first typed character input
			selection = foo.next().charAt(0);
			
			switch(selection) {
				case	'A':    
				case	'a':	
								System.out.println();
								System.out.println();
								System.out.println("1 Random pizza added"); 
								//Call addRandomPizza to add a new Pizza to the Pizza Array List
								addRandomPizza();
								System.out.println();
								System.out.println();

								break;
				case	'H':    
				case	'h':	
								System.out.println();
								System.out.println();
								System.out.println("100 pizzas added");
								//To add 100 random Pizzas to the Array List, I run a loop for 100 times and call
								//the same addRandomPizza method
								for(int i=0;i<5;i++){
									addRandomPizza();
								}
								System.out.println();
								System.out.println();

								break;					
				case	'E':    
				case	'e':	System.out.println();
								System.out.println();
								System.out.println("Eating a fraction of a pizza. How much? (a/b)");
								//Created a scanner to take the fraction input
								Scanner fracInput = new Scanner(System.in);
								//Grab the next input as a String to help with parsing the fraction input
								String frac = fracInput.next();
								
								//Split user string input by the / sign
								//Then obtain the Integer value of each value
								//for the numerator and denominator
								//Using regular expression for the splitting
								String[] fraction = String.valueOf(frac).split("\\/");
								int num = Integer.valueOf(fraction[0]);
								int denom = Integer.valueOf(fraction[1]);
								
								//System.out.println("Denom: " + denom);
								//System.out.println("Num: " + num);
								//Prompt user for additional input for the pizza index to eat
								System.out.println("At which pizza index?");
								//Take in input as an int
								int fractionIndex = fracInput.nextInt();
								//Call method eatSomePizza and pass in the user generated fraction and index
								eatSomePizza(new Fraction(num,denom),fractionIndex);
								
								System.out.println();
								System.out.println();

								break;			
				case	'F':    
				case	'f': 	System.out.println();
								System.out.println();
								System.out.println("BONUS ROUND - QuickSorting pizzas by (F)raction");
								//WOW, SO MUCH BONUS
								//Sorting Pizzas by Fractions because it's cool
								//I added in another PizzaComparable method for this to work
								quickSortByFraction();
								System.out.println();
								System.out.println();

							 	break;	
				case	'P':    
				case	'p': 	System.out.println();
								System.out.println();
								System.out.println("QuickSorting pizzas by (P)rice");
								//Sorting Pizzas by price using the quicksort algorithm, calls quickSortByPrice
								quickSortByPrice();
								System.out.println();
								System.out.println();

							  	break;	
				case	'S':    
				case	's': 	System.out.println();
								System.out.println();
								System.out.println("QuickSorting pizzas by (S)ize");
								//Sorting Pizzas by Size using the quicksort algorithm, calls quickSorBySize
								quickSortBySize();
								System.out.println();
								System.out.println();

							 	break;		
				case   'M' :
				case    'm' : 
					            System.out.println();
								System.out.println();
								System.out.println(" the list of ingredients that could end up on your pizza randomly includes \n Toppings : Alfredo , Cheese , Marinara , Olives , Mozarella , Pepper , Pepperoni , sausage , goat ");
				
				case	'C':    
				case	'c':  	System.out.println();
								System.out.println();
								System.out.println("QuickSorting pizzas by (C)alories");
								//Sorting Pizzas by Calories using the quicksort algorithm, calls quickSorByCalories
								quickSortByCalories();
								System.out.println();
								System.out.println();
							  	break;
				case	'B':
				case	'b':	System.out.println();
								System.out.println();
								System.out.println("(B)inary search over pizzas by calories(int).  QuickSorting first. What calorie count are you looking for?");
								//Method for finding a Pizza by the number of Calories
								//Uses the binary search algorithm and first sorts by Calories
								Scanner calInput = new Scanner(System.in);
								//Asks user for Calories to search and find
								int cals = calInput.nextInt();
								int index = binarySearchByCalories(cals);
								//If the index returned by the search function is -1, then a pizza with the specified calories wasn't found
								if(index == -1){
									System.out.println("Pizza with " + cals + " calories not found.");
								}
								else {
									//Prints that a pizza with the specified calories was found and lists the index location
									System.out.println("Pizza with " + cals + " calories found:");
									System.out.println(pizzas.get(index) + "\n\n");
								}
								System.out.println();
								System.out.println();

								break;
				case    'R':
				case 	'r':	System.out.println();
								System.out.println();
								System.out.println("(R)everse order of Pizzas with a Stack" );
								//This reverses the current order of Pizzas in the ArrayList
								//It doesn't sort first
								//Creating a stack for reversing the order
								PizzaStack stacky = new PizzaStack();
								int numElements = pizzas.size();
								//Loops through pizza Array List and pushes the results onto the stack
								for(int i=0; i != pizzas.size();){
									Pizza temp = pizzas.remove(i);
									//System.out.println(temp);
									stacky.push(temp);
								}
								
								//While the stack isn't empty, the stack
								//pushes the results back into thte pizza Array List
								//This results in reversing the order of the list
								while(!stacky.isEmpty()){
									Pizza temp2 = (Pizza) stacky.pop();
									//System.out.println(temp2);
									pizzas.add(temp2);
								}
								System.out.println(pizzas.size());
								System.out.println();
								System.out.println();

								break;
				case    'Q':
				case 	'q':	System.out.println();
								System.out.println();
								System.out.println("(Q)uitting!" );
								//Exit program
								System.exit(0);
								System.out.println();
								System.out.println();

								break;
				default:	System.out.println("Unrecognized input - try again");
			}
		}
	}

	
	public void eatSomePizza(Fraction amount, int index){
		if(amount == null || !(amount instanceof Fraction)){
			throw new PizzaException("Invalid fraction");
		}
		//The amount is a fraction of the whole pizza and not a fraction of the available pizza
		try{
			pizzas.get(index).eatSomePizza(amount);
		}
		//Catching the Pizza Exception that will be thrown when the pizza is entirely eaten
		catch(PizzaException p){
			//Print exception message
			System.out.println(p.toString());
			//Remove pizza from pizza list as there isn't anymore of it available
			pizzas.remove(index);
		}
	}
	
	//The addRandomPizza method calls the add function on the pizza array list
	//and adds a pizza.  a pizza created with no args will be randomly generated
	private void addRandomPizza() {
		pizzas.add(new Pizza());
	}

	//This displays all Pizzas in the console
	private void displayAllPizzas() {
		//Loops over pizza array list size and calls get on pizzas to return the current pizza
		for(int i=0; i<pizzas.size(); i++){
			System.out.println(pizzas.get(i));
		}
	}

	//Facade function
	private void quickSortByPrice() {  
		int first = 0;
		int last = pizzas.size()-1;
		sortPrice(pizzas, first, last);
	}
	//Function that does work but is private so user can't partially sort list
	private void sortPrice(ArrayList<Pizza> pizs, int first, int last) {
		//Check if passed pizza array list is actually a pizza array list
		if(pizs == null || !(pizs instanceof ArrayList<?>)){
			throw new PizzaException("Invalid fraction");
		}
		//Verify first and last indexes passed are valid
		//During a recursive call, last can be -1
		if(first < 0 || last < -1){
			System.out.println("Passed first must be >= 0 and last values must be >= -1");
			System.exit(-1);
		}
		
		//Base case that first must be less than last
		if(first < last){
			//Partitioning data into two halves while returning the pivotIndex
			int pivotIndex = partitionPrice(pizs, first, last);
			
			//Recursively calling sort method to sort each half on either side of pivotIndex
			sortPrice(pizs, first, pivotIndex - 1);
			sortPrice(pizs, pivotIndex + 1, last);
		}
	}
	private int partitionPrice(ArrayList<Pizza> pizs, int left, int right){
		if(pizs == null || !(pizs instanceof ArrayList<?>)){
			throw new PizzaException("Invalid fraction");
		}
		//System.out.println("Left: " + left);
		//System.out.println("Right: " + right);
		//Using median of three for pivot
		//http://en.wikipedia.org/wiki/Quicksort#Choice_of_pivot
		int pivotIndex = left + (right - left) / 2;
		//Assigning pivotValue for comparison later
		Pizza pivotValue = pizs.get(pivotIndex);
		//System.out.println(pivotValue);
		//Swap the pivot index temporarily to the furthest right index of the sub array
		pizs.swap(pivotIndex, right);
		//Store index is where the lowest values will be swapped starting on the left
		int storeIndex = left;
		for(int i=left; i < right; i++){
			//If value of i is less than pivot value, swap it to the storeIndex
			//System.out.println(pizs.get(i).compareTo(pivotValue));
			if(pizs.get(i).compareTo(pivotValue) < 0){
				pizs.swap(i, storeIndex);
				storeIndex++;
			}
		}
		//Swap and move pivot index to final index
		pizs.swap(storeIndex, right);
		//System.out.println(Arrays.toString(partData));
		return storeIndex;
	}
	
	//Sorting by size method using the quick sort algorithm
	//Facade function
	private void quickSortBySize() {
		int first = 0;
		int last = pizzas.size()-1;
		sortSize(pizzas, first, last);
	}
	//Function that does work but is private so user can't partially sort list
	private void sortSize(ArrayList<Pizza> pizs, int first, int last) {
		//Validate pizza array list input
		if(pizs == null || !(pizs instanceof ArrayList<?>)){
			throw new PizzaException("Invalid fraction");
		}
		//Verify first and last indexes passed are valid
		//During a recursive call, last can be -1
		if(first < 0 || last < -1){
			throw new PizzaException("Invalid index");
		}
		
		//Base case that first must be less than last
		if(first < last){
			//Partitioning data into two halves while returning the pivotIndex
			int pivotIndex = partitionSize(pizs, first, last);
			
			//Recursively calling sort method to sort each half on either side of pivotIndex
			sortSize(pizs, first, pivotIndex - 1);
			sortSize(pizs, pivotIndex + 1, last);
		}
	}
	private int partitionSize(ArrayList<Pizza> pizs, int left, int right){
		if(pizs == null || !(pizs instanceof ArrayList<?>)){
			throw new PizzaException("Invalid fraction");
		}
		//System.out.println("Left: " + left);
		//System.out.println("Right: " + right);
		//Using median of three for pivot
		//http://en.wikipedia.org/wiki/Quicksort#Choice_of_pivot
		int pivotIndex = left + (right - left) / 2;
		//Assigning pivotValue for comparison later
		Pizza pivotValue = pizs.get(pivotIndex);
		//System.out.println(pivotValue);
		//Swap the pivot index temporarily to the furthest right index of the sub array
		pizs.swap(pivotIndex, right);
		//Store index is where the lowest values will be swapped starting on the left
		int storeIndex = left;
		for(int i=left; i < right; i++){
			//If value of i is less than pivot value, swap it to the storeIndex
			//System.out.println(pizs.get(i).compareTo(pivotValue));
			if(pizs.get(i).compareToBySize(pivotValue) < 0){
				pizs.swap(i, storeIndex);
				storeIndex++;
			}
		}
		//Swap and move pivot index to final index
		pizs.swap(storeIndex, right);
		//System.out.println(Arrays.toString(partData));
		return storeIndex;
	}
	
	//Sorting by fraction method using the quick sort algorithm
	//Facade function
	private void quickSortByFraction() {
		int first = 0;
		int last = pizzas.size()-1;
		sortFraction(pizzas, first, last);
	}
	//Function that does work but is private so user can't partially sort list
	private void sortFraction(ArrayList<Pizza> pizs, int first, int last) {
		if(pizs == null || !(pizs instanceof ArrayList<?>)){
			throw new PizzaException("Invalid fraction");
		}
		//Verify first and last indexes passed are valid
		//During a recursive call, last can be -1
		if(first < 0 || last < -1){
			throw new PizzaException("Invalid index");
		}
		
		//Base case that first must be less than last
		if(first < last){
			//Partitioning data into two halves while returning the pivotIndex
			int pivotIndex = partitionFraction(pizs, first, last);
			
			//Recursively calling sort method to sort each half on either side of pivotIndex
			sortFraction(pizs, first, pivotIndex - 1);
			sortFraction(pizs, pivotIndex + 1, last);
		}
	}
	private int partitionFraction(ArrayList<Pizza> pizs, int left, int right){
		//Check for valid pizza array list input
		if(pizs == null || !(pizs instanceof ArrayList<?>)){
			throw new PizzaException("Invalid fraction");
		}
		//System.out.println("Left: " + left);
		//System.out.println("Right: " + right);
		//Using median of three for pivot
		//http://en.wikipedia.org/wiki/Quicksort#Choice_of_pivot
		int pivotIndex = left + (right - left) / 2;
		//Assigning pivotValue for comparison later
		Pizza pivotValue = pizs.get(pivotIndex);
		//System.out.println(pivotValue);
		//Swap the pivot index temporarily to the furthest right index of the sub array
		pizs.swap(pivotIndex, right);
		//Store index is where the lowest values will be swapped starting on the left
		int storeIndex = left;
		for(int i=left; i < right; i++){
			//If value of i is less than pivot value, swap it to the storeIndex
			//System.out.println(pizs.get(i).compareTo(pivotValue));
			if(pizs.get(i).compareToByFraction(pivotValue) < 0){
				pizs.swap(i, storeIndex);
				storeIndex++;
			}
		}
		//Swap and move pivot index to final index
		pizs.swap(storeIndex, right);
		//System.out.println(Arrays.toString(partData));
		return storeIndex;
	}
	
	/*
	 * function that sorts Pizzas in order of greatest calories first
	 * Notice you’re sorting primitives here
	 * a. To make your life easier, add the following methods to ArrayList
			i.	public int size()
			ii.	public void swap(int idx1, int idx2)
				1.Swaps the two elements in the arraylist using the specified indices.
			iii. public TBA get(int idx);
				1.Returns the item at the specified index.
	 */
	//Sorting by size method using the quick sort algorithm
	//Facade function
	public void quickSortByCalories() {
		int first = 0;
		int last = pizzas.size()-1;
		sortCalories(pizzas, first, last);
	}
	//Function that does work but is private so user can't partially sort list
	private void sortCalories(ArrayList<Pizza> pizs, int first, int last) {
		//Validate passed Pizzas array list input
		if(pizs == null || !(pizs instanceof ArrayList<?>)){
			throw new PizzaException("Invalid fraction");
		}
		//Verify first and last indexes passed are valid
		//During a recursive call, last can be -1
		if(first < 0 || last < -1){
			System.out.println("Passed first must be >= 0 and last values must be >= -1");
			System.exit(-1);
		}
		
		//Base case that first must be less than last
		if(first < last){
			//Partitioning data into two halves while returning the pivotIndex
			int pivotIndex = partitionCalorie(pizs, first, last);
			
			//Recursively calling sort method to sort each half on either side of pivotIndex
			sortCalories(pizs, first, pivotIndex - 1);
			sortCalories(pizs, pivotIndex + 1, last);
		}
	}
	private int partitionCalorie(ArrayList<Pizza> pizs, int left, int right){
		//Validate pizza arraylist input
		if(pizs == null || !(pizs instanceof ArrayList<?>)){
			throw new PizzaException("Invalid fraction");
		}
		//System.out.println("Left: " + left);
		//System.out.println("Right: " + right);
		//Using median of three for pivot
		//http://en.wikipedia.org/wiki/Quicksort#Choice_of_pivot
		int pivotIndex = left + (right - left) / 2;
		//Assigning pivotValue for comparison later
		Pizza pivotValue = pizs.get(pivotIndex);
		//System.out.println(pivotValue);
		//Swap the pivot index temporarily to the furthest right index of the sub array
		pizs.swap(pivotIndex, right);
		//Store index is where the lowest values will be swapped starting on the left
		int storeIndex = left;
		for(int i=left; i < right; i++){
			//If value of i is less than pivot value, swap it to the storeIndex
			//System.out.println(pizs.get(i).compareToByCalories(pivotValue));
			if(pizs.get(i).compareToByCalories(pivotValue) < 0){
				pizs.swap(i, storeIndex);
				storeIndex++;
			}
		}
		//Swap and move pivot index to final index
		pizs.swap(storeIndex, right);
		//System.out.println(Arrays.toString(partData));
		return storeIndex;
	}
	
	/*
	 * Build a function that searches over pizzas using their calorie count.
	 * Be sure to call quickSortByCalories() first so the data is sorted! 
	 */
	//Binary search by calories takes in calorie input as target
	//utilizes binary search algorithm
	//Sorts by calories first to ensure algorithm will work
	private int binarySearchByCalories(int cals) {
		quickSortByCalories();
		int low = 0;
		int high = pizzas.size()-1;
		int mid = 0;
		//While the current low boundary is lower than the current high boundary
		while(low <= high){
			//Obtain middle result by adding and dividing low and high boundaries
			mid = (low + high)/2;
			//See if the middle result matches the target and returns middle index if does
			if(pizzas.get(mid).getCalories() == cals){
				return mid;
			}
			//If the 
			else if(pizzas.get(mid).getCalories() < cals){
				//If the guessed middle value is lower than the target
				//Then low is assigned the middle index + 1
				low = mid+1;
			}
			else {
				//If the guessed middle value is greater than the target
				//Then high is assigned the middle index -1
				high = mid-1;
			}
		}
		//Returning -1 when no matches are found
		return -1;
	}
	
	/*
	 * No need to edit functions below this line, unless extending the menu or
	 * changing the instructions
	 */
	private static final String instructions = "\n \n \n -----------------------\n Welcome to Random Pizza \n-----------------------\n Press (M) to have a look at all the ingredients \n Press (A) to (A)dd a random pizza\n Press (H) to Add (H)undred random pizzas\n Press (E) to (E)at a fraction of a pizza\n Press (F) to QuickSort pizzas by (F)raction\n Press (P) to QuickSort pizzas by (P)rice\n Press (S) to QuickSort pizzas by (S)ize\n Press (C) to QuickSort pizzas by (C)alories\n Press (B) to (B)inary Search pizzas by calories\n Press (R) to (R)everse order of pizzas with a stack\n Press (Q) to (Q)uit\n";
	private void displayInstructions() {
		System.out.println(instructions);	
	}
	/*
	 * Notice the one-line main function.
	 */
	public static void main(String[] args) {
		new PizzaManager().start();
		
	}
}
