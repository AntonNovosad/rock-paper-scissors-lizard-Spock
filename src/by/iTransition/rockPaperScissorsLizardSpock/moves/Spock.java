package by.iTransition.rockPaperScissorsLizardSpock.moves;

public class Spock implements Moves {
    @Override
    public boolean compare(String variant) {
        return variant.equals("rock") || variant.equals("scissors");
    }
}
