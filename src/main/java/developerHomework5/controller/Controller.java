package developerHomework5.controller;

import developerHomework5.model.GenerallyTable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller {
    private GenerallyTable table;

    void process(HttpServletRequest httpReq, HttpServletResponse httpResp){
        String method = httpReq.getMethod().toUpperCase();
        System.out.println("=================================Debug from Controller method = " + method);
        if (method.equals("GET")){
            handleDoGet(httpReq, httpResp);
        } else if (method.equals("POST")){
            handleDoPost(httpReq, httpResp);
        }
    }

    void handleDoPost(HttpServletRequest httpReq, HttpServletResponse httpResp) {
    }

    void handleDoGet(HttpServletRequest httpReq, HttpServletResponse httpResp) {
    }

    void setTable(GenerallyTable table) {
        this.table = table;
    }
    GenerallyTable getTable() {
        return table;
    }
}
