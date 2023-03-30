import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    /**
     * method that calls getUsersJson for every user in our userList
     */

    public static void saveUsers(){
        System.out.println("Writing users...");
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
     * method that gets all of the users information and adds it to JSONObject
     * @param user
     * @return JSONObjects
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
            ArrayList<String> certs = ((Student) user).getCertifications();
            JSONArray certsJSON = new JSONArray();
            for (String cert: certs){
                certsJSON.add(cert);
            }
            userDetails.put(CERTIFICATIONS, certsJSON);
        } else {
            userDetails.put(USER_TYPE, "Creator");
        }
        return userDetails;
    }

    /**
     * method that calls getCourseJSON() for every course in our coursesList
     */
    public static void saveCourses(){
        System.out.println("Writing course...");
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
     * method that gets all the data of the course sent in through the parameter and returns it as a JSONObject
     * @param course course object
     * @return JSONObject
     */

    // called for each course in courseList
    public static JSONObject getCourseJson(Course course){
        // object for current course
        JSONObject courseJSON = new JSONObject();

        // adding course author to courseJSON
        if (course.getAuthorID() == null) {
            System.out.println("Author ID is null");
            courseJSON.put(COURSE_AUTHOR, ""); // author NULL
        } else {
            courseJSON.put(COURSE_AUTHOR, course.getAuthorID().toString()); // author
        }
        
        // object of students (which is a hash map of student id and their respective grades )
        JSONArray studentsJSON = new JSONArray();

        // getting grades from course
        HashMap<UUID, ArrayList<Double>> grades = course.getGrades();
        if (grades == null){
            JSONObject studentJSON = new JSONObject();
            ArrayList<Long> longStudentGrades = new ArrayList<Long>();
            studentJSON.put(COURSE_STUDENT_ID," ");
            studentJSON.put(COURSE_STUDENT_GRADES,longStudentGrades);
            studentsJSON.add(studentJSON);
            courseJSON.put(COURSE_STUDENT, studentsJSON); // students
        } else {
            // loops through grades and adds them to students jsonarray
            for (HashMap.Entry<UUID,ArrayList<Double>> entry : grades.entrySet()) {
                // retrieving key and value for the student
                JSONObject studentJSON = new JSONObject();
                UUID uuid = entry.getKey();
                ArrayList<Double> studentGrades = entry.getValue();
                ArrayList<Long> longStudentGrades = new ArrayList<Long>();
                for (Double grade: studentGrades){
                    long lgrade = Math.round(grade);
                    longStudentGrades.add(lgrade);
                }
                studentJSON.put(COURSE_STUDENT_ID,uuid.toString());
                studentJSON.put(COURSE_STUDENT_GRADES,longStudentGrades);
                studentsJSON.add(studentJSON);
            }
            courseJSON.put(COURSE_STUDENT, studentsJSON); // students
        }
    

        courseJSON.put(COURSE_NAME, course.getCourseName()); // course and courseName
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
            
            // looping through all the lessons
            for (Lesson lesson: lessons) {
                JSONObject lessonJSON = new JSONObject();
                lessonJSON.put(COURSE_LESSON_NAME,lesson.getLessonName());
                lessonJSON.put(COURSE_LESSON_CONTENT,lesson.getContent());
                lessonsJSON.add(lessonJSON);
            }
            moduleJSON.put(COURSE_MODULE_NAME,module.getModuleName()); // module name
            moduleJSON.put(COURSE_LESSONS,lessonsJSON); // lessons
            JSONArray quizJSON = new JSONArray();

            ArrayList<Question> questions = module.getQuizQuestions(); //retrieving questions from the course

            // loop through quiz questions
            for (Question question: questions){
                JSONObject questionJSON = new JSONObject();
                questionJSON.put(COURSE_QUIZ_QUESTIONS,question.getQuestion()); // question
                JSONArray answerChoicesJSON = new JSONArray();
                ArrayList<String> answerChoices = question.getAnswers();
                for (String ac: answerChoices){
                    answerChoicesJSON.add(ac);
                }
                questionJSON.put(COURSE_QUIZ_ANSWERS, answerChoicesJSON); // answers
                questionJSON.put(COURSE_QUIZ_CORRECT_INDEX, question.getCorrectIndex()); // correctIndex

                quizJSON.add(questionJSON);
            }
            moduleJSON.put(COURSE_MODULE_QUIZ,quizJSON); // quiz

            // Module Comments
            JSONArray moduleCommentsJSON = new JSONArray();


            if (module.getComments()==null){
                JSONObject commentJSON = new JSONObject();
                commentJSON.put(COURSE_COMMENTS_USER, " ");
                commentJSON.put(COURSE_COMMENTS_COMMENT," ");
                ArrayList<Comment> nestedComments = new ArrayList<Comment>();
                JSONArray nestedCommentsJSON = new JSONArray();
            } else {
                ArrayList<Comment> moduleComments = module.getComments(); // retrieving comments from module
                // loop through module comments
                for (Comment comment: moduleComments){
                    JSONObject commentJSON = new JSONObject();
                    commentJSON.put(COURSE_COMMENTS_USER, comment.getCommenter().toString());
                    commentJSON.put(COURSE_COMMENTS_COMMENT, comment.getComment());
                    ArrayList<Comment> nestedComments = comment.getComments();
                    JSONArray nestedCommentsJSON = new JSONArray();
                    for (Comment nestedC: nestedComments){
                        JSONObject nestedCommentJSON = new JSONObject();
                        nestedCommentJSON.put(COURSE_COMMENTS_USER, nestedC.getCommenter().toString());
                        nestedCommentJSON.put(COURSE_NESTED_COMMENT, nestedC.getComment());
                        JSONArray emptyArrayJSON = new JSONArray();
                        ArrayList<Comment> emptyArray = new ArrayList<Comment>();
                        emptyArrayJSON.add(emptyArray);
                        nestedCommentJSON.put(COURSE_COMMENTS,emptyArray); // comments (the empty array)
                        nestedCommentsJSON.add(nestedCommentJSON);
                    }
                    commentJSON.put(COURSE_NESTED_COMMENTS,nestedCommentsJSON); // nestedComment
                    moduleCommentsJSON.add(commentJSON);
                    
                }
            }
            moduleJSON.put(COURSE_MODULE_MODULE_COMMENTS, moduleCommentsJSON); // moduleComments

            modulesJSON.add(moduleJSON);
        }
        
        courseJSON.put(COURSE_MODULES,modulesJSON); // modules

        // Course Comments
        ArrayList<Comment> courseComments = course.getCourseComments(); // retrieving comments from course
        JSONArray courseCommentsJSON = new JSONArray();
        
        if (courseComments == null){
            JSONObject commentJSON = new JSONObject();
            commentJSON.put(COURSE_COMMENTS_USER, " ");
            commentJSON.put(COURSE_COMMENTS_COMMENT, " ");
            JSONArray nestedCommentsJSON = new JSONArray();
            JSONObject nestedCommentJSON = new JSONObject();
            nestedCommentJSON.put(COURSE_COMMENTS_USER, " ");
            nestedCommentJSON.put(COURSE_NESTED_COMMENT, " ");
            JSONArray emptyArrayJSON = new JSONArray();
            ArrayList<Comment> emptyArray = new ArrayList<Comment>();
            emptyArrayJSON.add(emptyArray);
            nestedCommentJSON.put(COURSE_COMMENTS,emptyArray); // comments (the empty array)
            nestedCommentsJSON.add(nestedCommentJSON);
            commentJSON.put(COURSE_NESTED_COMMENTS,nestedCommentsJSON); // nestedComment
            courseCommentsJSON.add(commentJSON);
            courseJSON.put(COURSE_COURSE_COMMENTS, courseCommentsJSON); // courseComments
        } else {
            // loop through module comments
            for (Comment comment: courseComments){
                JSONObject commentJSON = new JSONObject();
                if (comment.getCommenter() == null){
                    commentJSON.put(COURSE_COMMENTS_USER, " ");
                    commentJSON.put(COURSE_COMMENTS_COMMENT, " ");
                } else {
                    commentJSON.put(COURSE_COMMENTS_USER, comment.getCommenter().toString());
                    commentJSON.put(COURSE_COMMENTS_COMMENT, comment.getComment());
                }
                
        
                ArrayList<Comment> nestedComments = comment.getComments();
                JSONArray nestedCommentsJSON = new JSONArray();
                for (Comment nestedC: nestedComments){
                    JSONObject nestedCommentJSON = new JSONObject();
                    nestedCommentJSON.put(COURSE_COMMENTS_USER, nestedC.getCommenter().toString());
                    nestedCommentJSON.put(COURSE_NESTED_COMMENT, nestedC.getComment());
                    JSONArray emptyArrayJSON = new JSONArray();
                    ArrayList<Comment> emptyArray = new ArrayList<Comment>();
                    emptyArrayJSON.add(emptyArray);
                    nestedCommentJSON.put(COURSE_COMMENTS,emptyArray); // comments (the empty array)
                    nestedCommentsJSON.add(nestedCommentJSON);

                }
                commentJSON.put(COURSE_NESTED_COMMENTS,nestedCommentsJSON); // nestedComment
                courseCommentsJSON.add(commentJSON);
                
            }
            courseJSON.put(COURSE_COURSE_COMMENTS, courseCommentsJSON); // moduleComments
        }

        // final certification (jasonarray and object)
        JSONArray finalCertJSON = new JSONArray();
        JSONObject certJSON = new JSONObject();
        ArrayList<Question> Questions = course.getCertificate().getQuiz().getQuestions();
        JSONArray questionsJSON = new JSONArray();
        for (Question question: Questions){
            JSONObject questionJSON = new JSONObject();
            questionJSON.put(COURSE_QUIZ_QUESTIONS, question.getQuestion());
            JSONArray answersJSON = new JSONArray();
            ArrayList<String> answers = question.getAnswers();
            for (String answer: answers){
                answersJSON.add(answer);
            }
            questionJSON.put(COURSE_QUIZ_ANSWERS,answersJSON);
            questionJSON.put(COURSE_QUIZ_CORRECT_INDEX,question.getCorrectIndex());
            questionsJSON.add(questionJSON);
        }
        certJSON.put(COURSE_FINAL_CERTIFICATION_QUIZ, questionsJSON);
        finalCertJSON.add(certJSON);
        courseJSON.put(COURSE_FINAL_CERTIFICATION, finalCertJSON);
        
        return courseJSON;
    }



}
