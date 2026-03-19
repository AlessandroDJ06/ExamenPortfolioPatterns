package components.dices.Model;

import java.util.Random;

public class Dice {
    public static final int MAX_PIPS = 6;

    private int numberOfPips1;
    private int numberOfPips2;
    private Random random;

    public Dice() {
        this.numberOfPips1 = 1;
        this.numberOfPips2 = 1;
        this.random = new Random();
    }

    //Toss the dice because "throw" is am existing keyword in java.
    public void toss(){
        numberOfPips1 = random.nextInt(MAX_PIPS) + 1;
        numberOfPips2 = random.nextInt(MAX_PIPS) + 1;
    }

    public int getNumberOfPips1() {
        return numberOfPips1;
    }

    public int getNumberOfPips2() {
        return numberOfPips2;
    }

}
