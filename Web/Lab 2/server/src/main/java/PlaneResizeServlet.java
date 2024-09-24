import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/planeResizeServlet")
public class PlaneResizeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float r = Float.parseFloat(request.getParameter("rnum"));
        HttpSession session = request.getSession();
        session.setAttribute("rnum", r);
        response.getWriter().write("График успешно перерисован");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
