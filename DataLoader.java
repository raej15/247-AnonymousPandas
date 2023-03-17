
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
            System.out.println(course.toString());
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
                HashMap<UUID, ArrayList<Long>> grades = new HashMap<UUID, ArrayList<Long>>();
                JSONArray studentsJSON = (JSONArray)courseJSON.get(COURSE_STUDENT);
                // loops through each student
                for (int j = 0; j < studentsJSON.size();j++) {
                    JSONObject studentJSON = (JSONObject)studentsJSON.get(j);
                    UUID studentID = UUID.fromString((String)studentJSON.get(COURSE_STUDENT_ID));
                    JSONArray gradesJSON = (JSONArray)studentJSON.get(COURSE_STUDENT_GRADES);
                    ArrayList <Long> studentGrades = new ArrayList<Long>();
                    // loop through grades array
                    for (int k = 0; k < gradesJSON.size(); k++) {
                        long grade = (long) gradesJSON.get(k);
                        studentGrades.add(grade);
                    }
                    grades.put(studentID,studentGrades);
                }
                // course name
                String courseName = (String)courseJSON.get(COURSE_NAME);
                // course description
                String courseDescription = (String)courseJSON.get(COURSE_DESCRIPTION);
                // language
                String language = (String)courseJSON.get(COURSE_LANGUAGE);

                //looping through modules
                ArrayList <Module> modules = new ArrayList<Module>();
                JSONArray modulesJSON = (JSONArray)courseJSON.get(COURSE_MODULES);
                for (int j = 0; j < modulesJSON.size(); j++) {
                    // module
                    JSONObject moduleJSON = (JSONObject)modulesJSON.get(j);
                    
                    // module name
                    String moduleName = (String)moduleJSON.get(COURSE_MODULE_NAME);
                    System.out.println(moduleName);

                    //lessons
                    ArrayList <Lesson> lessons = new ArrayList<Lesson>();
                    JSONArray lessonsJSON = (JSONArray)moduleJSON.get(COURSE_LESSONS);
                    for (int k = 0; k < lessonsJSON.size(); k++) {
                        // lesson
                        JSONObject lessonJSON = (JSONObject)lessonsJSON.get(k);
                        // lesson name
                        String lessonName = (String)lessonJSON.get(COURSE_LESSON_NAME);
                        // lesson content
                        String lessonContent = (String)lessonJSON.get(COURSE_LESSON_CONTENT);

                        Lesson lesson = new Lesson(lessonName, lessonContent);
                        lessons.add(lesson);
                    }

                    //quiz
                    ArrayList<Question> questions = new ArrayList<Question>();
                    JSONArray quizJSON = (JSONArray)moduleJSON.get(COURSE_MODULE_QUIZ);
                    for (int k = 0; k <quizJSON.size(); k++) {
                        // question
                        JSONObject questionJSON = (JSONObject)quizJSON.get(k);

                        // question content
                        String question = (String)questionJSON.get(COURSE_QUIZ_QUESTIONS);

                        // answer choices
                        JSONArray answersJSON = (JSONArray)questionJSON.get(COURSE_QUIZ_ANSWERS);
                        ArrayList <String> answers = new ArrayList<String>();
                        for (int m = 0; m < answersJSON.size(); m++){
                            //JSONObject answerJSON = (JSONObject)questionJSON.get(m);
                            String answer = (String)answersJSON.get(m);
                            answers.add(answer);
                        }
                         // correct index
                         int correctIndex = (int)(long)questionJSON.get(COURSE_QUIZ_CORRECT_INDEX);

                         Question newQuestion = new Question(question, answers, correctIndex);
                         questions.add(newQuestion);
                    }
                }

                Course course = new Course(courseName, courseDescription, language, author, grades);
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