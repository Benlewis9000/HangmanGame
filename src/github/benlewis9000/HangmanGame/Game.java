package github.benlewis9000.HangmanGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static github.benlewis9000.HangmanGame.Utilities.printProgress;

public class Game {

    /* Instance variables */

    private String word;
    private int correct;
    private int falseGuesses;
    private boolean isRunning = false;

    /* Getters and Setters */

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int guesses) {
        this.correct = correct;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public int getFalseGuesses() {
        return falseGuesses;
    }

    public void setFalseGuesses(int falseGuesses) {
        this.falseGuesses = falseGuesses;
    }

    /* Methods */

    public Game (String answer){
        this.startGame(answer);
    }

    public void startGame(String answer){

        char[] answerArray = answer.toCharArray();

        // used for a .contains() if statement;
        ArrayList<Character> answerArrayList = new ArrayList<>();
        for (char c : answerArray){
            answerArrayList.add(c);
        }


        // Stores correct guesses, where void is '_'
        char[] correctArray = new char[answer.length()];
        for (int i = 0; i < correctArray.length; i++){
            correctArray[i] = '_';
        }

        // Begin Game

        this.setRunning(true);

        Scanner sc = new Scanner(System.in);

        while (this.isRunning){

            String input = sc.nextLine();

            if (input.length() != 1 /*|| sc.nextLine().equalsIgnoreCase("")*/){

                // DEBUG: System.out.println("if statement 1 (invalid entry)");

                switch (input){
                    case "exit":
                        // exit
                        break;

                    case "help":
                        // help
                        break;

                    default:
                        System.out.println("Guesses must be one character. Type \"help\" for more commands.");
                }

            }
            else {

                // DEBUG: System.out.println("if statement 2");

                char guess = input.charAt(0);

                if (!answerArrayList.contains(guess)){

                    // false guess
                    System.out.println("WRONG");

                    this.setFalseGuesses(this.getFalseGuesses() + 1);
                }
                else {

                    // correct guess TODO: Will need to check for double entries of corrects
                    for (int i = 0; i < answer.length(); i++){

                        // check if users guess is correct at each index of answer char array
                        if(guess == answer.charAt(i)){

                            correctArray[i] = guess;

                        }

                    }

                    System.out.println("CORRECT");
                }

                // DEBUG: System.out.println(correctArray);

                printProgress(correctArray);

            }

        }

    }

}













