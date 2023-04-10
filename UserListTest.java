import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class UserListTest {
    private static LMSFacade facade = new LMSFacade();
    private User user1 = new Student("Kennedy1", "last", "email", "username1", "password");
    private User user2 = new Student("Kennedy2", "last", "email", "username2", "password");
    private User user3 = new Student("Kennedy3", "last", "email", "username3", "password");

   
    @BeforeEach
    public void setUp() {
        facade.getUserList().getUsers().clear();
        facade.getUserList().addUser(user1);
        facade.getUserList().addUser(user2);
        facade.getUserList().addUser(user3);
        assertEquals(3, UserList.getInstance().getUsers().size());
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
   public void userListSize(){
    
    assertEquals(3, facade.getUserList().getUsers().size());
   }


    @Test
    public void testHas() {
       
        assertEquals(true, facade.getUserList().has("username2"));
        assertFalse(facade.getUserList().has("username4"));
    }

    @Test
    public void testLogin() {
        assertTrue(facade.getUserList().login(user3, "password"));
        assertFalse(facade.getUserList().login(user1, "wrongpassword"));
    }

    @Test
    public void testPrintUsers() {
        facade.getUserList().getUsers().clear();
        facade.getUserList().getUsers().add(user1);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        facade.getUserList().printUsers();
        String expectedOutput = "First Name: Kennedy1\nLast Name: last\nemail: email\nUsername: username1\nPassword: password\n---------------\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testAddUser() {
        ArrayList<User> users = facade.getUserList().getUsers();
        assertEquals(3, users.size());
        assertTrue(users.contains(user1));
        assertTrue(users.contains(user2));
        assertTrue(users.contains(user3));
    }

}
 