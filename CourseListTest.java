import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//portias test
public class CourseListTest {
       //private CourseList courses = CourseList.getInstance();
    //ArrayList<Course> courses = new ArrayList<Course>();
    //private ArrayList<Course> courseList = courses.getCourses();
    private ArrayList<Course> courses = DataLoader.loadCourses();


	@BeforeEach
	public void setup() {
		courses.clear();
		courses.add(new Course("JavaScript", "Teaches you how to code in javaScript!", Language.JavaScript, UUID.fromString("3541edda-cbd8-4018-b5c9-34088171d1ae")) );
		DataWriter.saveCourses();
	}

    @Test 
    public void testingCreateCourse() {

        assertTrue(true);
    }
}
