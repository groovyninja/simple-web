package simple;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: rgordeev
 * Date: 01.07.14
 * Time: 15:25
 */

@WebServlet(name = "simple", urlPatterns = {"/simple"})
public class SimpleSrvlet implements Servlet
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
        /**
         * определяем кодировку и тип отдаваемого
         * контента
         */
        res.setCharacterEncoding("utf-8");
        res.setContentType("text/html");

        /**
         * отдаем контент
         */
        PrintWriter out = res.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("   <title>");
        out.println("       Моя страница");
        out.println("   </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("   <h1>Заголовок H1</h1>");
        out.println("   <p>");
        out.println("       Абзац на странице");
        out.println("   </p>");
        out.println("</body>");
        out.println("</html>");

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
