package filters;

import org.apache.catalina.filters.FilterBase;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * User: rgordeev
 * Date: 01.07.14
 * Time: 18:44
 */
public class DataFilter extends FilterBase
{
    private static final Log log = LogFactory.getLog(DataFilter.class);

    @Override
    protected Log getLogger()
    {
        return log;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        //HttpServletRequest http = (HttpServletRequest) request;
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements())
        {
            // read request params
            String param = params.nextElement();
            String value = request.getParameter(param);

            // set request attributes
            String newValue = value == null ? value : value.toUpperCase();
            request.setAttribute(param, newValue);
        }

        chain.doFilter(request, response);
    }
}
