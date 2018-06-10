package developerHomework5.controller;

import developerHomework5.model.GenerallyTable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateController extends Controller {
    @Override
    void handleDoGet(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        httpReq.setAttribute("table", getTable());
        try {
            httpReq.getRequestDispatcher("create.jsp").forward(httpReq, httpResp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void handleDoPost(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        String tableName = httpReq.getParameter("table");
        GenerallyTable table = (GenerallyTable) httpReq.getAttribute("table");
        //Crud crud = GrudDaoFactory.getMap.get(tableName)
        //crud.create(table);
    }
}
