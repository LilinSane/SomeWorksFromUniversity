package models;

public class Validator {
    private final float x;
    private final float y;
    private final float R;

    public Validator(float x, float y, float R) {
        this.x = x;
        this.y = y;
        this.R = R;
    }

    private boolean validateX() {
        return (x >= -3) && (x <= 5);
    }
    private boolean validateY() {
        return (y >= -3) && (y <= 3);
    }
    private boolean validateR() {
        return (R >= 1) && (R <= 5);
    }
    public boolean isCanvValid(){ return (R <= 5 && R > 0) && (x <= 6 && x >= -6) && (y <= 6 && y >= -6);}
    public boolean isValid() {
        return validateX() && validateY() && validateR();
    }
    public static boolean isIntNum(float num){
        return (num % 1 == 0);
    }
}
