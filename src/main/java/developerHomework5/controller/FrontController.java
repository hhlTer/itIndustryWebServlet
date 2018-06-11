package developerHomework5.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter("/*")
public class FrontController implements Filter {

    private Map<String, Controller> requestMap;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        requestMap = new HashMap<>();
        requestMap.put("/itIndustry/".toLowerCase(), new MainPageController());
        requestMap.put("/itIndustry/action".toLowerCase(), new ActionController());
        requestMap.put("/itIndustry/crud".toLowerCase(), new CrudController());
        requestMap.put("/itIndustry/create".toLowerCase(), new CreateController());
        requestMap.put("/itIndustry/getById".toLowerCase(), new ReadByIdController());
        requestMap.put("/itIndustry/update".toLowerCase(), new UpdateController());
        requestMap.put("/itIndustry/list".toLowerCase(), new ListController());
        requestMap.put("/itIndustry/delete".toLowerCase(), new DeleteController());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        httpServletRequest.setCharacterEncoding("UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");

        String uri = httpServletRequest.getRequestURI().toLowerCase();
        System.out.println("================+Debug - from FrontController URI: " + uri);
        if (uri.endsWith(".jsp")){
            filterChain.doFilter(servletRequest, servletResponse);
//            servletRequest.getRequestDispatcher(uri).forward(servletRequest, servletResponse);
        } else {
            try {
                requestMap.get(uri).process(httpServletRequest, httpServletResponse);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void destroy() {

    }
}
