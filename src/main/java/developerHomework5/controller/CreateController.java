package developerHomework5.controller;

import developerHomework5.controller.factory.CrudDaoFactory;
import developerHomework5.controller.service.CrudRepository;
import developerHomework5.controller.service.RepositoryService;
import developerHomework5.model.GenerallyTable;
import developerHomework5.model.RepositoryTables;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateController extends Controller {
//    GenerallyTable table;

    @Override
    void handleDoGet(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        /*
         * table initialization
         * init and sets up the appropriate database, using setTable method and name of did choose db.
//         */
        tableGenerate(httpReq);
        httpReq.setAttribute("table", getTable());

        try {
            httpReq.getRequestDispatcher("create.jsp").forward(httpReq, httpResp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void handleDoPost(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        GenerallyTable table = getTable();
        fillTable(table, httpReq);

        CrudRepository crudRepository = RepositoryService.getINSTANCE().getService(CrudRepository.class);
        CrudDaoFactory<GenerallyTable, Long> crud = crudRepository.getCrudDaoFactory(GenerallyTable.class);
        crud.create(table);

        try {
            httpResp.sendRedirect("/itIndustry/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillTable(GenerallyTable table, HttpServletRequest request){
        Map<String, String> dataTable = new HashMap<>();
        for (String s:
                table.getPrm()) {
            dataTable.put(s, request.getParameter(s));
        }
        table.fillTable(dataTable);
    }
}
