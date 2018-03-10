package github.benlewis9000.HangmanGame;

import java.util.Scanner;

public class Main {

    public static void main (String[] args){


        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Game game = new Game(input);


    }

}

// Learn to use jsons/text files or whatever, store loads of words, and pick one randomly

/*
    To DO:
        - Display format; _ _ _ _ _ _ _ _  -->  B_ENJ_A_MIN etc.
        - list of words from mass file
        - winning game
        - losing game
        - check for word already used
        - clean up objects & methods



 */
