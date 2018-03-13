package github.benlewis9000.HangmanGame;

import java.lang.reflect.Array;
import java.util.HashSet;

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
        System.out.println("Available commands:");
        System.out.println(" - \"help\": prints list of commands. ");
        System.out.println(" - \"exit\": exits the game. ");
    }

    public static HashSet<Character> toCharHashSet(char[] charArray){
        HashSet<Character> charHashSet = new HashSet<>();

        for (char c : charArray){
            charHashSet.add(c);
        }

        return charHashSet;
    }

}
