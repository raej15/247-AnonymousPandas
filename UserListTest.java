import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserListTest{
    private UserList userList;
    private User user1;
    private User user2;
    private User user3;

    @Before
    public void setUp() {
        userList = new UserList();
        user1 = new User("user1", "password1");
        user2 = new User("user2", "password2");
        user3 = new User("user3", "password3");
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        UserList.setUserList(users);
    }

    @Test
    public void testGetInstance() {
        UserList instance = UserList.getInstance();
        Assert.assertNotNull(instance);
    }

    @Test
    public void testGetUser() {
        User foundUser = userList.getUser("user1");
        Assert.assertEquals(user1, foundUser);
        User notFoundUser = userList.getUser("user4");
        Assert.assertNull(notFoundUser);
    }

    @Test
    public void testHas() {
        boolean hasUser1 = userList.has("user1");
        Assert.assertTrue(hasUser1);
        boolean hasUser4 = userList.has("user4");
        Assert.assertFalse(hasUser4);
    }

    @Test
    public void testLogin() {
        boolean validLogin = userList.login(user1, "password1");
        Assert.assertTrue(validLogin);
        boolean invalidPassword = userList.login(user1, "wrongpassword");
        Assert.assertFalse(invalidPassword);
        boolean nullUser = userList.login(null, "password1");
        Assert.assertFalse(nullUser);
    }

    @Test
    public void testGetUsers() {
        ArrayList<User> users = userList.getUsers();
        Assert.assertEquals(3, users.size());
        Assert.assertTrue(users.contains(user1));
        Assert.assertTrue(users.contains(user2));
        Assert.assertTrue(users.contains(user3));
    }

    @Test
    public void testAddUser() {
        User newUser = new User("user4", "password4");
        userList.addUser(newUser);
        Assert.assertTrue(userList.has("user4"));
    }

    @Test
    public void testPrintUsers() {
        userList.printUsers();
    }

}