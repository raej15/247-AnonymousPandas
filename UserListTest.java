
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserListTest {

    private UserList userList;
    private User user1;
    private User user2;
    private User user3;

    @Before
    public void setUp() {
        userList = UserList.getInstance();
        user1 = new User("user1", "password1");
        user2 = new User("user2", "password2");
        user3 = new User("user3", "password3");
    }

    @Test
    public void testGetInstance() {
        UserList instance = UserList.getInstance();
        assertNotNull(instance);
    }
 
    @Test
   public void testGetUser() {
       User foundUser = UserList.getInstance().getUser("username1");
       assertEquals(user1, foundUser);
       User notFoundUser = UserList.getInstance().getUser("username4");
       assertNull(notFoundUser);
   }


    @Test
    public void testHas() {
        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);

        assertTrue(userList.has("user2"));
        assertFalse(userList.has("user4"));
    }

    @Test
    public void testLogin() {
        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);

        assertTrue(userList.login(user3, "password3"));
        assertFalse(userList.login(user1, "wrongpassword"));
    }

    @Test
    public void testPrintUsers() {
        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        userList.printUsers();
        String expectedOutput = "User [userName=user1, password=password1]\n---------------\n" +
                                "User [userName=user2, password=password2]\n---------------\n" +
                                "User [userName=user3, password=password3]\n---------------\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testAddUser() {
        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);

        ArrayList<User> users = userList.getUsers();
        assertEquals(3, users.size());
        assertTrue(users.contains(user1));
        assertTrue(users.contains(user2));
        assertTrue(users.contains(user3));
    }

}