package github.benlewis9000.HangmanGame;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Scanner;

public class Utilities {

    public static void printProgress(char[] charArray){

        String progress = new String();

        // Developer Variable:
        boolean universalSpacing = true;  // Changes the format between "h a n _ _ m a n" and "ha_ _man"

        if(universalSpacing){

            for (char c : charArray){
                progress = progress + c + " ";  // <- excess space on end, not an issue for now.
            }

        }
        else {

            for (int i = 1; i < charArray.length; i++){
                if (charArray[i-1] == '_' && charArray[i] == '_'){
                    progress = progress + " _";
                }
                else if (charArray[i] == '_'){
                    progress = progress + "_";
                }
                else {
                    progress = progress + charArray[i];
                }
            }
        }

        System.out.println(progress);

    }

    public static void printHelp() {
        System.out.println(
                "Available commands:" +
                "\n - \"help\": prints list of commands. " +
                "\n - \"exit\": exits the game." +
                "\nTo submit a guess, type the letter and press ENTER." +
                "\nGuesses must be 1 character only, and are case sensitive.\n");
    }

    public static HashSet<Character> toCharHashSet(char[] charArray){
        HashSet<Character> charHashSet = new HashSet<>();

        for (char c : charArray){
            charHashSet.add(c);
        }

        return charHashSet;
    }

    public static boolean askQuestion(String question) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n" + question + "(\"y\"/\"n\")");

            switch (sc.nextLine()) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    break;
            }
        }
    }

    /*
    public static void clearConsole (){
        for (int i = 0; i < 80; i++){
            System.out.println("");
        }
    }
    */

    public static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ex) {}
    }

}
