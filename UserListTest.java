import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserListTest{
    private UserList userList = UserList.getInstance();
    private ArrayList<User> users = userList.getUsers();

    @BeforeEach
    @Test
    public void setUp() {
       // users.clear();
        userList.add(new User("Trey", "White", "twhite@gmail.com", "trey12", "treyWhite12"));
        DataWriter.saveUsers();
    }
}
