package beans;

import HitChecker.HitChecker;
import database.CollectionPoints;
import database.Point;
import database.PointsDAO;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean(name = "process", eager = true)
@SessionScoped
public class ProcessBean {
    public PointsDAO pointsDB = new PointsDAO();

    @ManagedProperty(value = "#{coordinates}")
    private CoordinatesBean coordinatesBean;

    @ManagedProperty(value = "#{points}")
    private PointsBean pointsBean;

    public ProcessBean() throws SQLException {
    }

    public void createNewValue() throws SQLException {
        long start_time = System.currentTimeMillis();
        SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss");
        HitChecker hitChecker = new HitChecker(coordinatesBean.getCoordX(), coordinatesBean.getCoordY(), coordinatesBean.getNumR());
        Point point = new Point();
        point.setX(coordinatesBean.getCoordX());
        point.setY(coordinatesBean.getCoordY());
        point.setR(coordinatesBean.getNumR());
        point.setResult(hitChecker.checkHit());
        point.setWorkTime(System.currentTimeMillis() - start_time);
        point.setCurrTime(formatter.format(new Date(System.currentTimeMillis())));
        CollectionPoints.collection.add(point);
        pointsBean.setPointsList(CollectionPoints.collection);
        pointsDB.addNewElement(point);
    }

    public void clearTable() throws SQLException {
        CollectionPoints.collection.clear();
        pointsDB.dropTable();
    }

    public void setPointsBean(PointsBean pointsBean) {
        this.pointsBean = pointsBean;
    }

    public PointsBean getPointsBean() {
        return pointsBean;
    }

    public void setCoordinatesBean(CoordinatesBean coordinatesBean) {
        this.coordinatesBean = coordinatesBean;
    }

}
