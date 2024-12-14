import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class RockPaperScissors {
    public static void main(String[] args) {
        out.println("Welcome to Rock, Paper, Scissors!");

        Score score = new Score();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            playGame(score);
            out.println("The score is Player: " + score.playerWins + " Computer: " + score.computerWins);


            out.println("Would you like to play again? (y/n)");
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
            out.println("Please enter your move. (rock, paper, or scissors)");
            playerMove = scanner.nextLine().toLowerCase();

            if (playerMove.equals("rock") || playerMove.equals("paper") || playerMove.equals("scissors")) {
                break;
            }
            out.println(playerMove + " is not a valid move.");
        }

        out.println("The computer chose " + computerMove);

        if (computerMove.equals(playerMove)) {
            out.println("It's a tie!");
        } else if (computerMove.equals("rock")) {
            if (playerMove.equals("scissors")) {
                out.println("The computer wins!");
                score.computerWins++;
            } else {
                out.println("You win!");
                score.playerWins++;
            }
        } else if (computerMove.equals("scissors")) {
            if (playerMove.equals("paper")) {
                out.println("The computer wins!");
                score.computerWins++;
            } else {
                out.println("You win!");
                score.playerWins++;
            }
        } else if (computerMove.equals("paper")) {
            if (playerMove.equals("rock")) {
                out.println("The computer wins!");
                score.computerWins++;
            } else {
                out.println("You win!");
                score.playerWins++;
            }
        }
    }
}

class Score {
    int playerWins;
    int computerWins;
}