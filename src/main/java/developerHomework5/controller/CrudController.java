package developerHomework5.controller;

import developerHomework5.model.GenerallyTable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

class CrudController extends Controller {
    @Override
    void handleDoGet(HttpServletRequest httpReq, HttpServletResponse httpResp) {
        try {
            httpResp.setCharacterEncoding("UTF-8");
            httpReq.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        httpReq.setAttribute(getTable().getTableName(), getTable());
    }
}
