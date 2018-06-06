package developerHomework5.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class MainPageController extends Controller {
    @Override
    void handleDoGet(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        try {
            httpReq.getRequestDispatcher("WEB-INF/index.jsp").forward(httpReq, httpResp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void handleDoPost(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        ServletRequest sr = (ServletRequest) httpReq;
    }
}
