package HitChecker;

public class HitChecker {
    private float x;
    private float y;
    private float r;

    public HitChecker(float x, float y, float r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public boolean checkHit(){
        if (x <= 0 && y >= 0){
            if (Math.abs(x) <= r / 2 && y <= r)
                return true;
        }
        if (x >= 0 && y <= 0) {
            if (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2))
                return true;
        }
        if (x >= 0 && y >= 0) {
            if (y <=  (-1) * (float) 2*x + r)
                return true;
        }
        return false;
    }
}
