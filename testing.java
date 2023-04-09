import java.util.ArrayList;

public class testing {

    private static ArrayList<User> users = DataLoader.loadUsers();
    private static ArrayList<Course> courses = DataLoader.loadCourses();
    public static void main(String[] args) {
 
        System.out.println(users.size());
        UserList.getInstance().getUsers().clear();
        System.out.println("9");
        DataWriter.saveUsers();
        users = DataLoader.loadUsers();
        System.out.println(users.size());
        for (User user: users){
            System.out.println(user.toString());
        }
        UserList.setUserList(users);
        DataWriter.saveUsers();
        ArrayList <User> writtenUsers = DataLoader.loadUsers();

        System.out.println(courses.size());
        CourseList.getInstance().getCourses().clear();
        System.out.println("9");
        DataWriter.saveCourses();
        courses = DataLoader.loadCourses();
        System.out.println(courses.size());
        for (Course course : courses){
            System.out.println(course.toString());
        }
        CourseList.setCourseList(courses);
        DataWriter.saveCourses();
        ArrayList <Course> writtenCourses = DataLoader.loadCourses();
    }
}
