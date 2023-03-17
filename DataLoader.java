
/*
 * Written by Anonmyous Pandas 
 */

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants{

//these seem to cause errors when not commented out?
//private static final String USER_FILE_NAME = null;
//private static final String COURSE_FILE_NAME = null;


/**
 * Load users method 
 * users JSON  
 * Json Parser reads & writes 
 * JSON array store data
 * for loop has JSONObject, username, email, and password 
 * @return ArrayList<User> 
 */

//userid, firstName, lastName, email, username, password, type (order in json file)

    public static void main(String[] args) {
        ArrayList<User> users = loadUsers();
        for (User user: users) {
            System.out.println(user.toString()+"\n---------------");
        }
        ArrayList<Course> courses = loadCourses();
        for (Course course: courses) {
            System.out.println(course.getAuthorID());
        }
    }
    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray)parser.parse(reader);
        if(usersJSON != null)
        {
            for(int i =0; i < usersJSON.size(); i++)
            {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                UUID id = UUID.fromString((String)userJSON.get(USER_ID));
                String firstName = (String)userJSON.get(USER_FIRST_NAME);
                String lastName = (String)userJSON.get(USER_LAST_NAME);
                String email = (String)userJSON.get(USER_EMAIL);
                String username = (String)userJSON.get(USER_USER_NAME);
                String password = (String)userJSON.get(USER_PASSWORD);
                String type = (String)userJSON.get(USER_TYPE);

                if (type.equals("Student")) {
                    users.add(new Student(id,username,password,email,firstName,lastName));
                } else {
                    users.add(new CourseCreator(id,username,password,email,firstName,lastName));
                }
            }
        }
        UserList.setUserList(users);
        return users;
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static ArrayList<Course> loadCourses() {
        ArrayList<Course> courses = new ArrayList<Course>();
        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray coursesJSON = (JSONArray)parser.parse(reader);
        if(coursesJSON != null)
        {
            // loops through each course in courses.json
            for(int i =0; i < coursesJSON.size(); i++)
            {
                JSONObject courseJSON = (JSONObject)coursesJSON.get(i);
                UUID author = UUID.fromString((String)courseJSON.get(COURSE_AUTHOR));

                // hashmap to hold the student grades with their ID
                HashMap<UUID, ArrayList<Double>> grades = new HashMap<UUID, ArrayList<Double>>();
                JSONObject studentsJSON = (JSONObject)courseJSON.get(COURSE_STUDENT);
                // loops through each student
                for (int j = 0; j < studentsJSON.size();j++) {
                    System.out.println("students");
                    JSONObject studentJSON = (JSONObject)studentsJSON.get(j);
                    UUID studentID = UUID.fromString((String)studentJSON.get(COURSE_STUDENT));

                    JSONObject gradesJSON = (JSONObject)studentJSON.get(COURSE_STUDENT_GRADES);

                    ArrayList <Double> studentGrades = new ArrayList<Double>();
                    // loop through grades array
                    for (int k = 0; k < gradesJSON.size(); k++) {
                        double grade = (Double)gradesJSON.get(k);
                        studentGrades.add(grade);
                    }
                    grades.put(studentID,studentGrades);
                }
                Course course = new Course(author, grades);
                courses.add(course);
            }
            
        }
        CourseList.setCourseList(courses);
        return courses;
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    //needs a lot of work still!! but i updated it a bunch 
    public static ArrayList<Course> loadCourses2() {

        ArrayList<Course> courses = new ArrayList<Course>();
            
        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray courseJSON = (JSONArray)parser.parse(reader);
        if(courseJSON != null)
        {
            for(int i =0; i < courseJSON.size(); i++)
            {
                JSONObject coursesJSON = (JSONObject)courseJSON.get(i);
                UUID author = UUID.fromString((String)coursesJSON.get(COURSE_AUTHOR));
                String courseName = (String)coursesJSON.get(COURSE_NAME);
                String courseDescription = (String)coursesJSON.get(COURSE_DESCRIPTION);
                Language courseLanguage = (Language)coursesJSON.get(COURSE_LANGUAGE);
                Module courseModules = (Module)coursesJSON.get(COURSE_MODULES);
                Student courseStudent = (Student)coursesJSON.get(COURSE_STUDENT);
                UUID courseStudentId = UUID.fromString((String)coursesJSON.get(COURSE_STUDENT_ID));
                double courseStudentGrades = (double)coursesJSON.get(COURSE_STUDENT_GRADES);
                String courseModuleName = (String)coursesJSON.get(COURSE_MODULE_NAME);
                Lesson courseLessons = (Lesson)coursesJSON.get(COURSE_LESSONS);
                String courseLessonName = (String)coursesJSON.get(COURSE_LESSON_NAME);
                String courseLessonContent = (String)coursesJSON.get(COURSE_LESSON_CONTENT);
                Quiz courseModuleQuiz = (Quiz)coursesJSON.get(COURSE_MODULE_QUIZ);
                Question courseQuizQuestions = (Question)coursesJSON.get(COURSE_QUIZ_QUESTIONS);
                String courseQuizAnswers = (String)coursesJSON.get(COURSE_QUIZ_ANSWERS);
                int quizCorrectIndex = (int)coursesJSON.get(COURSE_QUIZ_CORRECT_INDEX);
                Comment comments = (Comment)coursesJSON.get(COURSE_COMMENTS);
                UUID commentUser =  UUID.fromString((String)(String)coursesJSON.get(COURSE_COMMENTS_USER));
                String commentContent = (String)coursesJSON.get(COURSE_COMMENTS_COMMENT);

                //course constructor probably needs author passed in
                courses.add(new Course(courseName, courseDescription, courseLanguage));
                            
            }
        }
        CourseList.setCourseList(courses);
        return courses;
        } 

        catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}