package developerHomework5.controller;

import developerHomework5.model.GenerallyTable;
import developerHomework5.model.RepositoryTables;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class ActionController extends Controller {
    @Override
    void handleDoGet(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        System.out.println("============================++DEBUG from ActionController: table: ");
        String tableName = httpReq.getParameter("table").toLowerCase();
        System.out.println("==========================++DEBUG from ActionController: table: " + tableName);
        GenerallyTable table = RepositoryTables.getINSTANCE().getTableMap().get(tableName);
        setTable(table);

        httpReq.setAttribute(table.getTableName(), table);

        try {
            httpReq.getRequestDispatcher("action.jsp").forward(httpReq, httpResp);
        } catch (ServletException |IOException e) {
            e.printStackTrace();
        }

    }
}
