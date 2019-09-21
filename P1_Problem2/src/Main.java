import java.util.Scanner;
import java.text.*;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.##");
		int choice, weight, height;
		double bmi;
		
		printUI();
		
		choice = scanner.nextInt();
		
		printInstructions(choice);
		weight = scanner.nextInt();
		
		printInstructions1(choice);
		height = scanner.nextInt();
		
		// Spacer
		System.out.println();
				
		bmi = calcBMI(weight, height, choice);
		System.out.println("Your BMI: " + df.format(bmi));
		
		// Spacer
		System.out.println();
		
		printBMICategories();
		
		scanner.close();
	}
	
	static void printUI() {
		System.out.println("Choose a unit of measurement");
		System.out.println("1. Standard (Eww)");
		System.out.println("2. Metric (Nice)");
		System.out.print("Input: ");
	}
	
	static void printInstructions(int unit) {
		if (unit == 1)
			System.out.print("Enter your weight in pounds: ");
		else if (unit == 2)
			System.out.print("Enter your weight in kilogram: ");
	}
	
	static void printInstructions1(int unit) {
		if (unit == 1)
			System.out.print("Enter your height in inches: ");
		else if (unit == 2)
			System.out.print("Enter your height in meters: ");
	}
	
	static void printBMICategories() {
		System.out.println("BMI Categories");
		System.out.println("Underweight:\t<18.5");
		System.out.println("Normal weight:\t18.5–24.9");
		System.out.println("Overweight:\t25–29.9");
		System.out.println("Obesity:\t>30");
	}
	
	static double calcBMI(int weight, int height, int unit) {
		if (unit == 1)
			return (double)(703 * weight) / (height * height);
		if (unit == 2)
			return (double)weight / (height * height);
		
		return 0;
	}
	
}
