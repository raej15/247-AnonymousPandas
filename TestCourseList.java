import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

/**
 * tested by Rae/Sara Jones
 */
public class TestCourseList {

	private static LMSFacade facade = new LMSFacade();
	private ArrayList <User> users = DataLoader.loadUsers();
	private ArrayList<Course> courses = DataLoader.loadCourses();


	@BeforeEach
	public void setup() {
		courses.clear();
		courses.add(new Course("JavaScript", "Teaches you how to code in javaScript!", Language.JavaScript, UUID.fromString("3541edda-cbd8-4018-b5c9-34088171d1ae")) );
        courses.add(new Course("Python", "Basics of Python to get you started", Language.Python, UUID.fromString("3541edda-cbd8-4018-b5c9-34088171d1ae")) );
		DataWriter.saveCourses();

        users.clear();
        users.add(new User(UUID.fromString("3541edda-cbd8-4018-b5c9-34088171d1ae"),"fred02", "codeMaster", "fredM@gmail.com", "Fred", "Mystery"));
        DataWriter.saveUsers();
    }

    @AfterEach
    public void tearDown() {
        CourseList.getInstance().getCourses().clear();
        UserList.getInstance().getUsers().clear();
        DataWriter.saveCourses();
		DataWriter.saveUsers();
    }

    @Test 
    public void testingGetInstance() {
       boolean hasInstance = CourseList.getInstance() != null;
       assertTrue(hasInstance);
    }

    @Test 
    public void testingCreateCourseName() {
        courses.add(new Course("Python Deep Dive", "Learn how to become an Python PRO!", Language.Python, UUID.fromString("3541edda-cbd8-4018-b5c9-34088171d1ae")) );
        assertEquals("Python Deep Dive", courses.get(courses.size()-1).getCourseName());
    }

    @Test
    public void testingCreateCourseDescription() {
        courses.add(new Course("Python Deep Dive", "Learn how to become an Python PRO!", Language.Python, UUID.fromString("3541edda-cbd8-4018-b5c9-34088171d1ae")) );
        assertEquals("Learn how to become an Python PRO!", courses.get(courses.size()-1).getDescription());
    }

    @Test
    public void testingCreateCourseLanguage() {
        courses.add(new Course("Python Deep Dive", "Learn how to become an Python PRO!", Language.Python, UUID.fromString("3541edda-cbd8-4018-b5c9-34088171d1ae")) );
        assertEquals(Language.Python, courses.get(courses.size()-1).getLanguage());
    }

    @Test
    public void testingCreateCourseAuthor() {
        courses.add(new Course("Python Deep Dive", "Learn how to become an Python PRO!", Language.Python, UUID.fromString("3541edda-cbd8-4018-b5c9-34088171d1ae")) );
        assertEquals(UUID.fromString("3541edda-cbd8-4018-b5c9-34088171d1ae"), courses.get(courses.size()-1).getAuthorID());
    }


    @Test
    public void testingBlankCourse() {
        courses.add(new Course("", "", Language.valueOf(null), UUID.fromString("")));
        assertEquals("", courses.get(courses.size()-1).getCourseName());
    }

    @Test
    public void testingHasFirstCourse() {
        assertEquals("JavaScript", courses.get(0).getCourseName());
    }

    @Test
    public void testingHasLastCourse() {
        assertEquals("Python", courses.get(courses.size()-1).getCourseName());
    }


    @Test 
    public void testCourseListSize() {
		assertEquals(2, courses.size());

    }

    @Test
    public void testingRemoveCourse() {
        courses.remove(0);
        assertEquals("Python", courses.get(0).getCourseName());
    }
}
