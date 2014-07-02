package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: rgordeev
 * Date: 01.07.14
 * Time: 17:23
 */
@WebFilter(filterName = "simple", urlPatterns = {"/*"})
public class SimpleFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        /*PrintWriter out = response.getWriter();

        out.println("Hello filter");

        out.close();*/
        /*request.setCharacterEncoding("utf-8");

        response.setCharacterEncoding("utf-8");*/
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy()
    {

    }
}
