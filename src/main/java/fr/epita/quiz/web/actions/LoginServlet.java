package fr.epita.quiz.web.actions;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epita.quiz.datamodel.Login;
import fr.epita.quiz.services.AuthenticationService;
import fr.epita.quiz.services.LoginDAO;
import fr.epita.quiz.services.QuestionDAO;
import fr.epita.quiz.web.constants.Constants;


/**
 * This class is Servlet implementation class Login
 *
 * @author  THEJUS
 *
 */

@WebServlet(urlPatterns = {"/login","/register"})
public class LoginServlet extends SpringServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = LogManager.getLogger(LoginServlet.class);

	@Inject
	AuthenticationService auth;

	@Inject
	private LoginDAO loginDao;
	
	@Inject
	private QuestionDAO questionDao;
	/**
	 * Default constructor.
	 */
	public LoginServlet() {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String email = request.getParameter(Constants.GET_PARAMETER_UNAME);
		final String password = request.getParameter(Constants.GET_PARAMETER_PAWD);
		final String confpassword = request.getParameter(Constants.GET_PARAMETER_CNF_PAWD);

		
		if(request.getRequestURI().contains(Constants.URL_LOGIN)) {
			LOGGER.debug("USERNAME : " + email); 

			
			Login login = new Login(email, password, password, userType(request));
			
			final boolean authenticated = auth.authenticate(login);
			
			request.getSession().setAttribute("authenticated", authenticated);
			request.getSession().setAttribute("userName", login);

			if(!authenticated) {
				LOGGER.debug("Please login again, authentication failed."); 
			}
			else {
				try {
					response.sendRedirect(Constants.REDIRECT_HOME);
				} catch (IOException e) {
					
					LOGGER.debug("Redirect failed."); 
				}
			}
		}
		else {
					
			Login login = new Login(email, password,confpassword,userType(request));
			
			loginDao.create(login);
			
			try {
				response.sendRedirect(Constants.REDIRECT_HOME);
			} catch (IOException e) {
				LOGGER.debug("Redirect failed."); 
			}
					
		}	
	}
	
	private String userType(HttpServletRequest req) {
		if (req.getParameter(Constants.GET_PARAMETER_USER_TYPE).contains(Constants.USER_TYPE_STUDENT)) {
			return Constants.USER_TYPE_STUDENT;
		} else 
			return Constants.USER_TYPE_QUIZMASTER;

	}

}
