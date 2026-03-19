package components.retirement_calculator.Model;

public class Retirement {
    private final int RETIREMENT_AGE = 67;
    private int birthYear;

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getRetirementYear(){
        return birthYear+RETIREMENT_AGE;
    }
}
