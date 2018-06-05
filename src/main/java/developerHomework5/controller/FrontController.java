package developerHomework5.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter("/itIndustry/")
public class FrontController implements Filter {

    Map<String, Controller> requestMap;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        requestMap = new HashMap<>();
        requestMap.put("/itIndustry/", new MainPageController());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
