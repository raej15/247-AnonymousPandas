import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataLoaderTest {

	private static LMSFacade facade = new LMSFacade();
	ArrayList <User> users = DataLoader.loadUsers();
	private ArrayList<Course> courses = DataLoader.loadCourses();
	
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
	public void zeroUsers(){
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
	 public void getCourseCommentsNestedCommentTest(){
		String comment = courses.get(0).getCourseComments().get(0).getComments().get(0).getComment();
		assertEquals("Front end developers use JavaScript to add behavior to webpages.", comment);
	 }

	 @Test
	 public void getCourseCommentsNestedCommenterTest(){
		String commenter = courses.get(0).getCourseComments().get(0).getComments().get(0).getCommenter().toString();
		assertEquals("87410238-bbc8-4bd0-813b-9c04c25bc8e1",commenter);
	 }
    
}
