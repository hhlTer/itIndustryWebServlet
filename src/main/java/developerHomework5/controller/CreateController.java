package developerHomework5.controller;

import developerHomework5.controller.factory.CrudDaoFactory;
import developerHomework5.controller.service.CrudRepository;
import developerHomework5.controller.service.RepositoryService;
import developerHomework5.controller.service.TableService;
import developerHomework5.model.Developer;
import developerHomework5.model.GenerallyTable;
import developerHomework5.model.RepositoryTables;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateController extends Controller {
    RepositoryTables repositoryTables = RepositoryTables.getINSTANCE();
//    GenerallyTable table;

    @Override
    void handleDoGet(HttpServletRequest httpReq, HttpServletResponse httpResp) {
//        System.out.println("=T=A=B=L=E=::::" + httpReq.getParameter("tableName")); //Ok
        String tableName = httpReq.getParameter("tableName");
        setTable(repositoryTables.getTableMap().get(tableName));
        httpReq.setAttribute("table", getTable());
        System.out.println(getTable().getPrm());
//        System.out.println("!!=====IMPORTANT DEBUG======!!==table name = " + getTable().getTableName()); //ok
        try {
            httpReq.getRequestDispatcher("create.jsp").forward(httpReq, httpResp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void handleDoPost(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        System.out.println("========================from CreateController handleDoPost");
//        GenerallyTable table = getTable();
        Developer table = (Developer)getTable();
        Map<String, String> dataTable = new HashMap<>();
        System.out.println(table.getPrm());
        System.out.println("=======PARAMETER======sex: " + httpReq.getParameter("sex"));
        for (String s:
             table.getPrm()) {
            dataTable.put(s, httpReq.getParameter(s));
        }
        table.fillTable(dataTable);
        System.out.println(table.getAll());

        CrudRepository crudRepository = RepositoryService.getINSTANCE().getService(CrudRepository.class);
        CrudDaoFactory<Developer, Long> crud = crudRepository.getCrudDaoFactory(Developer.class);
        crud.create(table);

        //Crud crud = GrudDaoFactory.getMap.get(tableName)
        //crud.create(table);
    }

}
