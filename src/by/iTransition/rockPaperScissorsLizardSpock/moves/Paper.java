package by.iTransition.rockPaperScissorsLizardSpock.moves;

public class Paper implements Moves {
    @Override
    public boolean compare(String variant) {
        return variant.equals("Spock") || variant.equals("rock");
    }
}
