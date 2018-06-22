package fr.epita.quiz.web.actions;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.QuestionType;
import fr.epita.quiz.services.MCQChoiceDAO;
import fr.epita.quiz.services.QuestionDAO;
import fr.epita.quiz.web.constants.Constants;

/**
 * This class is Servlet implementation class for Question
 *
 * @author  THEJUS
 *
 */

@WebServlet(urlPatterns = { "/create", "/update", "/delete", "/search", "/redirectToHome", "/createNew",
		"/redirectToUpdateQuestion", "/updateQuestion","/view","/searchByString" })
public class QuestionServlet extends SpringServlet {

	private static final long serialVersionUID = -3131943414389127397L;
	
	@Inject
	QuestionDAO questionDAO;

	@Inject
	MCQChoiceDAO mcqDAO;

	private static final Logger LOGGER = LogManager.getLogger(LoginServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if ((req.getRequestURL() + "").contains(Constants.CREATE_OPERATION)) {
			
			createData(req, resp);
			
		} 
		else if ((req.getRequestURL() + "").contains(Constants.SEARCH_OPERATION_STRING)) {
			List<Question> questionList = questionDAO.searchQuestionByString(req.getParameter(Constants.SEARCH_BY_STRING_PARAMETER));
			req.setAttribute(Constants.QUESTIN_LIST_UNIQUE_SET_ATTRIBUTE, questionList);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(Constants.HOME_PAGE);
			
			try {
				rd.forward(req, resp);
			} catch (IOException e) {
				LOGGER.debug(Constants.FORWARD_FAILED+ e); 
			}
			
		}
		else if ((req.getRequestURL() + "").contains(Constants.DISPLAY_QUESTION)) {
			
			HttpSession session = req.getSession();
			
			Question question = new Question();

			String id = req.getParameter(Constants.STRING_QUSTION_ID).trim();
			question.setQuestion(req.getParameter(Constants.STRING_QUESTION));
			question.setId(Integer.parseInt(id));
			question.setType(type(req));
			
			session.setAttribute(Constants.MCQ_DISPLAY_UNIQUE_SET_ATTRIBUTE, question);
			
			try {
				resp.sendRedirect(Constants.DISPLAY_MCQ_PAGE);
			} catch (IOException e) {
				LOGGER.debug(Constants.REDIRECT_FAILED+ e);
			}
			
		}
		else if ((req.getRequestURL() + "").contains(Constants.UPDATE_QUESTION_OPERATION)) {

			updateData(req, resp);
		}else if ((req.getRequestURL() + "").contains(Constants.UPDATE_QUESTION_OPERATION_GENERAL)) {
			
			req.setAttribute(Constants.QUESTION_UPDATE_UNIQUE_SET_ATTRIBUTE, fetchMatchingQuestion(req, resp));
			RequestDispatcher rd = getServletContext().getRequestDispatcher(Constants.UPDATE_QST_PAGE);
			
			try {
				rd.forward(req, resp);
			} catch (IOException e) {
				LOGGER.debug(Constants.FORWARD_FAILED+ e); 
			}

		} else if ((req.getRequestURL() + "").contains(Constants.DELETE_QUESTION_OPERATION)) {

			deleteData(req, resp);
		} 
		else if ((req.getRequestURL() + "").contains(Constants.SEARCH_QUESTION_OPERATION)) {
			searchData(req, resp);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getRequestURI().contains(Constants.REDIRECT_HOME)) {

			req.setAttribute(Constants.QUESTIN_LIST_UNIQUE_SET_ATTRIBUTE, questionDAO.fetchAllQuestions());
			RequestDispatcher rd = getServletContext().getRequestDispatcher(Constants.HOME_PAGE);
			rd.forward(req, resp);
			
			
			
		/*	int page = 1;
            int recordsPerPage = 5;
            if(req.getParameter("page") != null)
                page = Integer.parseInt(req.getParameter("page"));
            List<Question> totalList = questionDAO.fetchAllQuestions();
            List<Question> list = questionDAO.viewAllEmployees((page-1)*recordsPerPage,
                                     recordsPerPage);
            int noOfRecords = totalList.size();
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            req.setAttribute(Constants.QUESTIN_LIST_UNIQUE_SET_ATTRIBUTE, list);
            req.setAttribute(Constants.NUMBER_OF_PAGES, noOfPages);
            req.setAttribute(Constants.CURRENT_PAGE, page);
            RequestDispatcher view = req.getRequestDispatcher("employee.jsp");
            view.forward(req, resp); */
			

		} else if (req.getRequestURI().contains(Constants.CREATE_QST_PAGE)) {
			try {
				resp.sendRedirect(Constants.QUESTIONS_PAGE);
			} catch (IOException e) {
				LOGGER.debug(Constants.REDIRECT_FAILED + e);
			}
		}

	}

