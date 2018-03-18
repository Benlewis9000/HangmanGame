package github.benlewis9000.HangmanGame;

public class HangmanCharacter {
    CharacterStage stage = CharacterStage.STAGE_1;

    public CharacterStage getStage() {
        return stage;
    }

    public void setStage(CharacterStage stage) {
        this.stage = stage;
    }

    public HangmanCharacter (CharacterStage stage){
        this.setStage(stage);
    }

    public void stageUp () {
        CharacterStage[] stages = CharacterStage.values();
        if (this.getStage() != CharacterStage.STAGE_9) {
            this.setStage(stages[this.getStage().ordinal() + 1]);
        }
    }

    public void draw (){

        switch (this.getStage()){

            case STAGE_0:
                System.out.println("\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n");
            case STAGE_1:
                System.out.println("\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "_______\n");
                break;
            case STAGE_2:
                System.out.println("  \n" +
                        " |\n" +
                        " |\n" +
                        " |\n" +
                        " |\n" +
                        " |\n" +
                        " |\n" +
                        "_|_____\n");
                break;
            case STAGE_3:
                System.out.println("  _______\n" +
                        " |\n" +
                        " |\n" +
                        " |\n" +
                        " |\n" +
                        " |\n" +
                        " |\n" +
                        "_|_____\n");
                break;
            case STAGE_4:
                System.out.println("  _______\n" +
                        " |/\n" +
                        " |\n" +
                        " |\n" +
                        " |\n" +
                        " |\n" +
                        " |\n" +
                        "_|_____\n");
                break;
            case STAGE_5:
                System.out.println("  _______\n" +
                        " |/      |\n" +
                        " |      (_)\n" +
                        " |\n" +
                        " |\n" +
                        " |\n" +
                        " |\n" +
                        "_|_____\n");
                break;
            case STAGE_6:
                System.out.println("  _______\n" +
                        " |/      |\n" +
                        " |      (_)\n" +
                        " |       |\n" +
                        " |       |\n" +
                        " |\n" +
                        " |\n" +
                        "_|_____\n");
                break;
            case STAGE_7:
                System.out.println("  _______\n" +
                        " |/      |\n" +
                        " |      (_)\n" +
                        " |      \\|/\n" +
                        " |       |\n" +
                        " |\n" +
                        " |\n" +
                        "_|_____\n");
                break;
            case STAGE_8:
                System.out.println("  _______\n" +
                        " |/      |\n" +
                        " |      (_)\n" +
                        " |      \\|/\n" +
                        " |       |\n" +
                        " |      / \\\n" +
                        " |\n" +
                        "_|_____\n");
                break;
            case STAGE_9:
                System.out.println("  _______\n" +
                        " |/      |\n" +
                        " |       |\n" +
                        " |      (_)\n" +
                        " |      /|\\\n" +
                        " |       |\n" +
                        " |      / \\\n" +
                        "_|_____\n");
                break;
        }

    }

}
