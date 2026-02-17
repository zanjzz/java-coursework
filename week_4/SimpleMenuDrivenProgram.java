package week_4;
import java.util.Scanner;

public class SimpleMenuDrivenProgram {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Outer while loop keeps the program run indefinitely
		while (true) {
			System.out.println();
			byte choice;
			// This do while loop is for choice validation
			do {
				displayMenu();
	    	    // String input validation
	    	    if (scanner.hasNextByte()) {
	    	    	choice = scanner.nextByte(); 
	    	        break; 
	    	    } else {
	    	        System.out.println("\nInvalid input! Please enter a number.\n");
	    	        scanner.next(); 
	    	    }
	    	} while (true);
			
			boolean shouldContinue = handleMenuChoice(scanner, choice);
			
			// This will stop the program
			if (!shouldContinue) {
				scanner.close();
				return;
			}
		} 
	}
	
	/* MAIN METHODS */
	static void displayMenu() {
	    System.out.println("Menu: \n1. Greet User\n2. Check Even/Odd\n3. Exit");
	    System.out.print("Enter your choice (1-3): ");
	}

	static boolean handleMenuChoice(Scanner scanner, byte choice) {
		switch (choice) {
			case 1: 
				greetUser(); break;
			case 2: 
				checkEvenOrOdd(scanner); break;
			case 3: 
				System.out.println("\nExiting Program... Goodbye!"); 
				return false;
			default:
				System.out.println("\nInvalid input! Please try again.");	
		}
		return true;
	}
	
	/* HELPER METHODS */
	static void greetUser() {
		System.out.println("\nHello! Welcome!");
	}
	
    static void checkEvenOrOdd(Scanner scanner) {
    	int input = 1;
		// Do while loop for input validation
    	do {
    	    System.out.print("\nEnter an integer: ");
    	    // String input validation
    	    if (scanner.hasNextInt()) {
    	    	input = scanner.nextInt(); 
    	        break; 
    	    } else {
    	        System.out.println("Invalid input! Please enter a number.");
    	        scanner.next(); 
    	    }
    	} while (true);
		// Print out the result
		System.out.println(input + " is an " + (input % 2 == 0 ? "Even" : "Odd") + " number.");
	}
}
