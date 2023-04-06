import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//portias test
public class DataLoaderTest {

    private ArrayList<User> users = DataLoader.loadUsers();
    private ArrayList<Course> courses = DataLoader.loadCourses();
	
	@BeforeEach
	public void setup() {
		users.clear();
		users.add(new Student("Kelly", "Finnegan", "finnegak@email.sc.edu", "finnegak", "kfinn999!"));
		//users.add(new CourseCreator("Rae"));
		DataWriter.saveUsers();
	}
	

    
}
