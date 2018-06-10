package developerHomework5.controller;

import developerHomework5.model.GenerallyTable;
import developerHomework5.model.RepositoryTables;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

class MainPageController extends Controller {
    @Override
    void handleDoGet(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        try {
            httpReq.getRequestDispatcher("index.jsp").forward(httpReq, httpResp);
            System.out.println("=============================+Debug from MainPageController");
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void handleDoPost(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        try {
            httpReq.setCharacterEncoding("UTF-8");
            httpResp.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ServletRequest request = (ServletRequest) httpReq;
        ServletResponse response = (ServletResponse) httpResp;

        String tableName = httpReq.getParameter("table");
        String command = httpReq.getParameter("crud");

        setTable(RepositoryTables.getINSTANCE().getTableMap().get(tableName));




        System.out.println("================DEBUG from MainController handleDoPost table: "
                + httpReq.getParameter("table")
                + httpReq.getParameter("crud"));
    }
}
