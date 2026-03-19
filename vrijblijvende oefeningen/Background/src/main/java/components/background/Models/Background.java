package components.background.Models;
import java.util.Random;

public class Background {
    private final int MAX_COLOR = 256;
    private String backGroundColor;


    public Background(){
        this.backGroundColor = "cornsilk";
    }

    public String getBackGroundColor() {
        return backGroundColor;
    }

    public void setRandomColor() {
        Random random = new Random();

        int r = random.nextInt(0,MAX_COLOR);
        int g = random.nextInt(0,MAX_COLOR);
        int b = random.nextInt(0,MAX_COLOR);

        this.backGroundColor = String.format("rgb(%d,%d,%d)",r,g,b);
    }
}
