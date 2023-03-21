import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter2 extends DataConstants {
    
    /** 
     * @param args
     */
    /*
    * DataWriter extends from DataConstants
    * the void method saveUsers() calls from the arraylist
    * JSONArray stores the user sizes
    * JSONObject getsUserJson(User user) and puts the users details
    * @return usersDetails
    */
    public static void main(String[] args){
        ArrayList<User> users = DataLoader.loadUsers();
        for (User user: users) {
            System.out.println(user.toString()+"\n---------------");
        }
        ArrayList<Course> courses = DataLoader.loadCourses();
        for (Course course: courses) {
            System.out.println("------------------------------------------------------------------------");
            System.out.println(course.toString());
            System.out.println("------------------------------------------------------------------------");
        }
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
    
    /** 
     * @param user
     * @return JSONObject
     */
    public static JSONObject getUsersJson(User user) {
        JSONObject userDetails = new JSONObject();
        //userDetails.put(USER_ID,user.getID());
        System.out.println(user.getUUID());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_USER_NAME, user.getUserName());
        userDetails.put(USER_PASSWORD, user.getPassword());
        //this is wrong - getUserType returns 1 no matter the type of user
        //userDetails.put(USER_TYPE, user.getUserType());

         //System.out.println(userDetails);
         if ((user instanceof Student)) {
            userDetails.put(USER_TYPE, "Student");
        } else {
            userDetails.put(USER_TYPE, "Creator");
        }
        //System.out.println(userDetails);
        return userDetails;
    }

    //saveCourses
    public static void saveCourses(){
        CourseList courses = CourseList.getInstance();
        ArrayList <Course> courseList = courses.getCourses(); 
        JSONArray jsonCourses = new JSONArray();
        System.out.println(courseList.size());
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
    
    /** 
     * @param course
     * @return JSONObject
     */
    // called for each course in courseList
    public static JSONObject getCourseJson(Course course){
        System.out.println("Writing course...");

        // onject for current course
        JSONObject courseJSON = new JSONObject();

        // adding course author to courseJSON
        courseJSON.put(COURSE_AUTHOR, course.getAuthorID().toString());
        //courseJSON.put(COURSE_STUDENT_ID, course.getStudents());
        //courseJSON.put(COURSE_STUDENT_GRADES, course.getGrades());
      
        // object of students (which is a hash map of student id and their respective grades )
        JSONArray studentsJSON = new JSONArray();

        // getting grades from course
        HashMap<UUID, ArrayList<Double>> grades = course.getGrades();
        
        // loops through hash map of grades
        for (HashMap.Entry<UUID,ArrayList<Double>> entry : grades.entrySet()) {
            //System.out.println("Key = " + entry.getKey() +", Value = " + entry.getValue());
            // retrieving key and value for the student
            JSONArray student = new JSONArray();
            UUID uuid = entry.getKey();
            ArrayList<Double> studentGrades = entry.getValue();
            System.out.println(uuid);
            student.add(uuid);
            student.add(studentGrades);
            ((Map) studentsJSON).put(COURSE_STUDENT,student);
        }
            
        
      


        //courseDetails.put(COURSE_STUDENT, studentArray);

        //courseJSON.put(COURSE_NAME, course.getCourseName());
        //courseJSON.put(COURSE_DESCRIPTION,course.getDescription());



        return courseJSON;
    }

/** 
 * @param course
 * @return JSONObject
 */

    
    /** 
     * @param module
     * @return JSONObject
     */
    public static JSONObject getModuleJson(Module module){
        JSONObject moduleDetails = new JSONObject();
        //moduleDetails.put(COURSE_MODULES, module.ge());
        moduleDetails.put(COURSE_MODULE_NAME, module.getModuleName());
        
    
    /** 
     * @param module
     * @return JSONObject
     */
        return moduleDetails;
    }

    
    /** 
     * @param lesson
     * @return JSONObject
     */
    
    /** 
     * @param lesson
     * @return JSONObject
     */
    public static JSONObject getLessonJson(Lesson lesson){
        JSONObject lessonDetails = new JSONObject();
        //moduleDetails.put(COURSE_MODULES, module.ge());
        lessonDetails.put(COURSE_LESSON_NAME, lesson.getLessonName());
        lessonDetails.put(COURSE_LESSON_CONTENT, lesson.getContent());

        
        return lessonDetails;
    }


}
