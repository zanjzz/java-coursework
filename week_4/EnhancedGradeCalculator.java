package week_4;
import java.util.Scanner;

public class EnhancedGradeCalculator {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		float studentScore = getStudentScore(scanner);
		
		// Displaying result
		if (studentScore != -1) {
			String grade = calculateGrade(studentScore);
			System.out.println("Your Grade is: " + grade);
		}
		scanner.close();
	}
	
    static float getStudentScore(Scanner scanner) {
		System.out.print("Enter your score: ");
		// String input validation
		if (!scanner.hasNextFloat()) {
			System.out.println("Invalid input! Please enter a number.");
			return -1;
		}
		// Get Input
		float score = scanner.nextFloat();
		// Range input validation
		if (score < 0 || score > 100) {
			System.out.println("Invalid input! Score must be between 0 and 100."); 
			return -1;
		}	
		// Return score if valid
		return score;
	}
	
	static String calculateGrade(float score) {
		// Grade Scorings using if else
		if (score >= 90) return "A";
		else if (score >= 80) return "B";
		else if (score >= 70) return "C";
		else if (score >= 60) return "D";
		else return "F";
	}
}
