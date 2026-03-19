package be.kdg.portfolio.ex04.model;

public class ModelWorldOfColors {
    FlagType flag;
    ColorRGB[] flagColors;

    public ModelWorldOfColors() {
        this.flag = FlagType.HORIZONTAL;
        this.flagColors = new ColorRGB[3];
        for (int i = 0; i < 3; i++){
            this.flagColors[i] = new ColorRGB();
        }
    }
    public FlagType getFlagType () {
        return flag;
    }
    public void setFlagType (FlagType flagType) {
        this.flag = flagType;
    }
    public ColorRGB[] getFlagColors() {
        return flagColors;
    }

    @Override
    public String toString() {
        return "flag = " + flag + "\nflagColors = " +
                flagColors[0]+" \n                     "+
                flagColors[1]+" \n                     "+
                flagColors[2];
    }
}