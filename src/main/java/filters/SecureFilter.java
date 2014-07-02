package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: rgordeev
 * Date: 01.07.14
 * Time: 17:36
 */
@WebFilter(filterName = "secure", urlPatterns = {"/secure/*"})
public class SecureFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;

        Boolean authorized = (Boolean) req.getSession().getAttribute("authorized");

        if (authorized != null && authorized)
            chain.doFilter(request, response);
        else
        {
            PrintWriter out = response.getWriter();

            out.println("access denied");

            out.close();
        }
    }

    @Override
    public void destroy()
    {

    }
}
