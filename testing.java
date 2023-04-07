import java.util.ArrayList;

public class testing {

    private static LMSFacade facade = new LMSFacade();
    public static void main(String[] args) {
        ArrayList<Course> courses = DataLoader.loadCourses();
		int size = courses.get(0).getCourseComments().get(0).getComments().size();
        String comment = courses.get(0).getCourseComments().get(0).getComments().get(0).getComment();
        System.out.println(size);
        System.out.println(comment);
    }
}
