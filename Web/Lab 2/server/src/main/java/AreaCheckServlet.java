import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.ClientData;
import models.Validator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/areaCheckServlet")
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String isCanv = request.getParameter("isCanv");
        float x = Float.parseFloat(request.getParameter("xcoord"));
        float y = Float.parseFloat(request.getParameter("ycoord"));
        float r = Float.parseFloat(request.getParameter("rnum"));
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        Validator validator = new Validator(x, y, r);

        if (isCanv != null){
            if (!validator.isCanvValid()){
                response.getWriter().write("{\"hit\": 2}");
                return;
            }
        }
        else {
            if(!validator.isValid()){
                response.getWriter().write("{\"hit\": 2}");
                return;
            }
        }
        HttpSession session = request.getSession();
        long startTime = (long) session.getAttribute("startTime");
        int hit = isHit(x, y, r);
        SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss");
        Date currentDate = new Date(System.currentTimeMillis());
        ClientData clientReqData = new ClientData(x, y, r, hit, System.currentTimeMillis() - startTime, formatter.format(currentDate));


        List<ClientData> clientData = (List<ClientData>) session.getAttribute("clientData");
        if(clientData == null){
            clientData = new ArrayList<>();
        }
        clientData.add(clientReqData);
        session.setAttribute("clientData", clientData);

        response.getWriter().write(gson.toJson(clientReqData));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }



    private int isHit(float x, float y, float r) {
        if (x <= 0 && y >= 0){
            if (Math.abs(x) <= r / 2 && y <= r)
                return 1;
        }
        else if (x >= 0 && y >= 0) {
            if (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2))
                return 1;
        }
        else if (x <= 0 && y <= 0) {
            if (y >= (-1)*x / 2 - r/2)
                return 1;
        }
        return 0;
    }
}