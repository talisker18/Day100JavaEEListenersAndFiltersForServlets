package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*how to create filter for a servlet:
 * 
 * new -> Filter -> enter name of Filter -> click on Filter in tab Filter Mappings and edit -> checkbox servlets -> choose the servlet, here RegisterServlet
 * 
 * 
 * 
 * ----> use filter e.g. for validation of entered user inputs
 * */



/**
 * Servlet Filter implementation class ValidationFilter
 */
public class ValidationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ValidationFilter() {
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
		// TODO Auto-generated method stub
		// place your code here
		String pan = request.getParameter("pan"); //difference to getAttribute -> getAttribute returns a Object, getParameter returns String
		System.out.println("hi from filter");
		
		if(pan==null || !pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) { //regex: 5x letter A-Z, 4x numbers, 1x letter A-Z
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("filter_example.html").include(request, response);
			out.print("<SPAN style='color:red'>Invalid PAN number</SPAN>");
		}else {
			request.setAttribute("pan", pan);
			// pass the request along the filter chain
			chain.doFilter(request, response); //since this filter was attached to RegisterServlet, the chain will forward to that servlet like a RequestDispatcher
			//see web.xml, the filter was automatically mapped to RegisterServlet
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
