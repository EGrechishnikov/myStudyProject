package filters;

import javax.servlet.*;
import java.io.IOException;
import javax.servlet.Filter;

/**
 * Filter for set UTF-8
 */
public class UTF8 implements Filter {
    private String code;

    /**
     * Initialization
     *
     * @param filterConfig - config
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        code = filterConfig.getInitParameter("encoding");
    }

    /**
     * Filtration. Encoding sets here.
     *
     * @param servletRequest  - request
     * @param servletResponse - response
     * @param filterChain     - chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String codeResponse = servletResponse.getCharacterEncoding();

        if (code != null && !code.equalsIgnoreCase(codeResponse)) {
            servletResponse.setCharacterEncoding(code);
        }

        String codeRequest = servletRequest.getCharacterEncoding();

        if (code != null && !code.equalsIgnoreCase(codeRequest)) {
            servletRequest.setCharacterEncoding(code);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * Close
     */
    @Override
    public void destroy() {
        code = null;
    }
}
