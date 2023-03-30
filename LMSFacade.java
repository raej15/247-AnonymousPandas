/*
 * Written by Anonmyous Pandas 
 */

 /**
  * Facade 
  */
public class LMSFacade {
    private CourseList courseList;
    private UserList userList;
    private Course course;
    private User user;
    private Module module;
    private Lesson lesson;
    private Quiz quiz;
    private Question question;
    private Comment comment;
    private double[] grade;
    private int questionNum;
 
    /**
     * Creates a new facade
     * gets courselist, userlist, and graades 
     */
    LMSFacade() {
        courseList = CourseList.getInstance();
        userList = UserList.getInstance();
        grade = new double[20];
    }

    /**
     * Creates a new user and adds it to the user list
     * @param username The new user's username
     * @param password The new user's password
     * @param email The new user's email
     * @param firstName The new user's first name
     * @param lastName The new user's last type
     * @param type 1 for students, 2 for course creators
     */
    public void register(String username, String password, String email, String firstName, String lastName, int type) {
        if (type == 1) {
            userList.addUser(new Student(username, password, email, firstName, lastName));
        }
        
        if (type == 2) {
            userList.addUser(new CourseCreator(firstName, lastName, email, username, password));
        }
    }
 
    
    /** 
     * @return CourseList
     * testing
     */
    // Used for testing purposes
    public CourseList getCourseList() {
        return courseList;
    }

    /**
     * Returns the userlist 
     * @return The userlist
     */
    public UserList getUserList() {
        return userList;
    }
 
    /**
     * Returns the current user 
     * @return The current user
     */
    public User getUser() {
        return user;
    }
     
    /**
     * Returns the current course 
     * @return The current course 
     */
    public Course getCourse() {
        return course;
    }
 
    /**
     * Returns the current module
     * @return The current module
     */
    public Module getModule() {
        return module;
    }
     
    /**
     * Returns the current lesson
     * @return The current lesson
     */
    public Lesson getLesson() {
        return lesson;
    }
 
    /**
     * Returns the current quiz
     * @return The current quiz
     */
    public Quiz getQuiz() {
        return quiz;
    }

    /**
     * Returns the current question
     * @return The current question
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Returns the current comment 
     * @return the current comment
     */
    public Comment getComment() {
        return comment;
    }
 
