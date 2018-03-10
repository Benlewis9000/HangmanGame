package github.benlewis9000.HangmanGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {

    /* Instance variables */

    private String word;
    private int guesses;
    private int falseGuesses;
    private boolean isRunning = false;

    /* Getters and Setters */

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getGuesses() {
        return guesses;
    }

    public void setGuesses(int guesses) {
        this.guesses = guesses;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    /* Methods */

    public Game (String word){
        this.startGame(word);
    }

    public void startGame(String answer){

        /*
        HashMap<Integer, Character> answerMap = new HashMap<>();
        char[] answerArray = answer.toCharArray();
        for (int i =  0; i < answer.length(); i++){
            answerMap.put(i, answerArray[i]);
        }

        HashMap<Integer, Character> guessMap = new HashMap<>();
        for (int i = 0; i < answer.length(); i++){
            guessMap
        }
        ^^^ Hashmaps redundant, since key values for characters is literally a char[]
        */

        char[] answerArray = answer.toCharArray();
        ArrayList<Character> answerArrayList = new ArrayList<>();
        for (char c : answerArray){
            answerArrayList.add(c);
        }


        char[] guessesArray = new char[answer.length()];
        for (char c : guessesArray){
            c = '_';
        }

        // Begin Game

        this.setRunning(true);

        Scanner sc = new Scanner(System.in);

        while (this.isRunning){

            String input = sc.nextLine();

            if (input.length() > 1){

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

                char guess = input.charAt(0);

                if (!answerArrayList.contains(guess)){
                    // false answer
                    System.out.println("WRONG");
                    this.setGuesses(this.getGuesses() + 1);
                }

                for (int i = 0; i < answer.length(); i++){

                    if(guess == answer.charAt(i)){

                        guessesArray[i] = guess;

                    }

                }
                System.out.println(guessesArray);

            }

        }

    }

}













