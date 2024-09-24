import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getSession().setAttribute("startTime", System.currentTimeMillis());
        if (isClear(request)){
            request.getServletContext().getNamedDispatcher("ClearTableServlet").forward(request, response);
            return;
        }
        if (isResize(request)){
            request.getServletContext().getNamedDispatcher("PlaneResizeServlet").forward(request, response);
            return;
        }
        if(isCanv(request)){
            request.getServletContext().getNamedDispatcher("AreaCheckServlet").forward(request, response);
            return;
        }
        if (isCoordinates(request)) {
            request.getServletContext().getNamedDispatcher("AreaCheckServlet").forward(request, response);
        } else {
            request.getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private boolean isResize(HttpServletRequest req){
        return req.getParameter("r") != null && req.getParameter("xcoord") == null;
    }

    private boolean isClear(HttpServletRequest req){
        return req.getParameter("cflag") != null;
    }

    private boolean isCanv(HttpServletRequest req){
        return req.getParameter("isCanv") != null;
    }

    private boolean isCoordinates(HttpServletRequest req) {
        Object x = req.getParameter("xcoord");
        Object y = req.getParameter("ycoord");
        Object r = req.getParameter("rnum");

        return x != null && y != null && r != null;
    }
}
