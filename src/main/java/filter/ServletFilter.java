package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sh1 on 14-11-3.
 */
public class ServletFilter implements Filter {
    private List<String> targets = new ArrayList<String>();

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        System.out.println("servletFilter..........");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        String target = uri.indexOf("?") > 0 ? uri.substring((uri.lastIndexOf("/") + 1), uri.indexOf("?")) : uri.substring(uri.lastIndexOf("/") + 1);
        //servlet的URL用的都是servlet/servlet的名称
//        if (uri.contains("servlet") && targets.contains(target)) {
        if (uri.contains("servlet")) {
            req.getRequestDispatcher(uri.substring(18)).forward(req, resp);
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        //在web.xml里面声明的filter里面的参数指定哪些servlet是需要过滤的，也可以不指定，直接过滤所有的servlet
        String targets = config.getInitParameter("targets");
        if (null != targets) {
            this.targets.addAll(Arrays.asList(targets.split(",")));
        }
    }

}
