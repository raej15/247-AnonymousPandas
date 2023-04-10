import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.Test;
/**
 * Tested by Kelly Finnegan
 */
public class DataLoaderTest {

	private static LMSFacade facade = new LMSFacade();
	private ArrayList <User> users = DataLoader.loadUsers();
	private ArrayList<Course> courses = DataLoader.loadCourses();
	
	// USERS.JSON

	@Test
	public void dataLoaderTest(){
		assertEquals(9, users.size());
	}

	@Test
	public void addOneUser() {
		facade.getUserList().addUser(new Student("Kelly", "Finnegan", "finnegak@email.sc.edu", "finnegak", "kfinn999!"));
		DataWriter.saveUsers();
		DataLoader.loadUsers();
        assertEquals(1, facade.getUserList().getUsers().size());
	}

	@Test
	public void zeroUsers(){ // users.json is loaded empty
		assertEquals(0, facade.getUserList().getUsers().size());
	}

	@Test
	public void getUsernameTest(){
		assertEquals("trey12", users.get(0).getUserName());
	}

	@Test
	public void getPasswordTest(){
		assertEquals("treyWhite12", users.get(0).getPassword());
	}

	@Test
	public void getFirstNameTest(){
		assertEquals("Trey", users.get(0).getFirstName());
	}

	@Test
	public void getLastNameTest(){
		assertEquals("White", users.get(0).getLastName());
	}

	@Test
	public void getTypeTest(){
		assertEquals(1, users.get(0).getType());
	}

	@Test
	public void getEmailTest(){
		assertEquals("twhite@gmail.com", users.get(0).getEmail());
	}

	@Test
	public void getCertifications0Test(){
		assertEquals(0, ((Student) users.get(0)).getCertifications().size());
	}

	@Test
	public void getCertifications1Test(){
		assertEquals(1, ((Student) users.get(8)).getCertifications().size());
	}

	@Test
	public void getUserIDTest(){
		assertEquals("87410238-bbc8-4bd0-813b-9c04c25bc8e1", users.get(0).getUUID().toString());
	}

	// COURSES.JSON
	@Test
	public void getCourseListSizeTest(){
		assertEquals(2, courses.size());
	}

	@Test
	public void getCourseNameTest(){
		assertEquals("Introduction to JavaScript", courses.get(0).getCourseName());
	}

	@Test
	public void getCourseDescriptionTest(){
		assertEquals("JavaScript is a scripting language for creating dynamic web page content.", courses.get(0).getDescription());
	}

	@Test
	public void getCourseLanguageTest(){
		assertEquals("JavaScript", courses.get(0).getLanguage().toString());
	}

	// Course Comments
	@Test
	public void getCourseCommentsSizeTest(){
		int size = courses.get(0).getCourseComments().size();
		assertEquals(2, size);
	}

	@Test
	public void getCourseCommentsCommentTest(){
		String comment = courses.get(0).getCourseComments().get(0).getComment();
		assertEquals("Who uses JavaScript?", comment);
	}

	@Test
	public void getCourseCommentsUserTest(){
		String commenter = courses.get(0).getCourseComments().get(0).getCommenter().toString();
		assertEquals("1f9f3f3c-fead-4c41-b2ac-98aa2fd9ad58",commenter);
	}

	@Test
	public void getCourseCommentsNestedCommentsSizeTest(){
		int size = courses.get(0).getCourseComments().get(0).getComments().size();
		assertEquals(3, size);
	}

	 @Test
	public void getCourseCommentsNestedCommentTest(){
		String comment = courses.get(0).getCourseComments().get(0).getComments().get(0).getComment();
		assertEquals("Front end developers use JavaScript to add behavior to webpages.", comment);
	}

	@Test
	public void getCourseCommentsNestedCommenterTest(){
		String commenter = courses.get(0).getCourseComments().get(0).getComments().get(0).getCommenter().toString();
		assertEquals("87410238-bbc8-4bd0-813b-9c04c25bc8e1",commenter);
	}

	@Test
	public void getCourseCommentsNestedNestedCommentsSizeTest(){
		int num = courses.get(0).getCourseComments().get(0).getComments().get(0).getComments().size();
		assertEquals(0, num);
	}

	@Test
	public void getCourseAuthorTest(){
		assertEquals("51dc7b49-b0a3-4a04-a3d0-4781d1efbedf", courses.get(0).getAuthorID().toString());
	}

    @Test
	public void getStudentIdTest(){
		String id = courses.get(0).getStudents().get(0).toString();
		assertEquals("41cacde1-48d5-4374-9119-4121510741f5", id);
	}

	@Test
	public void getStudentGradeTest(){
		UUID uuid = courses.get(0).getStudents().get(0);
		double grade = courses.get(0).getGrades().get(uuid).get(0);
		assertEquals(65, grade);
	}

	// Module Quiz
	@Test
	public void getQuizQuestionTest(){
		String question = courses.get(0).getModules().get(0).getQuiz().getQuestions().get(0).getQuestion();
		assertEquals("How is a string formatted?", question);
	}

