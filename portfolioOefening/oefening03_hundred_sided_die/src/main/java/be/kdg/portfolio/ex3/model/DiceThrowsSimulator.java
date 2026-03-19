package be.kdg.portfolio.ex3.model;

public class DiceThrowsSimulator {
    private MultiSidedDice dice;
    private ThrowsArchive throwsArchive;
    public DiceThrowsSimulator () {
        this(1,6);
    }
    public DiceThrowsSimulator (int minimum, int maximum) {
        dice = new MultiSidedDice(minimum,maximum);
        throwsArchive = new ThrowsArchive();
        throwsArchive.addValueToArchive (dice);
    }
    public int getMultiSidedDiceValue () {
        return dice.getCurrentDiceValue();
    }
    public int multiSidedDiceThrow (int minimum, int maximum) {
        dice.setMinAndMax(minimum,maximum);
        int value = dice.getNewDiceValue();
        throwsArchive.addValueToArchive (dice);
        return value;
    }
    public MultiSidedDice getDice (){
        return dice;
    }
    public ThrowsArchive getThrowsArchive () {
        return throwsArchive;
    }
}
