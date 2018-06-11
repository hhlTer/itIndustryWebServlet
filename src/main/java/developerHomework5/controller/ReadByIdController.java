package developerHomework5.controller;

import developerHomework5.controller.factory.CrudDaoFactory;
import developerHomework5.controller.service.CrudRepository;
import developerHomework5.controller.service.RepositoryService;
import developerHomework5.model.GenerallyTable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ReadByIdController extends Controller {
    @Override
    void handleDoGet(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        tableGenerate(httpReq);
        GenerallyTable table = getTable();

        Long id = Long.parseLong(httpReq.getParameter("id"));
        CrudDaoFactory<GenerallyTable, Long> daoFactory = crudRepository.getCrudDaoFactory(table.getClass());
        table = daoFactory.getById(id);
        List<GenerallyTable> tableList = new ArrayList<>();
        tableList.add(table);
        httpReq.setAttribute("tables", tableList);
        try {
            httpReq.getRequestDispatcher("readById.jsp").forward(httpReq, httpResp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void handleDoPost(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        System.out.println(httpReq.getContextPath());
    }
}
