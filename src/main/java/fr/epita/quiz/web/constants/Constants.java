package fr.epita.quiz.web.constants;

public class Constants {
	/** The constant for login */
	public static final String LOGIN = "login";

	/** The constant for email */
	public static final String GET_PARAMETER_UNAME = "username";

	/** The constant for database driver */
	public static final String GET_PARAMETER_PAWD = "pass";
	
	/** The constant for mcqOption fetch from post */
	public static final String GET_PARAMETER_CNF_PAWD = "confpass";
	
	/** The constant for get user type */
	public static final String GET_PARAMETER_USER_TYPE = "user_type";
	
	/** The constant login url patter match */
	public static final String URL_LOGIN = "login";
	
	
	/** The constant  pattern to redirect to MCQ page */
	public static final String MCQ_PAGE ="mcq.html";	
	
	/** The constant  pattern to redirect to Home */
	public static final String REDIRECT_TO_UPDATE_MCQ ="redirectToUpdateMCQ";
	
	/** The constant  pattern to redirect to Home */
	public static final String REDIRECT_HOME ="redirectToHome";

	/** The constant  pattern to redirect to Home JSP */
	public static final String HOME_PAGE = "/home.jsp";

	/** The constant  pattern to redirect to display MCQ */
	public static final String DISPLAY_MCQ_PAGE = "viewMcq";

	/** The constant  pattern to redirect to display MCQ */
	public static final String DISPLAY_TAKE_TEST = "takeTest";
	

	/** The constant  pattern to redirect to update question page */
	public static final String UPDATE_QST_PAGE = "/updateqst.jsp";
	
	/** The constant  pattern to redirect to create question */
	public static final String CREATE_QST_PAGE = "/createNew";

	/** The constant  pattern to redirect to questions page */
	public static final String QUESTIONS_PAGE = "questions.html";
	
	/** The constant for email */
	public static final String EMAIL = "email";

	/** The constant for database driver */
	public static final String DRIVER = "DRIVER";
	
	/** The constant to fetch mcq chpoices post */
	public static final String MCQ_CHOICES_STRING = "mcqOption";
	
	/** The constant to fetch mcq chpoices post */
	public static final String MCQ_CHOICES_VALID = "valid";
	
	/** The constant for mcq Order fetch from post */
	public static final String MCQ_ORDER = "order";
	
	/** The constant for mcq Valid response fetch from post */
	public static final String MCQ_VALID = "valid";
	
	/** The constant for question string fetch from post */
	public static final String STRING_QUESTION = "questionString";
	
	/** The constant for unique mcq get attribute */
	public static final String MCQ_UNIQUE_GET_ATTRIBUTE = "unique_mcq_get_parameter";
	
	
	/** The constant for unique question list set attribute */
	public static final String QUESTIN_LIST_UNIQUE_SET_ATTRIBUTE = "test_attribute";
	
	/** The constant for unique question list set attribute */
	public static final String NUMBER_OF_PAGES = "noOfPages";
	
	/** The constant for unique question list set attribute */
	public static final String CURRENT_PAGE = "currentPage";
	
	/** The constant for unique mcq get attribute */
	public static final String MCQ_UNIQUE_SET_ATTRIBUTE = "mcq_update_attribute";

	/** The constant for unique mcq get attribute */
	public static final String QUESTION_UNIQUE_SET_ATTRIBUTE = "test_attribute_question";
	
	/** The constant for unique mcq get attribute */
	public static final String QUESTION_UPDATE_UNIQUE_SET_ATTRIBUTE = "test_attribute_update_question";
	
	/** The constant for unique mcq get attribute */
	public static final String MCQ_CHOICE_UNIQUE_SET_ATTRIBUTE = "test_attribute_choices";
	
	/** The constant for unique map to display the quiz  */
	public static final String MCQ_TEST_UNIQUE_SET_ATTRIBUTE = "test_attribute_choices";
	
	/** The constant for url to update quiz page */
	public static final String UPDATE_QUIZ_PAGE = "/updatemcq.jsp";
	
	/** The constant for url to update quiz page */
	public static final String DISPLAY_QUESTION_PAGE = "/viewquestion.jsp";
	
	
	
