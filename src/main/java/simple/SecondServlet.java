package simple;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: rgordeev
 * Date: 01.07.14
 * Time: 15:50
 */
@WebServlet(name = "second", urlPatterns = {"/second"})
public class SecondServlet implements Servlet
{
    @Override
    public void init(ServletConfig config) throws ServletException
    {

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

        PrintWriter out = res.getWriter();

        out.println("Hello!");

        out.close();

    }

    @Override
    public String getServletInfo()
    {
        return null;
    }

    @Override
    public void destroy()
    {

    }
}
