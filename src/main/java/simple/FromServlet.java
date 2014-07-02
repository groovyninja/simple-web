package simple;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * User: rgordeev
 * Date: 01.07.14
 * Time: 16:53
 */
@WebServlet("/form")
public class FromServlet implements Servlet
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
        /*req.setCharacterEncoding("utf-8");

        res.setCharacterEncoding("utf-8");
        res.setContentType("text/html");*/

        res.setCharacterEncoding("utf-8");
        res.setContentType("text/html");

        HttpServletRequest httpReq = (HttpServletRequest) req;

        if ("get".equalsIgnoreCase(httpReq.getMethod()))
        {
            PrintWriter out = res.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("   <title>");
            out.println("       Форма");
            out.println("   </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("   <form method=\"post\">");
            out.println("       <input type=\"text\" name=\"name\"/><br/>");
            out.println("       <input type=\"text\" name=\"lastname\"/><br/>");
            out.println("       <textarea cols=\"10\" rows=\"5\" name=\"comment\"></textarea><br/>");
            out.println("       <input type=\"submit\" value=\"Отправить\"/><br/>");
            out.println("       <input type=\"reset\" value=\"Очистить\"/><br/>");
            out.println("   </form>");
            out.println("</body>");
            out.println("</html>");

            out.close();
        }
        if ("post".equalsIgnoreCase(httpReq.getMethod()))
        {
            PrintWriter out = res.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("   <title>");
            out.println("       Форма");
            out.println("   </title>");
            out.println("</head>");
            out.println("<body>");

            // render params here
            /*Enumeration<String> params = httpReq.getParameterNames();
            while (params.hasMoreElements())
            {
                String param = params.nextElement();
                String value = httpReq.getParameter(param);

                out.println(String.format("%s %s <br/>", param, value));
            }*/

            Enumeration<String> attributes = httpReq.getAttributeNames();
            while (attributes.hasMoreElements())
            {
                String attribute = attributes.nextElement();
                String value     = httpReq.getAttribute(attribute) == null ? "" : httpReq.getAttribute(attribute).toString();

                out.println(String.format("%s %s <br/>", attribute, value));
            }


            String login = httpReq.getParameter("name");
            if ("admin".equals(login))
            {
                HttpServletRequest request = (HttpServletRequest) req;
                request.getSession().setAttribute("authorized", Boolean.TRUE);
            }

            out.println("   <br/>");

            out.println("   <form method=\"post\">");
            out.println("       <input type=\"text\" name=\"name\"/><br/>");
            out.println("       <input type=\"text\" name=\"lastname\"/><br/>");
            out.println("       <textarea cols=\"10\" rows=\"5\" name=\"comment\"></textarea><br/>");
            out.println("       <input type=\"submit\" value=\"Отправить\"/><br/>");
            out.println("       <input type=\"reset\" value=\"Очистить\"/><br/>");
            out.println("   </form>");
            out.println("</body>");
            out.println("</html>");

            out.close();
        }
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
