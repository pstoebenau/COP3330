import java.util.*;
import java.security.SecureRandom;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int difficulty, operator, numCorrect = 0, numQuestions = 10, grade;
        char exit = 'n';
        double input, answer;

        while (exit != 'y') {
            System.out.println("Choose a difficulty level (1-4):");
            difficulty = scanner.nextInt();

            printOptions();
            operator = scanner.nextInt();

            printDivider();

            for (int i = 0; i < numQuestions; i++) {
                System.out.printf("Question %d:\n", i+1);

                answer = printQuestion(difficulty, operator);
                input = scanner.nextDouble();

                if (compareDouble(input, answer) == 0) {
                    printPosResponse();
                    numCorrect++;
                } else
                    printNegResponse();

                printDivider();
            }

            grade = 100 * numCorrect / numQuestions;
            System.out.printf("You got %d correct out of %d questions!\n", numCorrect, numQuestions);
            System.out.printf("Grade: %d%%\n", grade);

            if (grade >= 75)
                System.out.println("Congratulations, you are ready to go to the next level!");
            else
                System.out.println("Please ask your teacher for extra help.");

            System.out.println();
            System.out.print("Do you want to exit? (y/n): ");
            exit = scanner.next().charAt(0);
        }

        scanner.close();
    }

    private static int compareDouble(double a, double b) {
        final double THRESHOLD = 0.0001;

        if (a > b + THRESHOLD)
            return 1;
        else if (a < b - THRESHOLD)
            return -1;

        return 0;
    }

    private static void printOptions() {
        System.out.println("Choose what to practice");
        System.out.println("Option 1: Addition");
        System.out.println("Option 2: Multiplication");
        System.out.println("Option 3: Subtraction");
        System.out.println("Option 4: Division");
        System.out.println("Option 5: Random");
        System.out.print("Choice: ");
    }

    private static double printQuestion(int difficulty, int operator) {
        Random randGen = new SecureRandom();
        int a, b;

        a = randGen.nextInt((int)Math.pow(10, difficulty) - 1) + 1;
        b = randGen.nextInt((int)Math.pow(10, difficulty) - 1) + 1;

        if (operator == 5)
            operator = randGen.nextInt(4) + 1;

        switch (operator) {
            case 1:
                System.out.printf("How much is %d plus %d?\n", a, b);
                return (double)a + b;
            case 2:
                System.out.printf("How much is %d times %d?\n", a, b);
                return (double)a * b;
            case 3:
                System.out.printf("How much is %d minus %d?\n", a, b);
                return (double)a - b;
            case 4:
                System.out.printf("How much is %d over %d?\n", a, b);
                return (double)a / b;
            default:
                System.out.println("ERROR: Invalid operator chosen");
        }

        return Integer.MIN_VALUE;
    }

    private static void printPosResponse() {
        Random randGen = new SecureRandom();

        switch (randGen.nextInt(4)) {
            case 0:
                System.out.printf("Very good!\n");
                break;
            case 1:
                System.out.printf("Excellent!\n");
                break;
            case 2:
                System.out.printf("Nice work!\n");
                break;
            case 3:
                System.out.printf("Keep up the good work!\n");
                break;
            default:
                System.out.printf("ERROR: random number generator!\n");
        }
    }

    private static void printNegResponse() {
        Random randGen = new SecureRandom();

        switch (randGen.nextInt(4)) {
            case 0:
                System.out.printf("No. Please try again.\n");
                break;
            case 1:
                System.out.printf("Wrong. Try once more.\n");
                break;
            case 2:
                System.out.printf("Don’t give up!\n");
                break;
            case 3:
                System.out.printf("No. Keep trying.\n");
                break;
            default:
                System.out.printf("ERROR: random number generator!\n");
        }
    }

    private static void printDivider() {
        System.out.println("------------------------------");
        System.out.println("");
    }

}
