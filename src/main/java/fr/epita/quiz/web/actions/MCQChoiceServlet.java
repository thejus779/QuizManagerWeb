/**
 * 
 */
package fr.epita.quiz.web.actions;

import java.io.IOException;
import java.util.HashMap;
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

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.MCQChoiceDAO;
import fr.epita.quiz.services.QuestionDAO;
import fr.epita.quiz.web.constants.Constants;

/**
 * @author shine
 *
 */
@WebServlet(urlPatterns = { "/mcqCreate", "/mcqSearch", "/mcqUpdate", "/mcqDelete", "/redirectToUpdateMCQ",
		"/redirectToMCQ", "/viewMcq", "/takeTest" })
public class MCQChoiceServlet extends SpringServlet {

	private static final long serialVersionUID = -7851615693917357921L;

	private static final Logger LOGGER = LogManager.getLogger(LoginServlet.class);

	@Inject
	MCQChoiceDAO mcqDAO;

	@Inject
	QuestionDAO questionDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getRequestURI().contains(Constants.REDIRECT_TO_UPDATE_MCQ)) {
			HttpSession session = req.getSession();
			Question question = (Question) session.getAttribute(Constants.MCQ_GET_UPDATE_ATTRIBUTE);

			req.setAttribute(Constants.MCQ_UNIQUE_SET_ATTRIBUTE, mcqDAO.fetchAllMCQChoices(question));

			RequestDispatcher rd = getServletContext().getRequestDispatcher(Constants.UPDATE_QUIZ_PAGE);

			try {
				rd.forward(req, resp);
			} catch (IOException e) {
				LOGGER.debug(Constants.FORWARD_FAILED + e);
			}

		}

		else if (req.getRequestURI().contains(Constants.DISPLAY_MCQ_PAGE)) {

			HttpSession session = req.getSession();

			Question question = (Question) session.getAttribute(Constants.MCQ_DISPLAY_UNIQUE_SET_ATTRIBUTE);

			req.setAttribute(Constants.QUESTION_UNIQUE_SET_ATTRIBUTE, question);
			req.setAttribute(Constants.MCQ_CHOICE_UNIQUE_SET_ATTRIBUTE, mcqDAO.fetchAllMCQChoices(question));

			RequestDispatcher rd = getServletContext().getRequestDispatcher(Constants.DISPLAY_QUESTION_PAGE);

			try {
				rd.forward(req, resp);
			} catch (IOException e) {
				LOGGER.debug(Constants.FORWARD_FAILED + e);
			}

		} else if (req.getRequestURI().contains(Constants.DISPLAY_TAKE_TEST)) {

			List<Question> totalList = questionDAO.fetchAllQuestions();
			
			HashMap<Question,List<MCQChoice>> map = new HashMap<>();
			
			for(Question question : totalList) {
				map.put(question,mcqDAO.fetchAllMCQChoices(question));			
			}
			req.setAttribute(Constants.MCQ_TEST_UNIQUE_SET_ATTRIBUTE,map);

			RequestDispatcher rd = getServletContext().getRequestDispatcher(Constants.DISPLAY_QUESTION_PAGE);

			try {
				rd.forward(req, resp);
			} catch (IOException e) {
				LOGGER.debug(Constants.FORWARD_FAILED + e);
			}

		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if ((req.getRequestURL() + "").contains(Constants.CREATE_MCQ_OPTIONS_KEY)) {
			createMCQChoice(req, resp);
		} else if ((req.getRequestURL() + "").contains(Constants.SEARCH_MCQ_OPTIONS_KEY)) {
			searchMCQChoice(req, resp);
		} else if ((req.getRequestURL() + "").contains(Constants.UPDATE_MCQ_OPTIONS_KEY)) {
			updateMCQChoice(req, resp);
		} else if ((req.getRequestURL() + "").contains(Constants.DELETE_MCQ_OPTIONS_KEY)) {
			deleteMCQChoice(req, resp);
		}
	}

	private void deleteMCQChoice(HttpServletRequest req, HttpServletResponse resp) {

		MCQChoice choice = new MCQChoice();
		choice.setChoice(req.getParameter(Constants.MCQ_CHOICES_STRING));
		choice.setOrder(Integer.valueOf(req.getParameter(Constants.MCQ_ORDER)));

		mcqDAO.delete(choice);

	}

	private void updateMCQChoice(HttpServletRequest req, HttpServletResponse resp) {
		MCQChoice choice = new MCQChoice();
		choice.setChoice(req.getParameter(Constants.MCQ_CHOICES_STRING));
		choice.setOrder(Integer.valueOf(req.getParameter(Constants.MCQ_ORDER)));

		List<MCQChoice> mcqList = mcqDAO.search(choice);

		MCQChoice fetchedMCQ = mcqList.get(0);

		if (!fetchedMCQ.getChoice().equalsIgnoreCase(req.getParameter(Constants.MCQ_CHOICES_STRING))
				|| fetchedMCQ.getOrder() != (Integer.valueOf(req.getParameter(Constants.MCQ_ORDER)))
				|| (fetchedMCQ
						.isValid() == (req.getParameter(Constants.MCQ_CHOICES_VALID).equalsIgnoreCase("true") ? true
								: false))) {

			choice.setChoice(req.getParameter(Constants.MCQ_CHOICES_STRING));
			choice.setOrder(Integer.valueOf(req.getParameter(Constants.MCQ_ORDER)));

			mcqDAO.update(choice);
		}
	}

	private void searchMCQChoice(HttpServletRequest req, HttpServletResponse resp) {

		MCQChoice choice = new MCQChoice();
		choice.setChoice(req.getParameter(Constants.MCQ_CHOICES_STRING));
		choice.setOrder(Integer.valueOf(req.getParameter(Constants.MCQ_ORDER)));

		mcqDAO.search(choice);
	}

	private void createMCQChoice(HttpServletRequest req, HttpServletResponse resp) {

		MCQChoice choice = null;
		HttpSession session = req.getSession();

		String[] arrayOptions = req.getParameterValues(Constants.MCQ_CHOICES_STRING);
		String[] arrayValid = req.getParameterValues(Constants.MCQ_VALID);

		Question question = (Question) session.getAttribute(Constants.MCQ_UNIQUE_GET_ATTRIBUTE);

		for (int i = 0; i < arrayOptions.length; i++) {

			if (!arrayOptions[i].isEmpty() && (!arrayValid[i].isEmpty())) {

				choice = new MCQChoice();
				choice.setChoice(arrayOptions[i]);
				choice.setOrder(1);
				choice.setValid(validOption(arrayValid[i]));
				choice.setQuestion(question);
				mcqDAO.create(choice);

			} else {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/" + Constants.MCQ_PAGE);

				try {
					rd.forward(req, resp);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				LOGGER.debug("Create mcq choices failed");
			}
		}

		try {
			for (int i = 0; i < arrayOptions.length; i++) {
				if (arrayOptions[i] != null && !arrayOptions[i].isEmpty()) {
					resp.sendRedirect(Constants.REDIRECT_HOME);
					break;
				}
			}
		} catch (IOException e) {
			LOGGER.debug(Constants.REDIRECT_FAILED + e);
		}

	}

	private boolean validOption(String valid) {

		if (valid.contains(Constants.MCQ_CHOICES_VALID)) {
			return true;
		}
		return false;
	}

}
