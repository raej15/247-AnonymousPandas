
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
    
    /** 
     * @return ArrayList<User>
     */
    public static ArrayList<User> loadUsers() {
        System.out.println("Loading users...");
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
                    users.add(new Student(id,firstName, lastName, email, username,password));
                } else {
                    users.add(new CourseCreator(id,firstName, lastName, email, username,password));
                }
            }
        }
        //UserList.setUserList(users);
        return users;
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    
    /** 
     * @return ArrayList<Course>
     */
    public static ArrayList<Course> loadCourses() {
        System.out.println("Loading courses...");
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
                HashMap<String, ArrayList<Double>> gradesNull = new HashMap<String, ArrayList<Double>>();
                JSONArray studentsJSON = (JSONArray)courseJSON.get(COURSE_STUDENT);
                // Array List that holds the student UUID's enrolled in this course
                ArrayList<UUID> students = new ArrayList<UUID>();
                ArrayList<String> studentsNullID = new ArrayList<String>();
                // loops through each student
                for (int j = 0; j < studentsJSON.size();j++) {
                    JSONObject studentJSON = (JSONObject)studentsJSON.get(j);
                    //check student id is null
                    if (studentJSON.get(COURSE_STUDENT_ID).equals(" ")) {
                        studentsNullID.add(" ");
                        ArrayList<Double> studentGrades = new ArrayList<Double>();
                        //JSONArray gradesJSON = new JSONArray();
                        gradesNull.put(" ",studentGrades);
                    } else {
                        UUID studentID = UUID.fromString((String)studentJSON.get(COURSE_STUDENT_ID));
                        students.add(studentID);
                        JSONArray gradesJSON = (JSONArray)studentJSON.get(COURSE_STUDENT_GRADES);
                        ArrayList <Double> studentGrades = new ArrayList<Double>();
                        // loop through grades array
                        for (int k = 0; k < gradesJSON.size(); k++) {
                            double grade = (double)(long) gradesJSON.get(k);
                            studentGrades.add(grade);
                        }
                        grades.put(studentID,studentGrades);
                    }
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
                            String answer = (String)answersJSON.get(m);
                            answers.add(answer);
                        }
                         // correct index
                        int correctIndex = (int)(long)questionJSON.get(COURSE_QUIZ_CORRECT_INDEX);

                         Question newQuestion = new Question(question, answers, correctIndex);
                         questions.add(newQuestion);
                    }
                    Quiz quiz = new Quiz(questions);

                    ArrayList<Comment> comments = new ArrayList<Comment>();
                    JSONArray moduleCommentsJSON = (JSONArray)moduleJSON.get(COURSE_MODULE_MODULE_COMMENTS);
                    for (int k = 0; k < moduleCommentsJSON.size(); k++) {
                        
                        JSONObject commentJSON = (JSONObject)moduleCommentsJSON.get(k);
                        if (commentJSON.get(COURSE_COMMENTS_USER).equals(" ")) {
                            Comment newComment = new Comment();
                            comments.add(newComment);
                        } else {
                                UUID commenter = UUID.fromString((String)commentJSON.get(COURSE_COMMENTS_USER));
                            
                                String comment = (String)commentJSON.get(COURSE_COMMENTS_COMMENT);

                                JSONArray nestedCommentsJSON = (JSONArray)commentJSON.get(COURSE_NESTED_COMMENTS);
                                // nested comments
                                ArrayList<Comment> nestedComments = new ArrayList<Comment>();
                                for (int m = 0; m < nestedCommentsJSON.size(); m++) {
                                    JSONObject nestedCommentJSON = (JSONObject)nestedCommentsJSON.get(m);
                                    UUID nestedCommenter = UUID.fromString((String)nestedCommentJSON.get(COURSE_COMMENTS_USER));
                                    String nestedComment = (String)nestedCommentJSON.get(COURSE_NESTED_COMMENT);
                                    ArrayList<Comment> doubleComments = new ArrayList<Comment>();
                                    Comment newComment = new Comment(nestedCommenter, nestedComment, doubleComments);
                                    nestedComments.add(newComment);
                                }
                                Comment newComment = new Comment(commenter, comment, nestedComments);
                                comments.add(newComment);
                        }
                    }

                    Module newModule = new Module(moduleName, lessons, quiz, comments);
                    modules.add(newModule);

                    
                }
                // course comments
                ArrayList<Comment> courseComments = new ArrayList<Comment>();
                JSONArray courseCommentsJSON = (JSONArray)courseJSON.get(COURSE_COURSE_COMMENTS);
                for (int k = 0; k < courseCommentsJSON.size(); k++) {
                    
                    JSONObject commentJSON = (JSONObject)courseCommentsJSON.get(k);
                    if (commentJSON.get(COURSE_COMMENTS_USER).equals(" ")){
                        Comment newComment = new Comment();
                        courseComments.add(newComment);
                    } else {
                        UUID commenter = UUID.fromString((String)commentJSON.get(COURSE_COMMENTS_USER));
                        String comment = (String)commentJSON.get(COURSE_COMMENTS_COMMENT);
    
                        JSONArray nestedCommentsJSON = (JSONArray)commentJSON.get(COURSE_NESTED_COMMENTS);
                        // nested comments
                        ArrayList<Comment> nestedComments = new ArrayList<Comment>();
                        for (int m = 0; m < nestedCommentsJSON.size(); m++) {
                            JSONObject nestedCommentJSON = (JSONObject)nestedCommentsJSON.get(m);
                            UUID nestedCommenter = UUID.fromString((String)nestedCommentJSON.get(COURSE_COMMENTS_USER));
                            String nestedComment = (String)nestedCommentJSON.get(COURSE_NESTED_COMMENT);
                            ArrayList<Comment> doubleComments = new ArrayList<Comment>();
                            Comment newComment = new Comment(nestedCommenter, nestedComment, doubleComments);
                            nestedComments.add(newComment);
                        }
                        Comment newComment = new Comment(commenter, comment, nestedComments);
                        courseComments.add(newComment);
                    }
                   
                }
                Course course = new Course(courseName, courseDescription, language, author, grades, modules, courseComments, students);
                // final certification
                JSONArray finalCertJSON = (JSONArray)courseJSON.get(COURSE_FINAL_CERTIFICATION);
                FinalCertification cert = new FinalCertification();
                
                for (int a = 0; a < finalCertJSON.size();a++){
                    JSONObject certJSON = (JSONObject)finalCertJSON.get(a);
                    String passed = (String)certJSON.get(COURSE_FINAL_CERTIFICATION_PASSED);
                    JSONArray certQuizJSON = (JSONArray)certJSON.get(COURSE_FINAL_CERTIFICATION_QUIZ);
                    ArrayList<Question> questions = new ArrayList<Question>();
                    for (int j = 0; j < certQuizJSON.size(); j++) {
                        JSONObject questionJSON = (JSONObject)certQuizJSON.get(j);
                        String question = (String)questionJSON.get(COURSE_QUIZ_QUESTIONS);
                        JSONArray answersJSON = (JSONArray)questionJSON.get(COURSE_QUIZ_ANSWERS);
                        ArrayList<String> answers = new ArrayList<String>();
                        for (int k = 0; k < answersJSON.size(); k++){
                            String answer = (String)answersJSON.get(j);
                            answers.add(answer);
                        }
                        int correctIndex = (int)(long)questionJSON.get(COURSE_QUIZ_CORRECT_INDEX);
                        Question newQuestion = new Question(question, answers, correctIndex);
                        questions.add(newQuestion);
                    }
                    Quiz finalCert = new Quiz(questions);
                    cert.setQuiz(finalCert);
                    cert.setPassed(passed);
                    course.setCert(cert);
                }
                courses.add(course);

            }
            
        }
        
        //CourseList.setCourseList(courses);
        return courses;
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}