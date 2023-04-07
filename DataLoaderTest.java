import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataLoaderTest {

	private static LMSFacade facade = new LMSFacade();
	
	@Test
	public void dataLoaderTest(){
		ArrayList <User> users = DataLoader.loadUsers();
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
		DataLoader.loadUsers(); // users.json empty
		assertEquals(0, facade.getUserList().getUsers().size());
	}

	@Test
	public void getUsernameTest(){
		ArrayList <User> users = DataLoader.loadUsers();
		assertEquals("trey12", users.get(0).getUserName());
	}

	@Test
	public void getPasswordTest(){
		ArrayList <User> users = DataLoader.loadUsers();
		assertEquals("treyWhite12", users.get(0).getPassword());
	}

	@Test
	public void getFirstNameTest(){
		ArrayList <User> users = DataLoader.loadUsers();
		assertEquals("Trey", users.get(0).getFirstName());
	}

	@Test
	public void getLastNameTest(){
		ArrayList <User> users = DataLoader.loadUsers();
		assertEquals("White", users.get(0).getLastName());
	}

	@Test
	public void getTypeTest(){
		ArrayList <User> users = DataLoader.loadUsers();
		assertEquals(1, users.get(0).getType());
	}

	@Test
	public void getEmailTest(){
		ArrayList <User> users = DataLoader.loadUsers();
		assertEquals("twhite@gmail.com", users.get(0).getEmail());
	}

	@Test
	public void getCertifications0(){
		ArrayList <User> users = DataLoader.loadUsers();
		assertEquals(0, ((Student) users.get(0)).getCertifications().size());
	}

	@Test
	public void getCertifications1(){
		ArrayList <User> users = DataLoader.loadUsers();
		assertEquals(1, ((Student) users.get(8)).getCertifications().size());
	}

	@Test
	public void getUserID(){
		ArrayList <User> users = DataLoader.loadUsers();
		assertEquals("87410238-bbc8-4bd0-813b-9c04c25bc8e1", users.get(0).getUUID().toString());
	}

	@Test
	public void getCourseListSize(){
		ArrayList<Course> courses = DataLoader.loadCourses();
		assertEquals(2, courses.size());
	}

	
    
}
