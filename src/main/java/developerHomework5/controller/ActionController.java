package developerHomework5.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionController extends Controller {
    @Override
    void handleDoGet(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        String table = httpReq.getParameter("table");
        
    }
}
