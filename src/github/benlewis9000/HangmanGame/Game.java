package github.benlewis9000.HangmanGame;

import java.io.IOException;
import java.util.*;

import static github.benlewis9000.HangmanGame.Utilities.printHelp;
import static github.benlewis9000.HangmanGame.Utilities.printProgress;
import static github.benlewis9000.HangmanGame.Utilities.toCharHashSet;

public class Game {

    /* Instance variables */

    private String answer;
    private HashSet<Character> charGuesses = new HashSet<>();
    private HashSet<Character> charCorrectGuesses = new HashSet<>();
    private int correctGuesses = 0;
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

    public HashSet<Character> getCharCorrectGuesses() {
        return charCorrectGuesses;
    }

    public void setCharCorrectGuesses(HashSet<Character> charCorrectGuesses) {
        this.charCorrectGuesses = charCorrectGuesses;
    }

    public int getCorrectGuesses() {
        return correctGuesses;
    }

    public void setCorrectGuesses(int correctGuesses) {
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
                        "\nMake your first guess! (Letter + ENTER)");

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

        printProgress(correctArray);

        // Begin Game

        this.setRunning(true);

        // Create graphic character

        HangmanCharacter hangmanCharacter = new HangmanCharacter(CharacterStage.STAGE_0);

        Scanner sc = new Scanner(System.in);

        while (this.isRunning){

            String input = sc.nextLine();
            Utilities.clrscr();

            if (input.length() != 1){

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

                char guess = input.charAt(0);

                if (this.getCharGuesses().contains(guess)) {
                    System.out.println("You have already guessed this letter!");
                }
                else if (!answerArrayList.contains(guess)){

                    // Increment total guesses
                    this.setTotalGuesses(this.getTotalGuesses() + 1);

                    // false guess
                    //Utilities.clearConsole();
                    hangmanCharacter.stageUp();
                    hangmanCharacter.draw();

                    System.out.println("WRONG");

                    this.setFalseGuesses(this.getFalseGuesses() + 1);

                    if (this.getFalseGuesses() == 9){
                        this.gameLoss();
                        break;
                    }
                    else {
                        System.out.println("You have " + (9 - this.getFalseGuesses()) + " guess remaining.");
                    }

                }
                else {

                    hangmanCharacter.draw();

                    // Increment total guesses
                    this.setTotalGuesses(this.getTotalGuesses() + 1);
                    this.setCorrectGuesses(this.getCorrectGuesses() + 1);

                    this.getCharCorrectGuesses().add(guess);
                    //HashSet<Character> cCGUpdated = this.getCharCorrectGuesses();
                    //cCGUpdated.add(guess);
                    //this.setCharCorrectGuesses(cCGUpdated);

                    for (int i = 0; i < answer.length(); i++) {

                        // check if users guess is correct at each index of answer char array
                        if (guess == answer.charAt(i)) {

                            correctArray[i] = guess;
                        }

                    }

                    System.out.println("CORRECT");

                    // Check current
                    if (this.getCharCorrectGuesses().equals(toCharHashSet(this.getAnswer().toCharArray()))) {
                        this.gameWin();
                        break;
                    }
                    //System.out.println("DEBUG: " + this.getCharGuesses() + "\nDEBUG: " + this.getCharCorrectGuesses() + "\nDEBUG: " + toCharHashSet((this.getAnswer().toCharArray())));
                }

                // Add the guess to the charGuesses HashSet (ignored naturally if already in there)
                this.getCharGuesses().add(guess);

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
                "\nYou lost! Better luck next time." +
                "\nGuesses made: " + this.getTotalGuesses() +
                "\nWord progress: " + correctGuesses + "/" + toCharHashSet(answer.toCharArray()).size() +
                "\nCorrect answer: " + this.getAnswer());
    }



}













