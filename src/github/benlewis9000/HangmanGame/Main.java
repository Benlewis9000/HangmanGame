package github.benlewis9000.HangmanGame;

import java.util.HashSet;
import java.util.Scanner;

import static github.benlewis9000.HangmanGame.Utilities.askQuestion;

public class Main {

    public static void main (String[] args){

        System.out.println(" #~~~~~~~~~~~~~~~~~~~#" +
                "\n#    Hangman Game     #" +
                "\n#   by Benlewis9000   #" +
                "\n #~~~~~~~~~~~~~~~~~~~#\n");

        boolean continueGame = true;

        while (continueGame) {

            WordGenerator wG = new WordGenerator();
            String input = wG.generateWord();

            Game game = new Game(input);

            boolean playAgain = askQuestion("Would you like to play again?");

            if (!playAgain){
                continueGame = false;
            }
        }

    }

}

// Learn to use jsons/text files or whatever, store loads of words, and pick one randomly

/*
    To Do:
        / Display format; _ _ _ _ _ _ _ _  -->  B_ENJ_A_MIN etc.
        / list of words from mass file
        / winning game
        / losing game
        - check for guess already used - keep scores
        - clean up objects & methods
        -


 */
