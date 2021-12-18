package by.iTransition.rockPaperScissorsLizardSpock.moves;

public class Scissors implements Moves {
    @Override
    public boolean compare(String variant) {
        return variant.equals("paper") || variant.equals("lizard");
    }
}
