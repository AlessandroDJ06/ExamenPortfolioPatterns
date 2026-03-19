package be.kdg.portfolio.ex04.model;

public class ColorRGB {
    double red;
    double green;
    double blue;
    public ColorRGB() {
        this.red = 0.0;
        this.green = 0.0;
        this.blue = 0.0;
    }
    public double getRed() {
        return red;
    }
    public double getGreen() {
        return green;
    }
    public double getBlue() {
        return blue;
    }
    public void setRed(double red) {
        this.red = red;
    }
    public void setGreen(double green) {
        this.green = green;
    }
    public void setBlue(double blue) {
        this.blue = blue;
    }
    public String toString () {
        return String.format("R(%d)-G(%d)-B(%d)", (int) (255 * getRed()),(int) (255 * getGreen()), (int) (255 * getBlue()));
    }
}