    /**
     * Checks if there is a user logged in
     * @return True if there's a user, false if else
     */
    public boolean hasUser() {
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks if there is a course loaded in
     * @return True if there is a course loaded in, false if not
     */
    public boolean hasCourse() {
        if (course == null) {
            return false;
        } else {
            return true;
        }
    }
 
    /**
     * Checks if there is a module loaded in
     * @return True if there is a module loaded in, false if not
     */
    public boolean hasModule() {
        if (module == null) {
            return false;
        } else {
            return true;
        }
    }
 
    /**
     * Checks if there is a lesson loaded in
     * @return True if there is a module loaded in, false if not
     */
    public boolean hasLesson() {
        if (lesson == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks if there is a quiz loaded in
     * @return True if there is a quiz loaded in, false if not
     */
    public boolean hasQuiz() {
        if (quiz == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks if there is a question laoded in 
     * @return True if there is a question loaded in, false if not
     */
    public boolean hasQuestion() {
        if (question == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks if there is a comment added in
     * @return true if there is a comment added in otherwise it returns false
     */
    public boolean hasComment(){
        if(comment == null){
            return false;
        } else{
            return true;
        }
    }
     
    /**
     * Sets the current user to the user placed in
     * @param user The user being set to the current one
     */
    public void setUser(User user) {
       this.user = user;
       return;
    }

    /**
     * Used for making sure a course that the student is enrolled in is selected
     * @param enrolledCourses The courses the user is enrolled in
     * @param courseIndex The index of the course
     * @return 0 for a success, 1 for the course not existing, 2 for the user not being in the course
     */
    public int setEnrolledCourse(String[] enrolledCourses, int courseIndex) {
        if (!courseList.has(courseIndex)) {
            return 1;
        }

        if (enrolledCourses[courseIndex] == null) {
            return 2;
        }

        course = courseList.getCourse(courseIndex);
        return 0;
    }

    /**
     * Sets the current course to the one at the index in the courseList
     * @param courseIndex The location where the wanted course is
     */
    public int setCourse(int courseIndex) {
        if (courseIndex == -1) {
            course = null;
            return 0;
        }
 
        if (!courseList.has(courseIndex)) {
            return 1;
        }
 
        course = courseList.getCourse(courseIndex);
        return 0;
     }
 
    /**
     * Sets the current module to the one located at the index in the current course
     * @param moduleIndex The location of the module within the course
     */
    public void setModule(int moduleIndex) {
        if (moduleIndex == -1)  {
            module = null;
            return;
        }
        
        module = course.getModuleAtIndex(moduleIndex);
        return;
    }
 
    /**
     * Sets the current lesson to the one located at the index in the current module
     * @param lessonIndex The location of the module within the course
     */
    public void setLesson(int lessonIndex) {
        if (lessonIndex == -1) {
            lesson = null;
            return;
        }
 
        lesson = module.getLessonbyIndex(lessonIndex);
        return;
    }
 
    /**
     * Sets the current quiz to either the one located within the current module or course, based ont he mode
     * @param mode -1 to remove the current quiz, 1 to get the certificate quiz, 2 to get the module quiz
     */
    public void setQuiz(int mode) {
        if (mode == -1) {
            quiz = null;
            return;
        }

        if (mode == 1) {
            this.quiz = course.getCertificate().getQuiz();
            return;
        } else if (mode == 2) {
            quiz = module.getQuiz();
        }
    }
 
    /**
     * Sets the question based on the location of it within the quiz
     * @param questionIndex The location of the question within the quiz
     */
    public void setQuestion(int questionIndex) {
        if (questionIndex == -1) {
            question = null;
            questionNum = -1;
            return;
        }

        questionNum = questionIndex;
        question = quiz.getQuestion(questionIndex);
        return;
    }

    /**
     * Sets the comment at the index as the current comment
     * @param commentIndex The index of the comment that's going to be loaded
     * @param mode Where the comment is located (1 for course, 2 for module, 3 for a comment within a comment)
     */
    public int setComment(int commentIndex, int mode) {
        if (commentIndex == -1) {
            comment = null;
            return 0;
        }

        switch (mode) {
            case 1:
                comment = course.getCourseComments().get(commentIndex);
                return 0;
            case 2:
                comment = module.getComments().get(commentIndex);
                return 0;
            case 3:
                comment = comment.getComments().get(commentIndex);
                return 0;
            default:
                return 1;
        }
    }

    /**
     * Sets the grade for the quiz/exam and returns a string informing the user of their grade
     * @param grade The grade the student got
     * @return A string informing the user of their grade
     */
    public String setGrade() {
        int totalQuestions = 0;
        double overallGrade = 0;

        while (quiz.getLastIndex() + 1 > totalQuestions) {
            overallGrade += grade[totalQuestions];
            totalQuestions++;
        }

        overallGrade *= 100;
        quiz = null;

        if (module == null) {
            return course.setGrade(overallGrade/totalQuestions, user);
        }

        return module.addGrade(overallGrade/totalQuestions, user);
    }
 
    /**
     * Adds a new course to the course list
     * @param courseName The name of the course
     * @param courseDescription The description of the course
     * @param language The language of the course
     */
    public void addCourse(String courseName, String courseDescription, Language language) {
        courseList.addCourse(new Course(courseName, courseDescription, language, user.getUUID()));
    }

    /**
     * Removes a course from the course list if possible
     * @param index The index of the course being removed
     * @return 0 for a successful removal, 1 for the course not existing, 2 for trying to delete a course not made by the user
     */
    public int removeCourse(int index) {
        if (!courseList.has(index)) {
            return 1;
        }

        if (!courseList.getCourse(index).getAuthorID().equals(user.getUUID())) {
            return 2;
        }

        courseList.removeCourseIndex(index);
        return 0;
    }

    /**
     * Creates a new module with the name provided by the user
     * @param moduleName The name of the new module
     */
    public void addModule(String moduleName) {
        course.addModule(null);
    }

    /**
     * Removes a module from the current course if possible
     * @param index The index of the module being removed
     * @return 0 for a successful removal, 1 for the module not existing, 2 for trying to delete a module not made by the user
     */
    public int removeModule(int index) {
        if (!course.hasModules()) {
            return 1;
        }

        if (!course.hasModuleAt(index)) {
            return 2;
        }
        
        if (!course.getAuthorID().equals(user.getUUID())) {
            return 3;
        }

        course.removeModule(index);
        return 0;
    }

    /**
     * Creates a new lesson with the name provided by the user
     * @param lessonName The name of the new lesson
     */
    public void addLesson(String lessonName) {
        module.addLesson(lessonName);
    }

    /**
     * Removes a lesson from the current module if possible
     * @param index The index of the lesson being removed
     * @return 0 for a successful removal, 1 for the lesson not existing, 2 for trying to delete a lesson not made by the user
     */
    public int removeLesson(int index) {
        if (!module.hasLessons()) {
            return 1;
        }

        if (!module.hasLessonAt(index)) {
            return 2;
        }
        
        if (!course.getAuthorID().equals(user.getUUID())) {
            return 3;
        }

        module.removeLesson(index);
        return 0;
    }

    /**
     * Adds a comment to either a course or module based on the mode parameter
     * @param comment The comment being added
     * @param mode 1 for a comment to a course, 2 for a comment to a module
     */
    public void addComment(String comment, int mode) {
        switch (mode) {
            case 1:
                course.addComment(comment, user.getUUID());
                return;
            case 2:
                module.addComment(comment, user.getUUID());
                return;
            default:
                return;
        }
    }

    /**
     * @param index 
     * @return remove comment
     */
    public int removeComment(int index) {
        return 0;
    }

    /**
     * Updates the name of the current course
     * @param newName The new name of the course
     */
    public void updateCourseName(String newName) {
        course.updateCourseName(newName);
        return;
    }

    /**
     * Updates the description of the current courses
     * @param newDescription The new description of the courses
     */
    public void updateCourseDescription(String newDescription) {
        course.updateDescription(newDescription);
        return;
    }

    /**
     * Updates the name of the current module
     * @param newName The new name of the module
     */
    public void updateModuleName(String newName) {
        module.updateModuleName(newName);
        return;
    }

    /**
     * Updates the description of the current module
     * @param newDescription The new description of the module
     */
    public void updateModuleDescription(String newDescription) {
        module.updateDescription(newDescription);
        return;
    }

    /**
     * Updates the name of the current lesson
     * @param newName The new name of the lesson
     */
    public void updateLessonName(String newName) {
        lesson.updateLessonName(newName);
        return;
    }

    /**
     * Updates the content of the current lesson
     * @param newContent The new content for the lesson
     */
    public void updateLessonContent(String newContent) {
        lesson.updateContent(newContent);
        return;
    }

    /**
     * Returns an array of all the course names
     * @return A string array of all the course names
     */
    public String[] getCourseNames() {
        return courseList.getCourseNames();
    }

    /**
     * Returns an array of all the enrolled couress
     * @return A string array of every enrolled course
     */
    public String[] getEnrolledCourses() {
        return courseList.printEnrolledCourses(user.getUUID());
    }

    /**
     * Returns an array of all the module names for the current module
     * @return A string array of module names
     */
    public String[] getModuleNames() {
        return course.getModuleNames();
    }

    /**
     * Returns a string of the current module's name
     * @return A string of the current module's name
     */
    public String getModuleName() {
        return module.getModuleName();
    }

    /**
     * Returns an array of all the lesson names for the current module
     * @return A string array of lesson names 
     */
    public String[] getLessonNames() {
        return module.getLessonNames();
    }

   /**
    * Returns an array of all the lesson content for modules 
    * @return A string of lesson content
    */
    public String getLessonContent() {
        return lesson.getContent();
    }

    public String getLessonFiles() {
        return lesson.getLessonFiles();
    }

   /**
    * Returns an array of Question names for each current module 
    * @return A string of question names 
    */
    public String[] getQuestionNames() {
        return quiz.getQuestionNames();
    }

   /**
    * Returns an array of each answer names of each current module 
    * @return A string of each answer names 
    */
    public String[] getAnswerNames() {
        return question.getAnswerNames();
    }

    /**
     *  Returns an array of each current question name
     * @return A string of each question 
     */
    public String getCurrentQuestionName() {
        return question.getQuestion();
    }

    /**
     * Returns an array of each current Username for module
     * @return A string of usernames
     */
    public String getUserName() {
        return user.getUserName();
    }

    /**
     * Returns an array description of full name 
     * @return Returns a string of first and last name 
     */
    public String getFullName() {
        return user.getFirstName() + " " + user.getLastName();
    }

    /**
     * Returns an arraylist to get each comment from course module 
     * @param mode Gives cases for each comment array
     * @return Returns comments
     */
    public String[] getCommentArray(int mode) {
        switch (mode) {
            case 1:
                return course.getCommentArray();
            case 2:
                return module.getCommentArray();
            case 3:
                return comment.getCommentArray();
            default:
                return null;
        }
    }

    /**
     * Returns grades from courses 
     * @return String of grades
     */
    public String[] getGrades() {
        return course.getGradeString(user.getUUID());
    }

    /**
     * Returns if statment of each user choice
     * @param userChoice Gives courselist of each userchoice
     * @return Returns choices
     */
    public int enroll(int userChoice) {
        if (!courseList.has(userChoice)) {
            return 1;
        }

        if (courseList.getCourse(userChoice).getGrades().containsKey(user.getUUID())) {
            return 2;
        }

        courseList.getCourse(userChoice).addStudent(user.getUUID());
        return 0;
    }

    /**
     * Returns each answer in module  
     * @param userAnswer Gives if statments of each answers and their return
     * @return Returns each selected answer
     */
    public int answer(int userAnswer) {
        if (!question.hasAnswers()) {
            return 1;
        }

        if (!question.hasAnswerAt(userAnswer)) {
            return 2;
        }

        if (question.getCorrectIndex() - 1 == userAnswer) {
            grade[questionNum] = 1;
        } else {
            grade[questionNum] = 0;
        }

        return 0;
    }
}
