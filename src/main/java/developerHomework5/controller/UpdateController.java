package developerHomework5.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateController extends Controller {
    @Override
    void handleDoGet(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        tableGenerate(httpReq);
        httpReq.setAttribute("table", getTable());

        try {
            httpReq.getRequestDispatcher("update.jsp").forward(httpReq, httpResp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void handleDoPost(HttpServletRequest httpReq, HttpServletResponse httpResp){
    }
}
