import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataLoaderTest {

    //private ArrayList<User> users = DataLoader.loadUsers();
    //private ArrayList<Course> courses = DataLoader.loadCourses();
	private static LMSFacade facade = new LMSFacade();
	

	@Test
	public void dataLoaderTest(){
		ArrayList <User> users = DataLoader.loadUsers();
		assertEquals(9, users.size());
	}

	@Test
	public void setup() {
		facade.getUserList().addUser(new Student("Kelly", "Finnegan", "finnegak@email.sc.edu", "finnegak", "kfinn999!"));
		DataWriter.saveUsers();
        assertEquals(1, facade.getUserList().getUsers().size());
	}
	

    
}
