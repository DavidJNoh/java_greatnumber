package com.David.web;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Game
 */
@WebServlet("/")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Game() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	System.out.println(session.getAttribute("correct"));
    	
    	
    	if(session.getAttribute("correct")==null || ((boolean) session.getAttribute("correct")) == true) {
    	
    		session.setAttribute("correct", false);
    	
    		Random ran = new Random();
    	
    		int answer = ran.nextInt(100)+1;
    	
			session.setAttribute("counter", answer);
		
			System.out.println("Restart"+ session.getAttribute("counter"));
    	}
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Home.jsp");
        view.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	
    	System.out.println("Guess " + request.getParameter("guess"));
		System.out.println("Session " + session.getAttribute("counter"));
    	
		if(request.getParameter("guess").isEmpty() || (int) session.getAttribute("counter") > Integer.parseInt(request.getParameter("guess"))) {
    		session.setAttribute("status", "Too Low");
    		System.out.println("Too Low");
    	}
		
		else if((int) session.getAttribute("counter") == Integer.parseInt(request.getParameter("guess"))) {
    		System.out.println("Correct");
    		session.setAttribute("correct", true);
    		session.setAttribute("status", "Lucky Bastard");
    	}
    	
		else if((int) session.getAttribute("counter") < Integer.parseInt(request.getParameter("guess"))) {
    		session.setAttribute("status", "Too High");
    		System.out.println("Too High");
    	}

		response.sendRedirect("/GreatNumber");
	}

}
