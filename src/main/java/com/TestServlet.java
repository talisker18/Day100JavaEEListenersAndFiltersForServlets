package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * to create a servlet, choose new -> Servlet
 * 
 * */


/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("session created, listener will be invoked");
		
		//add some data to session
		session.setAttribute("username", "Tom");
		session.setAttribute("password", "Jerry");
		
		System.out.println("session attributes set");
		
		//change attribute, listener will recognize this
		session.setAttribute("username", "Jim");
		System.out.println("attribute changed, listener will be invoked");
		
		//destroy session
		session.invalidate();
		System.out.println("session was destroyed");
	}

}
