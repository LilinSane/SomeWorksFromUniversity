package models;

import com.google.gson.annotations.Expose;

public class ClientData {
    private final float x;
    private final float y;
    private final float r;
    @Expose
    private final int hit;
    @Expose
    private final long completitionTime;
    @Expose
    private final String currentDate;

    public ClientData(float x, float y, float r, int hit, long completitionTime, String currentDate) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
        this.completitionTime = completitionTime;
        this.currentDate = currentDate;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
    }

    public int getHit() {
        return hit;
    }

    public long getCompletitionTime() {
        return completitionTime;
    }

    public String getCurrentDate() {
        return currentDate;
    }
}
