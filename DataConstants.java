import java.util.UUID;

/*
 * Written by Anonmyous Pandas 
 */

public abstract class DataConstants{
    /**
     * Data Contants for users.json
     */    
    protected static final String USER_FILE_NAME = "json/users.json";
	protected static final String USER_ID = "userid";
	protected static final String USER_USER_NAME = "username";
    protected static final String USER_PASSWORD = "password";
	protected static final String USER_FIRST_NAME = "firstName";
	protected static final String USER_LAST_NAME = "lastName";
	protected static final String USER_EMAIL = "email";
    protected static final String USER_TYPE = "type";
    protected static final String CERTIFICATIONS = "certifications";

    /**
     * Data Contants for courses.json
     */
    protected static final String COURSE_FILE_NAME = "json/courses.json";
    protected static final String COURSE_AUTHOR = "author";
    protected static final String COURSE_NAME = "courseName";
    protected static final String COURSE_DESCRIPTION = "description";
    protected static final String COURSE_LANGUAGE = "language";
    protected static final String COURSE_MODULES = "modules";
    protected static final String COURSE_STUDENT = "students";
    protected static final String COURSE_STUDENT_ID = "id";
    protected static final String COURSE_STUDENT_GRADES = "grades";
    protected static final String COURSE_MODULE_NAME = "moduleName";
    protected static final String COURSE_LESSONS = "lessons";
    protected static final String COURSE_LESSON_NAME = "lessonName";
    protected static final String COURSE_LESSON_CONTENT = "content";
    protected static final String COURSE_MODULE_QUIZ = "quiz";
    protected static final String COURSE_QUIZ_QUESTIONS = "question";
    protected static final String COURSE_QUIZ_ANSWERS = "answers";
    protected static final String COURSE_QUIZ_CORRECT_INDEX = "correctIndex";
    protected static final String COURSE_COMMENTS = "comments";
    protected static final String COURSE_COMMENTS_USER = "user";
    protected static final String COURSE_COMMENTS_COMMENT = "comment";
    protected static final String COURSE_NESTED_COMMENTS = "nestedComments";
    protected static final String COURSE_NESTED_COMMENT = "nestedComment";
    protected static final String COURSE_MODULE_MODULE_COMMENTS = "moduleComments";
    protected static final String COURSE_COURSE_COMMENTS = "courseComments";
    protected static final String COURSE_FINAL_CERTIFICATION = "certification";
    protected static final String COURSE_FINAL_CERTIFICATION_PASSED = "passed";
    protected static final String COURSE_FINAL_CERTIFICATION_QUIZ = "certQuiz";
                                         
    protected static final String RESET = "\u001B[0m";
    protected static final String BLACK = "\u001B[30m";
    protected static final String RED = "\u001B[31m";
    protected static final String GREEN = "\u001B[32m";
    protected static final String BLUE = "\u001B[34m";
    protected static final String PURPLE = "\u001B[35m";
    protected static final String CYAN = "\u001B[36m";
    protected static final String BOLD = "\u001b[1m";

    protected static final String[] PROFILE = {"First Name","Last Name","Email","Username","Password","Type"};
    protected static final String WELCOME_MESSAGE = "Welcome to our Learning Managment System";
    protected static final String[] MAIN_MENU_CREATOR = {"Profile","List Courses","Create Course","Logout"};
    protected static final String[] MAIN_MENU_STUDENT = {"Profile","Register For a Course","Check Grades", "Take Certification Exam","Logout"};
	protected static final String[] MAIN_MENU = {"Login","Create Account", "Exit"};
    
}
