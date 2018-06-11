package developerHomework5.controller;

import developerHomework5.controller.factory.CrudDaoFactory;
import developerHomework5.model.GenerallyTable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class DeleteController extends Controller {
    private GenerallyTable table;
    private CrudDaoFactory<GenerallyTable, Long> daoFactory;

    @Override
    void handleDoGet(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        System.out.println("==============+Debug from DeleteController handleDoPost");
        tableGenerate(httpReq);
        table = getTable();
        daoFactory = crudRepository.getCrudDaoFactory(table.getClass());

        Long idDelete = Long.parseLong(
                httpReq.getParameter("idDelete")
        );
        table = daoFactory.getById(idDelete);
        httpReq.setAttribute("table", table);

        try {
            httpReq.getRequestDispatcher("delete.jsp").forward(httpReq, httpResp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void handleDoPost(HttpServletRequest httpReq, HttpServletResponse httpResp) {

        daoFactory.delete(table);
        System.out.println("=================Debug from DeleteController handleDoPost");
        try {
            httpResp.sendRedirect("/itIndustry/");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
