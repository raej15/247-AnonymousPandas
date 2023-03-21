/*
* Written By Anonmyous Pandas
*/
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.LinkedHashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    /*
    * DataWriter extends from DataConstants
    * the void method saveUsers() calls from the arraylist
    * JSONArray stores the user sizes
    * JSONObject getsUserJson(User user) and puts the users details
    * @return usersDetails
    */
    public static void main(String[] args){
        saveUsers();
        saveCourses();
    }
    //users json
    public static void saveUsers(){
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();
        
        for(int i = 0; i < userList.size(); i++){
            jsonUsers.add(getUsersJson(userList.get(i)));
        }
        try(FileWriter fileWriter = new FileWriter(USER_FILE_NAME)){
            fileWriter.write(jsonUsers.toJSONString());
            fileWriter.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static JSONObject getUsersJson(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_USER_NAME, user.getUserName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_TYPE, user.getUserType());

         System.out.println(userDetails);


        return userDetails;
    }

    //saveCourses
    public static void saveCourses(){
        CourseList courses = CourseList.getInstance();
        ArrayList <Course> courseList = courses.getCourses(); 
        JSONArray jsonCourses = new JSONArray();

        for(int i = 0; i < courseList.size(); i++){
            jsonCourses.add(getCourseJson(courseList.get(i)));
        }
        try(FileWriter fileWriter = new FileWriter(COURSE_FILE_NAME)){
            fileWriter.write(jsonCourses.toJSONString());
            fileWriter.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //Course Json
    public static JSONObject getCourseJson(Course course){
        JSONObject courseDetails = new JSONObject();
        courseDetails.put(COURSE_AUTHOR, course.getAuthorID().toString());
        courseDetails.put(COURSE_STUDENT_GRADES, course.getGrades());

        //JSONArray studentArray = new JSONArray();

        /*for(Student student : course.getStudents()){
            Map<String, String> studentMap = new LinkedHashMap<String, String>(); 
            studentMap.put(USER_ID, student.getID().toString());
            studentMap.put(USER_USER_NAME, student.getUserName());
            studentMap.put(USER_PASSWORD, student.getPassword());
            studentMap.put(USER_FIRST_NAME, student.getFirstName());
            studentMap.put(USER_LAST_NAME, student.getLastName());
            studentArray.add(studentMap);
        }*/


        //courseDetails.put(COURSE_STUDENT, studentArray);

        courseDetails.put(COURSE_NAME, course.getCourseName());
        courseDetails.put(COURSE_DESCRIPTION,course.getDescription());



        return courseDetails;
    }

    public static JSONObject getModuleJson(Module module){
        JSONObject moduleDetails = new JSONObject();
        //moduleDetails.put(COURSE_MODULES, module.ge());
        moduleDetails.put(COURSE_MODULE_NAME, module.getModuleName());
        
        return moduleDetails;
    }

    public static JSONObject getLessonJson(Lesson lesson){
        JSONObject lessonDetails = new JSONObject();
        //moduleDetails.put(COURSE_MODULES, module.ge());
        lessonDetails.put(COURSE_LESSON_NAME, lesson.getLessonName());
        lessonDetails.put(COURSE_LESSON_CONTENT, lesson.getContent());

        
        return moduleDetails;
    }


}