	private void deleteData(HttpServletRequest req, HttpServletResponse resp) {

		Question question = new Question();

		String id = req.getParameter(Constants.STRING_QUSTION_ID).trim();
		question.setQuestion(req.getParameter(Constants.STRING_QUESTION));
		question.setId(Integer.parseInt(id));
		question.setType(type(req));

		if (question.getType() != null) {

			mcqDAO.deleteAllMCQs(question);
			questionDAO.delete(question);

			try {
				resp.sendRedirect(Constants.REDIRECT_HOME);
			} catch (IOException e) {
				LOGGER.debug(Constants.REDIRECT_FAILED+ e);
			}
		}

	}

	private Question fetchMatchingQuestion(HttpServletRequest req, HttpServletResponse resp) {

		Question question = new Question();

		String id = req.getParameter(Constants.STRING_QUSTION_ID).trim();
		question.setQuestion(req.getParameter(Constants.STRING_QUESTION));
		question.setId(Integer.parseInt(id));
		question.setType(type(req));
		List<Question> questionList = questionDAO.search(question);

		Question fetchedQuestion = questionList.get(0);

		return fetchedQuestion;
	}

	private void updateData(HttpServletRequest req, HttpServletResponse resp) {

		Question question = new Question();

		String id = req.getParameter(Constants.STRING_QUSTION_ID).trim();
		question.setId(Integer.parseInt(id));
		question.setQuestion(req.getParameter(Constants.STRING_QUESTION));
		question.setType(type(req));

		 if (question.getType() != null) {
			 questionDAO.update(question);
			 
			 HttpSession session = req.getSession();
				try {
					session.setAttribute(Constants.MCQ_GET_UPDATE_ATTRIBUTE, question);
					resp.sendRedirect(Constants.REDIRECT_TO_UPDATE_MCQ);
					
				} catch (IOException e) {
					LOGGER.debug(Constants.REDIRECT_FAILED+ e);
				}
		 }
		
	}

	private List<Question> searchData(HttpServletRequest req, HttpServletResponse resp) {

		Question question = new Question();

		String id = req.getParameter(Constants.STRING_QUSTION_ID).trim();
		question.setQuestion(req.getParameter(Constants.STRING_QUESTION));
		question.setId(Integer.parseInt(id));
		question.setType(type(req));

		return questionDAO.search(question);
	}

	private void createData(HttpServletRequest req, HttpServletResponse resp) {

		Question question = new Question();

		question.setQuestion(req.getParameter(Constants.STRING_QUESTION));

		question.setType(type(req));

		if (question.getType() != null) {
			questionDAO.create(question);
			HttpSession session = req.getSession();
			try {
				session.setAttribute(Constants.MCQ_UNIQUE_GET_ATTRIBUTE, question);
				resp.sendRedirect(Constants.MCQ_PAGE);

				
			} catch (IOException e) {
				LOGGER.debug(Constants.REDIRECT_FAILED+ e);
			}
		}

	}

	private QuestionType type(HttpServletRequest req) {
		if (req.getParameter(Constants.QUESTION_TYPE).contains(Constants.QUESTION_TYPE_OPEN)) {
			return QuestionType.OPEN;
		} else if (req.getParameter(Constants.QUESTION_TYPE).contains(Constants.QUESTION_TYPE_MCQ)) {
			return QuestionType.MCQ;
		} else if (req.getParameter(Constants.QUESTION_TYPE).contains(Constants.QUESTION_TYPE_ASSOCIATIVE)) {
			return QuestionType.ASSOCIATIVE;
		}
		return null;
	}

}
