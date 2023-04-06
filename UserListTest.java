import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserListTest{
    private UserList userList = UserList.getInstance();
    private ArrayList<User> users = new ArrayList<User>();

    @BeforeEach
    public void setUp() {
        users.clear();
        DataWriter.saveUsers();
    }

    @AfterEach
    public void tearDown() {
        DataWriter.saveUsers();
    }

    @Test
    public void testgetUser(){
        assertTrue(true);
}

    @Test
    public void test(){
        assertTrue(true); 
    }
}
