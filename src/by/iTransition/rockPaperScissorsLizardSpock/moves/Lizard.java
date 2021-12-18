package by.iTransition.rockPaperScissorsLizardSpock.moves;

public class Lizard implements Moves {
    @Override
    public boolean compare(String variant) {
        return variant.equals("Spock") || variant.equals("paper");
    }
}