	@Test
	public void getQuizACsize(){
		int size = courses.get(0).getModules().get(0).getQuiz().getQuestions().get(0).getAnswers().size();
		assertEquals(3, size);
	}

	@Test
	public void getQuizAnswerTest(){
		String answer = courses.get(0).getModules().get(0).getQuiz().getQuestions().get(0).getAnswers().get(0);
		assertEquals("var strName = 'apple'", answer);
	}

	@Test
	public void getQuizAnswerChoiceTest(){
		int correctIndex = courses.get(0).getModules().get(0).getQuiz().getQuestions().get(0).getCorrectIndex();
		assertEquals(1, correctIndex);
	}

	// Module
	@Test
	public void getModuleNameTest(){
		String name = courses.get(0).getModules().get(0).getModuleName();
		assertEquals("Variables",name);
	}

	// Module Commens
	@Test
	public void getModuleCommentsSize(){
		int size = courses.get(0).getModules().get(0).getComments().size();
		assertEquals(2, size);
	}
	@Test
	public void getModuleCommentsCommentTest(){
		String comment = courses.get(0).getModules().get(0).getComments().get(0).getComment();
		assertEquals("How do you multiply two variables?", comment);
	}

	@Test
	public void getModuleCommentsUserTest(){
		String commenter = courses.get(0).getModules().get(0).getComments().get(0).getCommenter().toString();
		assertEquals("1f9f3f3c-fead-4c41-b2ac-98aa2fd9ad58",commenter);
	}

	@Test
	public void getModuleCommentsNestedCommentsSize(){
		int size = courses.get(0).getModules().get(0).getComments().get(0).getComments().size();
		assertEquals(2, size);
	}

	 @Test
	public void getModuleCommentsNestedCommentTest(){
		String comment = courses.get(0).getModules().get(0).getComments().get(0).getComments().get(0).getComment();
		assertEquals("You create two variables that are type number (no quotes) and initialize their values. Then use the variable names to multiply using the asterisk symbol.", comment);
	}

	@Test
	public void getModuleCommentsNestedCommenterTest(){
		String commenter = courses.get(0).getModules().get(0).getComments().get(0).getComments().get(0).getCommenter().toString();
		assertEquals("87410238-bbc8-4bd0-813b-9c04c25bc8e1",commenter);
	}

	@Test
	public void getModuleCommentsNestedNestedCommentsSizeTest(){
		int num = courses.get(0).getModules().get(0).getComments().get(0).getComments().get(0).getComments().size();
		assertEquals(0, num);
	}

	// Module Lessons
	@Test
	public void getLessonsSize(){
		int size = courses.get(0).getModules().get(0).getLessons().size();
		assertEquals(3, size);
	}

	@Test
	 public void getLessonNameTest(){
		String name = courses.get(0).getModules().get(0).getLessons().get(0).getLessonName();
		assertEquals("Strings", name);
	}

	@Test
	 public void getLessonContentTest(){
		String content = courses.get(0).getModules().get(0).getLessons().get(0).getContent();
		assertEquals("One way to use a variable is to hold text. You use key word 'var' to do this. Ex: var color = 'blue'.", content);
	}

	// Course Final Certification
	@Test
	public void getCertQuizSizeTest(){
		int size = courses.get(0).getCertificate().getQuiz().getQuestions().size();
		assertEquals(2, size);
	}

	@Test
	public void getCertQuizQuestionTest(){
		String question = courses.get(0).getCertificate().getQuiz().getQuestions().get(0).getQuestion();
		assertEquals("What is the relationship between JavaScript and HTML?", question);
	}

	@Test
	public void getCertQuizQuestionACsizeTest(){
		int size = courses.get(0).getCertificate().getQuiz().getQuestions().get(0).getAnswers().size();
		assertEquals(3, size);
	}

	@Test
	public void getCertQuizQuestionACTest(){
		String choice = courses.get(0).getCertificate().getQuiz().getQuestions().get(0).getAnswers().get(0);
		assertEquals("HTML is for logic and is used with JavaScript to make a website.", choice);
	}

	@Test
	public void getCertQuizQuestionCorrectIndexTest(){
		int correctIndex = courses.get(0).getCertificate().getQuiz().getQuestions().get(0).getCorrectIndex();
		assertEquals(3, correctIndex);
	}

	@Test
	public void nullFirstNameTest(){
		assertEquals(null, users.get(0).getUserName());
		assertEquals(null, users.get(0).getPassword());
		assertEquals(null, users.get(0).getFirstName());
		assertEquals(null, users.get(0).getEmail());
		assertEquals(null, users.get(0).getUUID());
		assertEquals(null, users.get(0).getLastName());
	}

	@Test
	public void nullLastNameTest(){
		assertEquals("Kelly", users.get(0).getUserName());
		assertEquals(null, users.get(0).getPassword());
		assertEquals(null, users.get(0).getFirstName());
		assertEquals(null, users.get(0).getEmail());
		assertEquals(null, users.get(0).getUUID());
		assertEquals(null, users.get(0).getLastName());
	}

	@Test
	public void nullCourseName(){
		assertEquals(null, courses.get(0).getCourseName());
	}

}
