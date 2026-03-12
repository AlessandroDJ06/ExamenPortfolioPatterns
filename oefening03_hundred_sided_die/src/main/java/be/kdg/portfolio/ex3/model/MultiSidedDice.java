package be.kdg.portfolio.ex3.model;

import java.util.Random;

public class MultiSidedDice {
    public static final int MAX_VALUE = 99;
    public static final int MIN_VALUE = 0;
    private int currentValue = MIN_VALUE;
    private int min = MIN_VALUE;
    private int max = MAX_VALUE;

    private Random random = new Random();

    public MultiSidedDice() {
        this(1,6);
    }

    public MultiSidedDice(int minimum, int maximum) {
        throwDice();
    }
    public void throwDice(){
        currentValue = random.nextInt(this.max + 1 - this.min) + this.min;
    }
    public int getCurrentDiceValue() {
        return currentValue;
    }
    public int getNewDiceValue() {
        throwDice();
        return currentValue;
    }
    public int getDiceMinimum () { return this.min;}
    public int getNumberOfSides () { return this.max - this.min + 1;}
}
