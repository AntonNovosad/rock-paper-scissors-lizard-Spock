package by.iTransition.rockPaperScissorsLizardSpock.moves;

public class Rock implements Moves {
    @Override
    public boolean compare(String variant) {
        return variant.equals("scissors") || variant.equals("lizard");
    }
}
