import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;

        String playAgain;
        do {
            totalScore += playGame(random, scanner);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.nextLine();
        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! Your total score is " + totalScore + ".");
    }

    private static int playGame(Random random, Scanner scanner) {
        int numberToGuess = random.nextInt(100) + 1; // Generates a number between 1 and 100
        int attempts = 10;
        int score = 10;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. You have 10 attempts to guess it.");

        while (attempts > 0) {
            System.out.print("You have " + attempts + " attempts left. Enter your guess: ");
            int guess = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (guess == numberToGuess) {
                System.out.println(
                        "Congratulations! You guessed the number " + numberToGuess + ". Your score is " + score + ".");
                return score;
            } else if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }

            attempts--;
            score--;
        }

        System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + ". Your score is 0.");
        return 0;
    }
}
