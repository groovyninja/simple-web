package simple;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: rgordeev
 * Date: 01.07.14
 * Time: 16:42
 */
@WebServlet("/config")
public class ConfigServlet implements Servlet
{
    @Override
    public void init(ServletConfig config) throws ServletException
    {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig()
    {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
    {
        res.setCharacterEncoding("utf-8");
        res.setContentType("text/html");

        ServletContext context = config.getServletContext();

        PrintWriter out = res.getWriter();

        out.println("servlet name: " + config.getServletName());
        out.println("context path: " + context.getContextPath());
        out.println("major version: " + context.getMajorVersion());
        out.println("context name: " + context.getServletContextName());
        out.println("server info: " + context.getServerInfo());

    }

    @Override
    public String getServletInfo()
    {
        return "Roman's servlet";
    }

    @Override
    public void destroy()
    {

    }

    private ServletConfig config;
}
