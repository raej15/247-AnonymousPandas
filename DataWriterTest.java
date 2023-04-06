import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
    private UserList users = UserList.getInstance();
    private ArrayList<User> userList = users.getUsers();

    @BeforeEach
	public void setup() {
		UserList.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}
	
	@AfterEach
	public void tearDown() {
		UserList.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}

    @Test
    public void testWritingOneUser(){
        userList.add(new User("Trey","White","twhite@gmail.com","trey12","treyWhite12"));
        DataWriter.saveUsers();
        assertEquals()
    }

}