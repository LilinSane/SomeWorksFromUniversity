package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "coordinates")
@SessionScoped
public class CoordinatesBean implements Serializable {
    private float coordX;
    private float coordY;
    private float numR;

    public float getCoordX() {
        return coordX;
    }

    public void setCoordX(float coordX) {
        this.coordX = coordX;
    }

    public float getCoordY() {
        return coordY;
    }

    public void setCoordY(float coordY) {
        this.coordY = coordY;
    }

    public float getNumR() {
        return numR;
    }

    public void setNumR(float numR) {
        this.numR = numR;
    }
}
