import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataLoaderTest {

    //private ArrayList<User> users = DataLoader.loadUsers();
    //private ArrayList<Course> courses = DataLoader.loadCourses();
	private static LMSFacade facade = new LMSFacade();
	
	@BeforeEach
    @Test
	public void setup() {
		//users.clear();
		facade.getUserList().addUser(new Student("Kelly", "Finnegan", "finnegak@email.sc.edu", "finnegak", "kfinn999!"));
		DataWriter.saveUsers();
        assertEquals(1, facade.getUserList().getUsers().size());
	}

	@Test
	public void dataLoaderTest(){
		ArrayList <User> users = DataLoader.loadUsers();
		assertEquals(7, users.size());
	}
	

    
}
