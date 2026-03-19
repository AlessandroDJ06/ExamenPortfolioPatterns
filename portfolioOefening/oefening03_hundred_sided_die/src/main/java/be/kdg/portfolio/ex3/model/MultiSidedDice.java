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
        setMinAndMax(minimum,maximum);
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

    public void setMinAndMax(int min , int max) {
            if (min < MIN_VALUE) throw new IllegalArgumentException("getal " + min + " is te klein");
            this.min = min;
            if (max > MAX_VALUE) throw new IllegalArgumentException("getal " + max + " is te groot");
            this.max = max;
            if (max < min) throw new IllegalArgumentException("min kan niet groter zijn als max");
    }


}