	/** The constant for unique set attribute for display mcq choices */
	public static final String MCQ_DISPLAY_UNIQUE_SET_ATTRIBUTE = "unique_mcq_get_parameter_view";	
	
	
	/** The constant for question string fetch from post */
	public static final String MCQ_GET_UPDATE_ATTRIBUTE = "unique_update_mcq_get_parameter";
	
	/** The constant for mcqOption fetch from post */
	public static final String QUESTION_TYPE = "type";
	
	/** The constant for question Id */
	public static final String STRING_QUSTION_ID = "questionId";
	
	/** The constant for user type as student */
	public static final String USER_TYPE_STUDENT = "STUDENT";
	
	/** The constant for user type as quiz master */
	public static final String USER_TYPE_QUIZMASTER = "QUIZMASTER";
	
	/** The constant for mcqOption fetch from post */
	public static final String QUESTION_TYPE_MCQ = "MCQ";
	
	/** The constant for mcqOption fetch from post */
	public static final String QUESTION_TYPE_OPEN = "OPEN";
	
	/** The constant for mcqOption fetch from post */
	public static final String QUESTION_TYPE_ASSOCIATIVE = "ASSOCIATIVE";

	/** The constant for user */
	public static final String DB_USER = "USER";	

	/** The constant for database URL */
	public static final String DB_URL = "URL";

	/** The constant for the create operation */
	public static final String CREATE_OPERATION = "create";

	/** The constant for the search question operation */
	public static final String SEARCH_QUESTION_OPERATION = "search";
	
	/** The constant for the search by string token */
	public static final String SEARCH_OPERATION_STRING = "searchByString";
	
	/** The constant for search by string parameter */
	public static final String SEARCH_BY_STRING_PARAMETER = "search_parameter";
	
	
	/** The constant for the read operation */
	public static final String DISPLAY_QUESTION = "view";

	/** The constant for the update operation */
	public static final String UPDATE_QUESTION_OPERATION = "updateQuestion";
	
	/** The constant for the general update operation */
	public static final String UPDATE_QUESTION_OPERATION_GENERAL = "update";

	/** The constant for the delete operation */
	public static final String DELETE_QUESTION_OPERATION = "delete";
	
	/** The constant for the create mcq peration */
	public static final String CREATE_MCQ_OPTIONS_KEY = "mcqCreate";

	/** The constant for the search mcq operation */
	public static final String SEARCH_MCQ_OPTIONS_KEY = "mcqSearch";

	/** The constant for the update mcq operation */
	public static final String UPDATE_MCQ_OPTIONS_KEY = "mcqUpdate";

	/** The constant for the delete mcq operation */
	public static final String DELETE_MCQ_OPTIONS_KEY = "mcqDelete";
	

	/** The constant for the space */
	public static final String SPACE = " ";

	/**The constant for the comma */
	public static final String COMMA = ",";
	
	/** The constant for the exception */
	public static final String EXCEPTION = "EXCEPTION";
	
	/** The constant for the conf */
	public static final String CONF = "conf";
	
	/** The constant for the display name database coloumn */
	public static final String DISPLAY_NAME_DB_COLOUMN="DISPLAY_NAME";
	
	/** The constant for the uid database coloumn */
	public static final String UID_DB_COLOUMN="UID";
	
	/** The constant for the email database coloumn */
	public static final String EMAIL_DB_COLOUMN="EMAIL";
	
	/** The constant for the success page used in the controller */
	public static final String SUCCESSPAGE="adminpage.html";
	
	/** The constant for the error page used in the controller */
	public static final String ERRORPAGE="errorPage";

	/** The constant for the create new admin operation*/
	public static final String CREATE_LOGIN = "createAdmin";

	/** The constant for the confirm login password field **/
	public static final String CONFIRM_LOGIN_PASSWORD = "confirmLogin";

	/** The constant for the confirm login password field **/
	public static final String REDIRECT_FAILED = "Redirect failed with exception";
	
	/** The constant for the confirm login password field **/
	public static final String FORWARD_FAILED = "Forward failed with exception";
	
	
	
	private Constants() {
	}
}
