package github.benlewis9000.HangmanGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WordGenerator {

    /*

        This class is used to choose a random word for the game.
        Long term goal is to have it choose from a proper file, or link up to an online generator.
        For now, the efficiency of this class is not the aim of this project.
        (basically, just ignore it)

     */

    ArrayList<String> words = new ArrayList<>(Arrays.asList(
            "gravel",
            "premium",
            "favour",
            "oven",
            "carriage",
            "mushroom",
            "sector",
            "software",
            "illness",
            "divide",
            "express",
            "cower",
            "extort",
            "voyage",
            "haircut",
            "invite",
            "pudding",
            "passage",
            "mosque",
            "healthy",
            "excuse",
            "forum",
            "waiter",
            "writer",
            "atent",
            "fever",
            "forbid",
            "sandwich",
            "concede",
            "crackpot",
            "bomber",
            "happen",
            "student",
            "level",
            "compete",
            "sister",
            "disclose",
            "Venus",
            "visual",
            "standard",
            "sculpture",
            "impound",
            "middle",
            "measure",
            "curtain",
            "supply",
            "spectrum",
            "respect",
            "viable",
            "bundle",
            "trivial",
            "guitar",
            "video",
            "costume",
            "axis",
            "Europe",
            "bracket",
            "brainstorm",
            "despise",
            "enhance",
            "tourist",
            "extinct",
            "dressing",
            "prison",
            "gradient",
            "eaux",
            "attic",
            "combine",
            "mutual",
            "monstrous",
            "welfare",
            "desire",
            "player",
            "sale",
            "function",
            "village",
            "increase",
            "color",
            "frighten",
            "engine",
            "relief",
            "despair",
            "alive",
            "plastic",
            "packet",
            "cousin",
            "metal",
            "father",
            "sulphur",
            "error",
            "user",
            "plaster",
            "sentence",
            "insert",
            "contain",
            "dialect",
            "certain",
            "training",
            "chicken",
            "cluster"));

    public WordGenerator (){}

    public String generateWord(){
        int random = new Random().nextInt(100);

        return words.get(random);

    }

}
