package be.kdg.portfolio.ex3.dao;

public class DieThrow {
    private int id;
    private final int result;
    private final int min;
    private final int max;

    // Gebruik deze bij een nieuwe worp
    public DieThrow(int result, int min, int max) {
        this.id = -1;
        this.result = result;
        this.min = min;
        this.max = max;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getResult() { return result; }
    public int getMin() { return min; }
    public int getMax() { return max; }

    @Override
    public String toString() {
        return String.format("Worp #%d: Resultaat %d (Bereik: %d-%d)", id, result, min, max);
    }
}