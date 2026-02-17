package week_4;
import java.util.Scanner;

public class EnhancedFactorialCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int input = getNonNegativeInteger(scanner);
		
		// Displaying result
		long result = calculateFactorial(input);
		System.out.println("The factorial of " + input + " is " + result + ".");

		scanner.close();
	}
	
	static int getNonNegativeInteger(Scanner scanner) {
		int input;
		// Getting input with validation
		while (true) {
			System.out.print("Enter a non-negative integer: ");
			if (scanner.hasNextInt()) {
				input = scanner.nextInt();
				// Range input validation
				if (input < 0) {
					System.out.println("Invalid input! Number must be greater than or equal to 0"); 
					continue;
				}	
				break;
			} else {
				System.out.println("Invalid input! Please enter a number.");
				scanner.next();
			}
		}
		return input;
	}
	
	static long calculateFactorial(int number) {
		long result = 1;
		for (int i = 1; i <= number; ++i) {
			result *= i;
		}
		return result;
	}
}
