package servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import database.CollectionPoints;
import database.Point;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/pointHistory")
public class PointHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float r = Float.parseFloat(request.getParameter("rnum"));
        Gson gson = new GsonBuilder()
                .create();
        String json = "";
        for (Point point : CollectionPoints.collection){
            if (point.getR() == r){
                json += gson.toJson(point) + "endl";
            }
        }
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
