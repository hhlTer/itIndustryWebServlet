package developerHomework5.controller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller {
    void process(HttpServletRequest httpReq, HttpServletResponse httpResp){
        System.out.printf("==================================================");
        String method = httpReq.getMethod().toUpperCase();
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
}
