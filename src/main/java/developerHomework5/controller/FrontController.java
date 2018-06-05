package developerHomework5.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter("/itIndustry/")
public class FrontController implements Filter {

    Map<String, Controller> requestMap;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        requestMap = new HashMap<>();
        requestMap.put("/itIndustry/".toLowerCase(), new MainPageController());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        httpServletRequest.setCharacterEncoding("UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");

        String uri = httpServletRequest.getRequestURI().toLowerCase();
        try {
            requestMap.get(uri).process(httpServletRequest, httpServletResponse);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
