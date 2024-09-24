import models.ClientData;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/clearTableServlet")
public class ClearTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<ClientData> clientData = (List<ClientData>) session.getAttribute("clientData");
        if(clientData != null){
            if (clientData.isEmpty()){
                response.getWriter().write("");
            }
            else {
                clientData.clear();
                session.setAttribute("clientData", clientData);
                response.getWriter().write("Очистка прошла успешно");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
