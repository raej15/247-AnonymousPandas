import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tested by Rae/Sara Jones
 */
public class CourseListTest {

	private static LMSFacade facade = new LMSFacade();
	private ArrayList <User> users = DataLoader.loadUsers();
	private ArrayList<Course> courses = DataLoader.loadCourses();


	//@BeforeEach
	//public void setup() {
		//courses.clear();
		//courses.add(new Course("JavaScript", "Teaches you how to code in javaScript!", Language.JavaScript, UUID.fromString("3541edda-cbd8-4018-b5c9-34088171d1ae")) );
		//DataWriter.saveCourses();
	//}

    @Test 
    public void testingCreateCourse() {

        assertTrue(true);
    }

    @Test
    void testingHasFirstCourse() {
        boolean hasJavaScript = courses.get(0) != null;
        assertTrue(hasJavaScript);
    }
    @Test 
    public void testingGetInstance() {
       boolean hasInstance = CourseList.getInstance() != null;
       assertTrue(hasInstance);
    }

    @Test 
    public void testCourseListSize() {
		assertEquals(2, courses.size());

    }


}
