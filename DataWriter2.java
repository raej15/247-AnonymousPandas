import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
        DataLoader.loadUsers();
        DataLoader.loadCourses();
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
        if ((user instanceof Student)) {
            UUID studentId = ((Student) user).getUUID();
            userDetails.put(USER_ID,studentId.toString());
        } else {
            UUID studentId = ((CourseCreator) user).getUUID();
            userDetails.put(USER_ID,studentId.toString());
        }

        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_USER_NAME, user.getUserName());
        userDetails.put(USER_PASSWORD, user.getPassword());

         if ((user instanceof Student)) {
            userDetails.put(USER_TYPE, "Student");
        } else {
            userDetails.put(USER_TYPE, "Creator");
        }
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
    
    /** 
     * @param course
     * @return JSONObject
     */
    // called for each course in courseList
    public static JSONObject getCourseJson(Course course){
        System.out.println("Writing course...");

        // object for current course
        JSONObject courseJSON = new JSONObject();

        // adding course author to courseJSON
        courseJSON.put(COURSE_AUTHOR, course.getAuthorID().toString()); // author

        // object of students (which is a hash map of student id and their respective grades )
        JSONArray studentsJSON = new JSONArray();

        // getting grades from course
        HashMap<UUID, ArrayList<Double>> grades = course.getGrades();
        
        // loops through grades and adds them to students jsonarray
        for (HashMap.Entry<UUID,ArrayList<Double>> entry : grades.entrySet()) {
            // retrieving key and value for the student
            JSONArray studentJSON = new JSONArray();
            UUID uuid = entry.getKey();
            ArrayList<Double> studentGrades = entry.getValue();
            studentJSON.add(uuid.toString());
            studentJSON.add(studentGrades);
            studentsJSON.add(studentJSON);
        }
        courseJSON.put(COURSE_STUDENT, studentsJSON); // students

        courseJSON.put(COURSE_NAME, course.getCourseName()); // course courseName
        courseJSON.put(COURSE_DESCRIPTION,course.getDescription()); // course description
        
        String languagestr = course.getLanguageStr(course.getLanguage());
        courseJSON.put(COURSE_LANGUAGE,languagestr); // language

        // getting modules
        ArrayList<Module> modules = course.getModules();
        JSONArray modulesJSON = new JSONArray();

        // looping through the modules
        for (Module module: modules){
            JSONObject moduleJSON = new JSONObject();
        

            // lessons
            JSONArray lessonsJSON = new JSONArray();
            ArrayList<Lesson> lessons = module.getLessons();
            
            // looping through lessons
            for (Lesson lesson: lessons) {
                JSONObject lessonJSON = new JSONObject();
                lessonJSON.put(COURSE_LESSON_NAME,lesson.getLessonName());
                lessonJSON.put(COURSE_LESSON_CONTENT,lesson.getContent());
                lessonsJSON.add(lessonJSON);
            }
            moduleJSON.put(COURSE_MODULE_NAME,module.getModuleName()); // module name
            moduleJSON.put(COURSE_LESSONS,lessonsJSON); // lessons

            // quiz (array)
            // questions - array
            // question - object
            
            JSONArray quizJSON = new JSONArray();
            JSONArray questionsJSON = new JSONArray();
            
                //put questionContent
                // put answers array
                // put correct Index

            ArrayList<Question> questions = module.getQuizQuestions();
            // loop through quiz questions
            for (Question question: questions){
                JSONObject questionJSON = new JSONObject();
                questionJSON.put(COURSE_QUIZ_QUESTIONS,question.getQuestion());
                JSONArray answerChoicesJSON = new JSONArray();
                ArrayList<String> answerChoices = question.getAnswers();
                for (String ac: answerChoices){
                    answerChoicesJSON.add(ac);
                }
                questionJSON.put(COURSE_QUIZ_ANSWERS, answerChoicesJSON);
                questionJSON.put(COURSE_QUIZ_CORRECT_INDEX, question.getCorrectIndex());

                questionsJSON.add(questionJSON);
            }
            quizJSON.add(questionsJSON);
            moduleJSON.put(COURSE_MODULE_QUIZ,quizJSON);


            modulesJSON.add(moduleJSON);
        }
        
        courseJSON.put(COURSE_MODULES,modulesJSON);


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
