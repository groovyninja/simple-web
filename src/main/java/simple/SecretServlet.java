package simple;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: rgordeev
 * Date: 01.07.14
 * Time: 17:45
 */
@WebServlet(name = "secret", urlPatterns = "/secure/content")
public class SecretServlet implements Servlet
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
        PrintWriter out = res.getWriter();

        out.println("Our SECRET content");

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
