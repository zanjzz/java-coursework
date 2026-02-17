package week_4;
import java.util.Scanner;

public class WordCounter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Storing methods in a variable
		String sentenceInput = getSentenceInput(scanner);
		int count = countWords(sentenceInput);
		
		// Displaying the result cleanly
		System.out.printf("The sentence has %d " + (count == 1 ? "word." : "words."), count);
		
		scanner.close();
	}
	
	static String getSentenceInput(Scanner scanner) {
		System.out.print("Enter a sentence: ");
		String sentenceInput = scanner.nextLine();
		return sentenceInput;
	}
	
	static int countWords(String sentenceInput) {
		/* This will cleanly seperate words by using the regex 
		   "\\s+" along with trim() instead of just " ".  */
		String[] words = sentenceInput.trim().split("\\s+");
		// This handles an empty input
		if (sentenceInput.trim().isEmpty()) return 0;
		return words.length;
	}
}
