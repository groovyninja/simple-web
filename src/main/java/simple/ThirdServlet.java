package simple;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * User: rgordeev
 * Date: 01.07.14
 * Time: 16:11
 */
@WebServlet(name = "forward", urlPatterns = {"/frwd"})
public class ThirdServlet implements Servlet
{
    @Override
    public void init(ServletConfig config) throws ServletException
    {
        System.out.println("init Servlet");
    }

    @Override
    public ServletConfig getServletConfig()
    {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
    {
        res.setCharacterEncoding("utf-8");
        res.setContentType("text/html");

        req.setCharacterEncoding("utf-8");

        //req.getRequestDispatcher("/simple").forward(req, res);
        req.getRequestDispatcher("/index.html").include(req, res);

    }

    @Override
    public String getServletInfo()
    {
        return null;
    }

    @Override
    public void destroy()
    {
        System.out.println("destroy servlet");
    }
}
