import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
//import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
    //private UserList userList = UserList.getInstance();
    private ArrayList<User> users = DataLoader.loadUsers(); // this needs to hold the users.json with all the users
    //private CourseList coursesList = CourseList.getInstance();
    //private ArrayList<Course> courses = CourseList.getInstance().getCourses();

    //@BeforeEach
    //@Test
	public void setup() {
		UserList.getInstance().getUsers().clear();
		DataWriter.saveUsers();
        //CourseList.getInstance().getCourses().clear();
        //DataWriter.saveCourses();
	}
	
	//@AfterEach
    //@Test
	public void tearDown() {
		UserList.getInstance().getUsers().clear();
		DataWriter.saveUsers();
        CourseList.getInstance().getCourses().clear();
        DataWriter.saveCourses();
	}

    @Test
    public void testWritingZeroUsers(){
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
        assertEquals(0, UserList.getInstance().getUsers().size());
    }

    @Test
    public void testWritingUserName(){
        UserList.setUserList(users);
        DataWriter.saveUsers();
        ArrayList <User> writtenUsers = DataLoader.loadUsers();
        assertEquals("trey12", writtenUsers.get(0).getUserName());
    }

    @Test
    public void testWritingOneUser(){
        Student newStudent = new Student("first", "last", "email", "username", "password");
        users.add(newStudent);
        UserList.setUserList(users);
        DataWriter.saveUsers();
        ArrayList <User> writtenUsers = DataLoader.loadUsers();
        assertEquals("username", writtenUsers.get(writtenUsers.size()-1).getUserName());
    }

    @Test
    public void testWritingNullUser(){
        Student newStudent = new Student("first", "last", "email", null , "password");
        users.add(newStudent);
        UserList.setUserList(users);
        DataWriter.saveUsers();
        ArrayList <User> writtenUsers = DataLoader.loadUsers();
        assertEquals(null, writtenUsers.get(users.size()-1).getUserName());
    }

    @Test
    public void testWritingEmptyUser(){
        Student newStudent = new Student(null, null, null, null , null);
        users.add(newStudent);
        UserList.setUserList(users);
        DataWriter.saveUsers();
        ArrayList <User> writtenUsers = DataLoader.loadUsers();
        assertEquals(null, writtenUsers.get(users.size()-1).getFirstName());
        assertEquals(null, writtenUsers.get(users.size()-1).getLastName());
        assertEquals(null, writtenUsers.get(users.size()-1).getEmail());
        assertEquals(null, writtenUsers.get(users.size()-1).getUserName());
        assertEquals(null, writtenUsers.get(users.size()-1).getPassword());
    }
/*   
    @Test
    public void testWritingCourseListSize(){
        //courseList = DataLoader.loadCourses();
        //assertEquals(0, userList.size());
    }

    @Test
    public void testWritingCourseModuleName(){

    }
*/
}