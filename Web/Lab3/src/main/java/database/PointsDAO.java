package database;

import java.sql.*;

public class PointsDAO {
    private Connection connection;

    public PointsDAO() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Points", "postgres", "z111");
        Statement statement = connection.createStatement();
        createTable();
        ResultSet rs = statement.executeQuery("SELECT * FROM data");
        while (rs.next()){
            Point point = new Point();
            point.setX(rs.getFloat(1));
            point.setY(rs.getFloat(2));
            point.setR(rs.getFloat(3));
            point.setResult(rs.getBoolean(4));
            point.setWorkTime(rs.getLong(5));
            point.setCurrTime(rs.getString(6));
            CollectionPoints.collection.add(point);
        }
    }

    private void createTable() throws SQLException{
        String query = "" +
                "CREATE TABLE IF NOT EXISTS data" +
                "(" +
                        "x FLOAT NOT NULL," +
                        "y FLOAT NOT NULL," +
                        "r FLOAT NOT NULL," +
                        "result BOOLEAN NOT NULL," +
                        "workTime BIGINT NOT NULL," +
                        "currTime TEXT NOT NULL" +
                ")";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.executeUpdate();
    }

    public void addNewElement(Point point) throws SQLException{
        createTable();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO data VALUES (?,?,?,?,?,?)");
        ps.setFloat(1, point.getX());
        ps.setFloat(2, point.getY());
        ps.setFloat(3, point.getR());
        ps.setBoolean(4, point.getResult());
        ps.setLong(5,point.getWorkTime());
        ps.setString(6, point.getCurrTime());
        ps.executeUpdate();
    }

    public void dropTable() throws SQLException {
        String query = "DROP TABLE IF EXISTS data";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.executeUpdate();
    }
}
