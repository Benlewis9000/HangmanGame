package github.benlewis9000.HangmanGame;

public class Utilities {

    public static void printProgress(char[] strArray){

        String progress = "";

        for (int i = 0; i < strArray.length - 1; i++){
            if (strArray[i] == '_' && strArray[i+1] == '_'){
                progress = progress + "_ ";
            }
            else if (strArray[i] == '_'){
                progress = progress + "_";
            }
            else {
                progress = progress + strArray[i];
            }
        }

        System.out.println(progress);

    }

}
