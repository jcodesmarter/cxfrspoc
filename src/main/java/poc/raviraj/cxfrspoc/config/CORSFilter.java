package poc.raviraj.cxfrspoc.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CORSFilter
 */
public class CORSFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CORSFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (((HttpServletRequest) request).getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(((HttpServletRequest) request).getMethod())) {
			// CORS "pre-flight" request
			((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "http://localhost:8888");
			((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
//			response.addHeader("Access-Control-Allow-Headers", "Authorization");
            ((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", "Content-Type, X-HTTP-Method-Override");
            
			((HttpServletResponse) response).addHeader("Access-Control-Max-Age", "1");
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
