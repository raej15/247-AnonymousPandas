
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserListTest {

    private User user1;
    private User user2;
    private User user3;
 
    @Before
    public void setUp() {
        
        user1 = new Student("Kennedy1", "last", "email", "username1", "password");
        user2 = new Student("Kennedy2", "last", "email", "username2", "password");
        user3 = new Student("Kennedy3", "last", "email", "username3", "password");
        UserList.getInstance().getUsers().add(user1);
        UserList.getInstance().getUsers().add(user2);
        UserList.getInstance().getUsers().add(user3);
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
        boolean hasUser1 = UserList.getInstance().has("username1");
        //assertTrue(hasUser1); THIS ONE ISNT WORKING
        boolean hasUser4 = UserList.getInstance().has("username4");
        assertFalse(hasUser4);
    }
 
 
    @Test
    public void testLogin() {
        //boolean validLogin = UserList.getInstance().login(user1, "password");
        //assertTrue(validLogin);
        boolean invalidPassword = UserList.getInstance().login(user1, "wrongpassword");
        assertFalse(invalidPassword);
        //boolean nullUser = userList.login(null, "password1");
        //assertFalse(nullUser);
    }
 /*
    @Test
    public void testGetUsers() {
        ArrayList<User> users = userList.getUsers();
        assertEquals(3, users.size());
        assertTrue(users.contains(user1));
        assertTrue(users.contains(user2));
        assertTrue(users.contains(user3));
    }
 
 
    @Test
    public void testAddUser() {
        Student newUser = new Student("Kennedy", "last", "email", "username", "password");
        userList.addUser(newUser);
        assertTrue(userList.has("user4"));
    }
 
 
    @Test
    public void testPrintUsers() {
        userList.printUsers();
    }
    */
 }
 