package github.benlewis9000.HangmanGame;

import java.util.*;

import static github.benlewis9000.HangmanGame.Utilities.printHelp;
import static github.benlewis9000.HangmanGame.Utilities.printProgress;
import static github.benlewis9000.HangmanGame.Utilities.toCharHashSet;

public class Game {

    /* Instance variables */

    private String answer;
    private HashSet<Character> charGuesses = new HashSet<>();
    private HashSet<Character> correctGuesses = new HashSet<>();
    private int totalGuesses = 0;
    private int falseGuesses = 0;
    private boolean isRunning = false;

    /* Getters and Setters */

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public HashSet<Character> getCharGuesses() {
        return charGuesses;
    }

    public void setCharGuesses(HashSet<Character> charGuesses) {
        this.charGuesses = charGuesses;
    }

    public HashSet<Character> getCorrectGuesses() {
        return correctGuesses;
    }

    public void setCorrectGuesses(HashSet<Character> correctGuesses) {
        this.correctGuesses = correctGuesses;
    }

    public int getTotalGuesses() {
        return totalGuesses;
    }

    public void setTotalGuesses(int totalGuesses) {
        this.totalGuesses = totalGuesses;
    }

    public int getFalseGuesses() {
        return falseGuesses;
    }

    public void setFalseGuesses(int falseGuesses) {
        this.falseGuesses = falseGuesses;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }


    /* Methods */

    public Game (String input){
        this.setAnswer(input);
        this.startGame(this.getAnswer());
    }

    public void startGame(String answer){

        System.out.println("A new game has begun..." +
                        "\nMake your first guess!");

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

            if (input.length() != 1){

                // DEBUG: System.out.println("if statement 1 (invalid entry)");

                switch (input){
                    case "exit":
                        this.gameLoss();
                        break;

                    case "help":
                        printHelp();
                        break;

                    default:
                        System.out.println("Guesses must be one character. Type \"help\" for more commands.");
                }

            }
            else {

                // DEBUG: System.out.println("if statement 2");

                char guess = input.charAt(0);

                if (this.getCharGuesses().contains(guess)) {
                    System.out.println("You have already guessed this letter!");
                }
                else if (!answerArrayList.contains(guess)){

                    // Increment total guesses
                    this.setTotalGuesses(this.getTotalGuesses() + 1);

                    // false guess
                    System.out.println("WRONG");

                    this.setFalseGuesses(this.getFalseGuesses() + 1);

                    if (this.getFalseGuesses() == 10){
                        this.gameLoss();
                        break;
                    }
                    else {
                        System.out.println("You have " + (10 - this.getFalseGuesses()) + " guess remaining.");
                    }

                }
                else {

                    // Increment total guesses
                    this.setTotalGuesses(this.getTotalGuesses() + 1);

                    // Add the guess to the charGuesses HashSet (ignored naturally if already in there)
                    this.getCharGuesses().add(guess);


                    for (int i = 0; i < answer.length(); i++) {

                        // check if users guess is correct at each index of answer char array
                        if (guess == answer.charAt(i)) {

                            correctArray[i] = guess;
                        }

                    }

                    System.out.println("CORRECT");

                    // Check current
                    if (this.getCharGuesses().equals(toCharHashSet(this.getAnswer().toCharArray()))) {
                        this.gameWin();
                        break;
                    }
                }

                // DEBUG: System.out.println(correctArray);

                printProgress(correctArray);

            }

        }

    }

    public void gameWin(){
        this.setRunning(false);
        System.out.println(
                "Congratulations, you won!" +
                "\nGuesses made: " + this.getTotalGuesses());
    }

    public void gameLoss(){
        this.setRunning(false);
        System.out.println(
                "You lost! Better luck next time." +
                "\nCorrect answer: " + this.getAnswer());
    }

}













