import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		int choice, input, value = 0;
		
		printUI();
		choice = getInput();
		
		// Extracts last 4 digits from input
		printInstructions();
		input = getInput();
		input %= 10000;
		
		if (choice == 1)
			value = Cryptor.encrypt(input);
		else if (choice == 2)
			value = Cryptor.decrypt(input);
		else
			System.out.println("Invalid function chosen");
			
		System.out.println("Value: " + value);
	}
	
	static void printUI() {
		System.out.println("Choose a function:");
		System.out.println("1. Encrypt");
		System.out.println("2. Decrypt");
		System.out.print("Input: ");
	}
	
	static void printInstructions() {
		System.out.print("Please Enter a 4 digit number: ");
	}
	
	static int getInput() {
		int tmp;
		Scanner scanner = new Scanner(System.in);
		
		tmp = scanner.nextInt();
		
		return tmp;
	}
}