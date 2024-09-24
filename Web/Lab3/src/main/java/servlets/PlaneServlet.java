package servlets;

import HitChecker.HitChecker;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/planeHandler")
public class PlaneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String s = request.getParameter("xcoord");
        float x = Float.parseFloat(request.getParameter("xcoord"));
        float y = Float.parseFloat(request.getParameter("ycoord"));
        float r = Float.parseFloat(request.getParameter("rnum"));
        HitChecker hitChecker = new HitChecker(x, y, r);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new SimpleModule());
        response.getWriter().write(objectMapper.writeValueAsString(String.valueOf(hitChecker.checkHit())));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
