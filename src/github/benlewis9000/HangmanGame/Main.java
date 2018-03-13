package github.benlewis9000.HangmanGame;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main (String[] args){

        boolean continueGame = true;

        while (continueGame) {

            WordGenerator wG = new WordGenerator();
            String input = wG.generateWord();

            Game game = new Game(input);

            boolean playAgain = true;

            while (playAgain) {

                System.out.println("\nWould you like to play again? (\"y\"/\"n\")");
                Scanner sc = new Scanner(System.in);
                switch (sc.nextLine()){
                    case "y":
                        playAgain = false;
                        break;
                    case "n":
                        playAgain = false;
                        continueGame = false;
                        break;
                    default:
                        break;
                }
            }
        }

    }

}

// Learn to use jsons/text files or whatever, store loads of words, and pick one randomly

/*
    To Do:
        / Display format; _ _ _ _ _ _ _ _  -->  B_ENJ_A_MIN etc.
        - list of words from mass file
        - winning game
        - losing game
        - check for guess already used - keep scores
        - clean up objects & methods
        -


 */
