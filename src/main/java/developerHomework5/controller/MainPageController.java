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

        String tableName = httpReq.getParameter("tableName");
        String command = httpReq.getParameter("crud");
        String id = httpReq.getParameter("id");


        String url = "/itIndustry/";
            if (null != command) {
                if (command.equals("create")) {
                    url = "/itIndustry/create?tableName=" + tableName;
                } else if (command.equals("getById")) {
                    url = "/itIndustry/getById?tableName=" + tableName + "&id=" + id;
                }
            }

        try {
            httpResp.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
