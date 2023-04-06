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
		DataLoader.loadUsers();
		assertEquals(0, facade.getUserList().getUsers().size());
	}
    
}
