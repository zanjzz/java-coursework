package week_4;
import java.util.Scanner;

public class EvenOrOddChecker {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int input = getIntegerInput(scanner);
		
		// Displaying result
		System.out.println(checkEvenOrOdd(input));
		
		scanner.close();
	}
	
	static int getIntegerInput(Scanner scanner) {
		int input;
		// Getting input with validation
		while (true) {
	        System.out.print("Enter an integer: ");
	        if (scanner.hasNextInt()) {
	            input = scanner.nextInt();
	            return input;
	        } else {
	            System.out.println("Invalid input! Please enter a number.");
	            scanner.next(); 
	        }
	    }
	}
	
    static String checkEvenOrOdd(int number) {
		return number + " is an " + (number % 2 == 0 ? "Even" : "Odd") + " number.";
	}
}
