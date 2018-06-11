package developerHomework5.controller;

import developerHomework5.controller.service.CrudRepository;
import developerHomework5.controller.service.RepositoryService;
import developerHomework5.model.GenerallyTable;
import developerHomework5.model.RepositoryTables;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller {
    private GenerallyTable table;
    RepositoryTables repositoryTables = RepositoryTables.getINSTANCE();
    CrudRepository crudRepository = RepositoryService.getINSTANCE().getService(CrudRepository.class);

    void process(HttpServletRequest httpReq, HttpServletResponse httpResp){
        String method = httpReq.getMethod().toUpperCase();
        System.out.println("=================================Debug from Controller method = " + method);
        if (method.equals("GET")){
            handleDoGet(httpReq, httpResp);
        } else if (method.equals("POST")){
            try {
                handleDoPost(httpReq, httpResp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void handleDoPost(HttpServletRequest httpReq, HttpServletResponse httpResp) throws ServletException, IOException {
    }

    void handleDoGet(HttpServletRequest httpReq, HttpServletResponse httpResp) {
    }

    void setTable(GenerallyTable table) {
        this.table = table;
    }
    GenerallyTable getTable() {
        return table;
    }

    void tableGenerate(HttpServletRequest request){
        String tableName = request.getParameter("tableName");
        setTable(repositoryTables.getTableMap().get(tableName));
    }
}
