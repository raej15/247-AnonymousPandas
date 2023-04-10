import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserListTest {
    
    private UserList userList;

    @Before
    public void setUp() {
        userList = UserList.getInstance();
    }

    @Test
    public void testAddUser() {
        User newUser = new User("John", "Doe", "kennedy", "password");
        userList.addUser(newUser);
        assertTrue(userList.has("kennedy"));
    }

    @Test
    public void testGetUser() {
        User existingUser = new User("John", "Doe", "kennedy", "password");
        userList.addUser(existingUser);
        User retrievedUser = userList.getUser("kennedy");
        assertNotNull(retrievedUser);
        assertEquals("John", retrievedUser.getFirstName());
        assertEquals("Doe", retrievedUser.getLastName());
    }

    @Test
    public void testLoginSuccess() {
        User existingUser = new User("John", "Doe", "kennedy", "password");
        userList.addUser(existingUser);
        boolean result = userList.login(existingUser, "password");
        assertTrue(result);
    }

    @Test
    public void testLoginFailure() {
        User existingUser = new User("John", "Doe", "kennedy", "password");
        userList.addUser(existingUser);
        boolean result = userList.login(existingUser, "wrongpassword");
        assertFalse(result);
    }

    @Test
    public void testHasUser() {
        User existingUser = new User("John", "Doe", "kennedy", "password");
        userList.addUser(existingUser);
        assertTrue(userList.has("kennedy"));
        assertFalse(userList.has("kenneth"));
    }

    @Test
    public void testClearUsers() {
        User newUser = new User("Jane", "Doe", "kenneth", "password");
        userList.addUser(newUser);
        assertTrue(userList.has("kenneth"));
        userList.clear();
        assertFalse(userList.has("kenneth"));
    }

}