package developerHomework5.controller;

import developerHomework5.controller.factory.CrudDaoFactory;
import developerHomework5.model.GenerallyTable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class UpdateController extends Controller {
    @Override
    void handleDoGet(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        tableGenerate(httpReq);
        httpReq.setAttribute("table", getTable());
        CrudDaoFactory<GenerallyTable, Long> daoFactory = crudRepository.getCrudDaoFactory(getTable().getClass());
        Long id = Long.parseLong(httpReq.getParameter("idUpdate"));
        GenerallyTable table = daoFactory.getById(id);

        httpReq.setAttribute("table", table);

        try {
            httpReq.getRequestDispatcher("update.jsp").forward(httpReq, httpResp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void handleDoPost(HttpServletRequest httpReq, HttpServletResponse httpResp){
        GenerallyTable table = getTable();
        fillTable(table, httpReq);

        CrudDaoFactory<GenerallyTable, Long> daoFactory = crudRepository.getCrudDaoFactory(table.getClass());
        daoFactory.update(table);
        try {
            httpResp.sendRedirect("/itIndustry/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}