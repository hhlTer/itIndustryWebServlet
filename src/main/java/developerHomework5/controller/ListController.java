package developerHomework5.controller;

import developerHomework5.controller.factory.CrudDaoFactory;
import developerHomework5.model.GenerallyTable;


import javax.persistence.Table;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

class ListController extends Controller {
    @Override
    void handleDoGet(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        tableGenerate(httpReq);
        GenerallyTable table = getTable();
        CrudDaoFactory<GenerallyTable, Long> daoFactory = crudRepository.getCrudDaoFactory(table.getClass());

        List<GenerallyTable> tableList = daoFactory.getList();

        httpReq.setAttribute("tables", tableList);

        try {
            httpReq.getRequestDispatcher("readById.jsp").forward(httpReq, httpResp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
