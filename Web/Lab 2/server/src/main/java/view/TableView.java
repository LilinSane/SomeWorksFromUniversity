package view;

import models.ClientData;
import models.Validator;

public class TableView {

    public TableView() {}

    public <T> String createCell(T t){
        return "<td class =\"column\">" +
                "<p>" +
                t +
                "</p>" +
                "</td>";
    }

    public <T> String createRow(ClientData cl){
        String hitRes;
        String r;
        if(cl.getHit() == 1)
            hitRes = "Попадание!";
        else
            hitRes = "Промах!";
        if(Validator.isIntNum(cl.getR()))
            r = Integer.toString((int) cl.getR());
        else
            r = Float.toString(cl.getR());
        return "<tr>" +
                createCell((int) cl.getX()) +
                createCell((int) cl.getY()) +
                createCell(r) +
                createCell(hitRes) +
                createCell(cl.getCompletitionTime()) +
                createCell(cl.getCurrentDate()) +
                "</tr>";
    }
}
