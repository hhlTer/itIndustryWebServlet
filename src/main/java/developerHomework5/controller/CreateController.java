package developerHomework5.controller;

import developerHomework5.controller.service.RepositoryService;
import developerHomework5.controller.service.TableService;
import developerHomework5.model.GenerallyTable;
import developerHomework5.model.RepositoryTables;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateController extends Controller {
    RepositoryTables repositoryTables = RepositoryTables.getINSTANCE();
    @Override
    void handleDoGet(HttpServletRequest httpReq, HttpServletResponse httpResp) {
//        System.out.println("=T=A=B=L=E=::::" + httpReq.getParameter("tableName")); //Ok
        String tableName = httpReq.getParameter("tableName");
        setTable(repositoryTables.getTableMap().get(tableName));
        httpReq.setAttribute("table", getTable());

//        System.out.println("!!=====IMPORTANT DEBUG======!!==table name = " + getTable().getTableName()); //ok
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
