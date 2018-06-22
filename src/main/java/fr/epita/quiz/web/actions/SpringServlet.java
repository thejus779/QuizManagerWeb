package fr.epita.quiz.web.actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * This class is Spring Servlet class which extends HttpServlet 
 *
 * @author  THEJUS
 *
 */
public class SpringServlet extends HttpServlet {

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

}
