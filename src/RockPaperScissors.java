import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        System.out.println("Welcome to Rock, Paper, Scissors!");

        Score score = new Score();

        while(true) {
            int playerWins = score.playerWins;
            int computerWins = score.computerWins;

            playGame(score);
            System.out.println("The score is Player: " + playerWins + " Computer: " + computerWins);


            System.out.println("Would you like to play again? (y/n)");
            Scanner scanner = new Scanner(System.in);
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    public static void playGame(Score score) {
        String[] rockPaperScissors = {"rock", "paper", "scissors"};
        String computerMove = rockPaperScissors[new Random().nextInt(rockPaperScissors.length)];
        String playerMove;

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Please enter your move. (rock, paper, or scissors)");
            playerMove = scanner.nextLine().toLowerCase();

            if (playerMove.equals("rock") || playerMove.equals("paper") || playerMove.equals("scissors")) {
                break;
            }
            System.out.println(playerMove + " is not a valid move.");
        }

        System.out.println("The computer chose " + computerMove);

        if (computerMove.equals(playerMove)) {
            System.out.println("It's a tie!");
        } else if (computerMove.equals("rock")) {
            if (playerMove.equals("scissors")) {
                System.out.println("The computer wins!");
                score.computerWins++;
            } else {
                System.out.println("You win!");
                score.playerWins++;
            }
        } else if (computerMove.equals("scissors")) {
            if (playerMove.equals("paper")) {
                System.out.println("The computer wins!");
                score.computerWins++;
            } else {
                System.out.println("You win!");
                score.playerWins++;
            }
        } else if (computerMove.equals("paper")) {
            if (playerMove.equals("rock")) {
                System.out.println("The computer wins!");
                score.computerWins++;
            } else {
                System.out.println("You win!");
                score.playerWins++;
            }
        }
    }
}

class Score {
    int playerWins;
    int computerWins;
}