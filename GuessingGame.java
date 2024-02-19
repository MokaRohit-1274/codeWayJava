//TASK 1
// NUMBER GAME
// 1.Generate a random number within a specified range, such as 1 to 100.
// 2. Prompt the user to enter their guess for the generated number.
// 3. Compare the user's guess with the generated number and provide feedback on whether
// the guess is correct, too high, or too low.
// 4. Repeat steps 2 and 3 until the user guesses the correct number.
// You can incorporate additional details as follows:
// 5. Limit the number of attempts the user has to guess the number.
// 6. Add the option for multiple rounds, allowing the user to play again.
// 7. Display the user's score, which can be based on the number of attempts taken or
// rounds won.
import java.util.*;

public class GuessingGame {
    public static void main(String args[]) {
        GuessGame();
    }

    public static void GuessGame() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        boolean play = true;
        int totalAttempts = 0;
        int totalRounds = 0;

        System.out.println("Welcome to the Guessing Game!");

        while (play) {
            int targetNumber = rand.nextInt(100) + 1;
            int attempts = playRandom(targetNumber);
            totalAttempts += attempts;
            totalRounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc.next();
            if (!playAgain.equals("YES")) {
                play = false;
            }
        }

        System.out.println("Game Over!");
        System.out.println("You played " + totalRounds + " rounds.");
        System.out.println("You took an average of " + (double) totalAttempts / totalRounds + " attempts per round.");
        sc.close();
    }

    public static int playRandom(int targetNumber) {
        Scanner sc = new Scanner(System.in);
        int tries = 0;

        while (true) {
            System.out.println("Guess the number between 1 and 100:");
            int guess = sc.nextInt();
            tries++;

            if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number " + targetNumber + " correctly in " + tries + " attempts.");
                break;
            }
        }
        return tries;
    }
}
