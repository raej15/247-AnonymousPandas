/*
 * Written by Anonmyous Pandas 
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
 
    /**
     * Creates a new facade
     */
    LMSFacade() {
        courseList = CourseList.getInstance();
        userList = UserList.getInstance();
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
     * Returns the current comment 
     * @return the current comment
     */
    public Comment getComment(){
        return comment;
    }
 
    /**
     * Checks if there is a user logged in
     * @return True if there's a user, false if not
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
     * Sets the current course to the one at the index in the courseList
     * @param courseIndex The location where the wanted course is
     */
    public void setCourse(int courseIndex) {
        if (courseIndex == -1) {
            course = null;
            return;
        }
 
        if (!courseList.has(courseIndex - 1)) {
            System.out.println("The course does not exist");
            return;
        }
 
         this.course = courseList.getCourse(courseIndex - 1);
         return;
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
            return;
        }

        question = quiz.getQuestion(questionIndex);
    }
 
    //TODO fix this
    // jamal said that we might need addcoment and removecomment ? 
    public void setComment(int commentIndex) {
        if (commentIndex == -1) {
            comment = null;
            return;
        }
        //comment = module.getComments(commentIndex);
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
     * 
     * @param index
     * @return
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
     * TODO
     */
    public void addModule(String moduleName) {
        userList.add(new Module(moduleName));
    }
    /**
     * 
     * @param index
     * @return
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
}
