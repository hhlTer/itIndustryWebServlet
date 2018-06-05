package developerHomework5.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class MainPageController extends Controller {
    @Override
    void handleDoGet(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        httpReq.getRequestDispatcher("WEB-INF/index.jsp");
    }
}
