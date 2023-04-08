import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
    private UserList users = UserList.getInstance();
    private ArrayList<User> userList = users.getUsers();
    private CourseList courses = CourseList.getInstance();
    private ArrayList<Course> courseList = courses.getCourses();

    @BeforeEach
    @Test
	public void setup() {
		UserList.getInstance().getUsers().clear();
		DataWriter.saveUsers();
        CourseList.getInstance().getCourses().clear();
        DataWriter.saveCourses();
	}
	
	@AfterEach
	public void tearDown() {
		UserList.getInstance().getUsers().clear();
		DataWriter.saveUsers();
        CourseList.getInstance().getCourses().clear();
        DataWriter.saveCourses();
	}

    @Test
    public void testWritingZeroUsers(){
        userList = DataLoader.loadUsers();
        assertEquals(0, userList.size());
    }

    @Test
    public void testWritingUserName(){
        DataWriter.saveUsers();
        assertEquals("trey12", DataLoader.loadUsers().get(0).getUserName());
    }

    @Test
    public void testWritingOneUser(){
        userList.add(new User("Trey","White","twhite@gmail.com","trey12","treyWhite12"));
        userList = DataLoader.loadUsers();
        assertEquals("trey12", DataLoader.loadUsers().get(0).getUserName());
    }

    @Test
    public void testWritingNullUser(){
        userList.add(new User("", "", null, "", ""));
        DataWriter.saveUsers();
        assertEquals(null, DataLoader.loadUsers().get(0).getUserName());
    }

    @Test
    public void testWritingEmptyUser(){
        userList.add(new User("","","","",""));
        DataWriter.saveUsers();
        assertEquals("", DataLoader.loadUsers().get(0).getUserName());
    }
    
    @Test
    public void testWritingCourseListSize(){
        courseList = DataLoader.loadCourses();
        assertEquals(0, userList.size());
    }

    @Test
    public void testWritingCourseModuleName(){

    }

}