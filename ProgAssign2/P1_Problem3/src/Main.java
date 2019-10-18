import java.util.Scanner;

public class Main {
	static String topics[] = {"Climate Change", "Wellfare", "Healthcare", "Gun Control", "Immigration"};
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int responses[][] = new int[5][10];
		
		printUI();
		
		obtainResponses(responses, scanner);
		
		printTable(responses);
		printTableStatistics(responses);
		
		scanner.close();
	}
	
	static void printUI() {
		System.out.println("Polling Program");
		System.out.println("Rate each issue from 1 (least important) - 10 (most important)");
		System.out.println();
	}
	
	static void printTopic(int index) {
		System.out.print("Rate " + topics[index] + ": ");
	}
	
	static void obtainResponses(int responses[][], Scanner scanner) {
		for (int col = 0; col < 10; col++) {
			System.out.println("Person " + (col+1) + " respond");
			System.out.println();
			
			for(int row = 0; row < topics.length; row++) {
				printTopic(row);
				responses[row][col] = scanner.nextInt();
			}
			
			System.out.println();
		}
	}
	
	static void printTable(int responses[][]) {
		for (int row = 0; row < responses.length; row++) {
			System.out.print(topics[row]);
			
			for (int col = 0; col < responses[row].length; col++) {
				System.out.print("\t");
				System.out.print(responses[row][col]);
			}
			
			System.out.print("\t");
			System.out.println("Average: " + getAverage(responses[row]));
		}
		
		System.out.println();
	}
	
	static void printTableStatistics(int responses[][]) {
		System.out.println("Issue with highest point total: " + topics[getGreatest(responses)]);
		System.out.println("Issue with lowest point total: " + topics[getLeast(responses)]);
	}
	
	static int getGreatest(int responses[][]) {
		int indexOfGreatest = 0;
		int greatest = getAverage(responses[0]);
		
		for (int i = 1; i < responses.length; i++) {
			int average = getAverage(responses[i]);
			
			if(average > greatest) {
				greatest = average;
				indexOfGreatest = i;
			}
		}
		
		return indexOfGreatest;
	}
	
	static int getLeast(int responses[][]) {
		int indexOfLeast = 0;
		int least = getAverage(responses[0]);
		
		for (int i = 1; i < responses.length; i++) {
			int average = getAverage(responses[i]);
			
			if(average < least) {
				least = average;
				indexOfLeast = i;
			}
		}
		
		return indexOfLeast;
	}
	
	static int getAverage(int arr[]) {
		int avg = 0;
		
		for (int i = 0; i < arr.length; i++)
			avg += arr[i];
			
		return avg / arr.length;
	}
	
}
