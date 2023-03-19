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
        ArrayList <Course> courseList = courses.getCourses(); // need to create a get Course method
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
        courseDetails.put(COURSE_NAME, course.getCourseName());
        courseDetails.put(COURSE_DESCRIPTION,course.getDescription());
        
        return courseDetails;
    }

}