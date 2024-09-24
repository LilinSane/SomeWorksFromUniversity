package beans;

import database.CollectionPoints;
import database.Point;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "points")
@SessionScoped
public class PointsBean implements Serializable {

    private List<Point> pointsList = CollectionPoints.collection;


    public void addElement(Point p){
        pointsList.add(p);
    }

    public List<Point> getPointsList() {
        return pointsList;
    }

    public void setPointsList(List<Point> pointsList) {
        this.pointsList = pointsList;
    }

}