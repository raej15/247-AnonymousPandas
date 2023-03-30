/*
 * Written by Anonymous Pandas
 */

import java.util.Scanner;

public class UI {
    private static boolean coursePrint = false;
    private static boolean modulePrint = false;
    private static boolean lessonPrint = false;
    private static boolean check = true;
    private static LMSFacade facade;
    private static Scanner input;

    /**
     * Clears the terminal
     */
    private static void clearTerminal() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Adds a barrier to make it look nicer
     */
    private static void consoleBarrier() {
        System.out.println("--------------------------------------------------");
    }

    /**
     * Forces the user to input an integer
     * @return An int that the user inputted
     */
    private static int intCheck() {
        String userInput = "";

        while (true) {
            userInput = input.nextLine();

            try {
                return Integer.parseInt(userInput);
            } catch (Exception e) {
                System.out.println("Please input a number");
            }
        }
    }

    /**
     * Returns the facade that the UI is using
     * @return The facade in use
     */
    public static LMSFacade getFacade(){
        return facade;
    }

    /**
     * Im using this for testing purposes
     */
    private static void addCourses() {
        if (check == true) {
            check = false;
        }
    }

    /**
     * Loads in data from the JSON files
     */
    private static void loadData() {
        UserList.setUserList(DataLoader.loadUsers());
        CourseList.setCourseList(DataLoader.loadCourses());
    }

    /**
     * Saves data to the JSON files
     */
    private static void saveData() {
        DataWriter.saveUsers();
        DataWriter.saveCourses();
    }

    /**
     * Lets the user login
     */
    private static void login() {
        System.out.println("Please enter in your username");
        String userInput = input.nextLine();
        
        if (!facade.getUserList().has(userInput)) {
            System.out.println("The user does not exist");
            return;
        }

        System.out.println("\nPlease enter in your password");
        User user = facade.getUserList().getUser(userInput);
        String password = input.nextLine();

        if (!facade.getUserList().login(user, password)) {
            System.out.println("The password is incorrect");
            return;
        }

        facade.setUser(user);
        System.out.println("\nYou have logged in as "+ facade.getUser().getFirstName() + " " + facade.getUser().getLastName());
        return;
    }

    /**
     * Used to automatically log in the user after registering
     */
    private static void login(String username) {
        facade.setUser(facade.getUserList().getUser(username));
        return;
    }

    /**
     * Registers a new user
     */
    private static void register() {
        boolean check = true;
        String username;
        String password;
        String email;
        String firstName;
        String lastName;
        int type = 0;

        System.out.println("Input the username you will use");
        username = input.nextLine();
        
        System.out.println("Now enter in the password you want");
        password = input.nextLine();

        System.out.println("Now enter in your email address");
        email = input.nextLine();

        System.out.println("Now enter in your first name");
        firstName = input.nextLine();

        System.out.println("Now enter in your last name");
        lastName = input.nextLine();

        while (check) {
            System.out.println("Are you a student or a course creator?\n1. Student\n2. Course Creator");
            type = intCheck();

            switch (type) {
                case 1:
                    check = false;
                    break;
                case 2:
                    check = false;
                    break;
                default:
                    System.out.println("Please enter in a valid input");
                    break;
            }
        }

        facade.register(firstName, lastName, email, username, password, type);
        login(username);
        return;
    }

    /**
     * This loads the home screen for students
     * @return True if the program should continue, false if not
     */
    private static boolean studentHome() {
        //System.out.println("You are logged in as "+facade.getUser().getUserName());
        consoleBarrier();

        System.out.println("1. Enter a course\n2. Logout");
        int userInputINT = intCheck();

        switch (userInputINT) {
            case 1:
                coursePrint = true;
                return true;
            case 2:
                return false;
            default:
                System.out.println("Please enter in a valid input");
                return true;
        }

    }

    /**
     * This loads the home screen for students
     * @return True if the program should continue, false if not
     */
    private static boolean courseCreatorHome() {
        System.out.println("You are logged in as "+facade.getUser().getUserName());
        consoleBarrier();

        System.out.println("1. Edit a course\n2. Add a course\n3. Remove a course\n4. Logout");
        int userInputINT = intCheck();

        switch (userInputINT) {
            case 1:
                coursePrint = true;
                return true;
            case 2:
                courseAdd();
                return true;
            case 3:
                courseRemove();
                return true;
            case 4:
                return false;
            default:
                System.out.println("Please enter in a valid input");
                return true;
        }
    }

    /**
     * Adds a new course
     */
     private static void courseAdd() {
        System.out.println("What would you like the new course to be called?");
        String courseName = input.nextLine();

        System.out.println("Now what would you like its description to be?");
        String courseDescription = input.nextLine();

        System.out.println("Now what language is it for?\n1. JavaScript\n2. Python");
        int userInputINT = intCheck();

        while (true) {
            switch (userInputINT) {
                case 1:
                    facade.addCourse(courseName, courseDescription, Language.JavaScript);
                    return;
                case 2:
                    facade.addCourse(courseName, courseDescription, Language.Python);
                    return;
                default:
                    System.out.println("Please input a valid option");
                    break;
            }

            userInputINT = intCheck();
        }
    }

    /**
     * Prints out the course names
     */
    private static void coursePrinter() {
        String[] courseNames = facade.getCourseNames();

        for (int i = 0; courseNames[i] != null; i++) {
            System.out.println(courseNames[i]);
        }
    }

    /**
     * Lets the course creator remove a course
     */
    private static void courseRemove() {
        System.out.println("What course would you like to remove?\n0. Go back");
        int userInputINT = 0;
        coursePrinter();

        while (true) {
            userInputINT = intCheck();

            if (userInputINT == 0) {
                return;
            }

            switch(facade.removeCourse(userInputINT)) {
                case 0:
                    System.out.println("The course has been deleted");
                    return;
                case 1:
                    System.out.println("That course does not exist");
                    return;
                case 2:
                    System.out.println("You can't delete courses that you didn't make");
                    return;
                default:
                    System.out.println("Please input a valid option");
                    return;
            }
        }
    }
    
    /**
     * Lets the user pick whichever course they want to access
     */
    private static void courseLoader() {
        System.out.println("Please select which course you want to access");
        consoleBarrier();
        coursePrinter();

        int userInputINT = intCheck();
        facade.setCourse(userInputINT);
        coursePrint = false;
        return;
    }

    /**
     * Shows the user what options they have for the current course
     */
    private static void studentCourseOptions() {
        System.out.println(facade.getCourse().getCourseName());
        consoleBarrier();

        /*
         *  facade.getCourseList().printEnrolledCourses(); //NEW changed to only print enrolled courses
            Student user = (Student) UI.getFacade().getUser();
            // New - enroll into a new course
            user.enrollCourse();
         */
        System.out.println("1. Pick a module\n2. Take the certificate exam\n3. Print final certificate\n4. Show Grades\n5. Go back");
        int userInputINT = intCheck();

        switch(userInputINT) {
            case 1:
                modulePrint = true;
                return;
            case 2:
                facade.setQuiz(1);
                return;
            case 3:
                facade.getCourse().getCertificationFile();
            case 4:
                facade.getCourse().printUserGrades();
            case 5:
                facade.setCourse(-1);
                return;
            default:
                System.out.println("Please input a valid option");
                return;
        }
    }

    /**
     * The options the course creator has while a course has been loaded in
     */
    private static void courseCreatorCourseOptions() {
        System.out.println(facade.getCourse().getCourseName());
        consoleBarrier();

        System.out.println("1. Pick a module\n2. Edit certificate exam\n3. Edit the course name\n4. Edit the description\n5. Add a module\n6. Remove a module\n7. Go back");
        int userInputINT = intCheck();

        switch (userInputINT) {
            case 1:
                modulePrint = true;
                //add printing current lesson here
                return;
            case 2:
                facade.setQuiz(1);
                return;
            case 3:
                System.out.println("What would you like the new course name to be?");
                facade.getCourse().updateCourseName(input.nextLine());
                return;
            case 4:
                System.out.println("What would you like the new course description to be?");
                facade.getCourse().updateDescription(input.nextLine());
                return;
            case 5:
                System.out.println("What would you like the new module to be called?");
                facade.addModule(input.nextLine());
                return;
            case 6:
                System.out.println("Which module would you like to remove?");
                printModules();

                userInputINT = intCheck();
                removeModule(userInputINT);
                return;
            case 7:
                facade.setCourse(-1);
                return;
            default:
                System.out.println("Please input a valid option");
                return;
        }

    }

    /**
     * Removes a module based on the index value provided
     * @param moduleIndex The index of the module
     */
    private static void removeModule(int moduleIndex) {
        switch (facade.removeModule(moduleIndex - 1)) {
            case 0:
                System.out.println("Module removed");
                return;
            case 1:
                System.out.println("There are no modules to remove");
                return;
            case 2:
                System.out.println("Please input a valid response");
                return;
            case 3:
                System.out.println("You can't remove modules that you didn't make");
                return;
            default:
                System.out.println("An unexpected error has occured");
                return;
        }
    }

    /**
     * Shows the user the various modules they can pick
     */
    private static void printModules() {
        System.out.println("Pick a module");
        consoleBarrier();
        
        String[] moduleNames = facade.getModuleNames();

        for (int i = 0; moduleNames[i] != null; i++) {
            System.out.println(moduleNames[i]);
        }

        int userInputINT = intCheck();
        facade.setModule(userInputINT - 1);
        modulePrint = false;
        return;
    }

    private static void questionLoader() {
        System.out.println("Pick a question");
        consoleBarrier();

        String[] questionNames = facade.getQuestionNames();

        for (int i = 0; questionNames[i] != null; i++) {
            System.out.println(questionNames[i]);
        }

        int userInputINT = intCheck();
        facade.setQuestion(userInputINT - 1);
        return;
    }

    /**
     * 
     */
    private static void studentQuizOptions() {
        System.out.println("Quiz");
        consoleBarrier();

        System.out.println("1. Answer a question\n2. Submit the exam\n3. Exit the Quiz");
        int userInputINT = intCheck();

        switch (userInputINT) {
            case 1:
                questionLoader();
                return;
            case 2:
            
                return;
            case 3:

            return;
            default:
                System.out.println("Please input a valid option");
                return;
        }
    }

    /**
     * Shows the options that the course creator has for the current quiz
     */
    private static boolean courseCreatorQuizOptions() {
        
        return true;
    }
    
    /**
     * Shows the options that the student has for the current question
     */
    private static void studentQuestionOptions() {
        System.out.println(facade.getCurrentQuestionName());
        consoleBarrier();
        System.out.println("0. Go back");

        String[] answerNames = facade.getAnswerNames();

        for (int i = 0; answerNames[i] != null; i++) {
            System.out.println(answerNames[i]);
        }

        int userInputINT = intCheck();
        
        if (userInputINT == 0) {
            facade.setQuestion(-1);
            return;
        }

        switch (facade.answer(userInputINT)) {
            case 0:

            case 1:

        }
    }

    /**
     * Shows the options that the student has for the current module
     */
    private static void studentModuleOptions() {
        System.out.println(facade.getModule().getModuleName());
        consoleBarrier();

        System.out.println("1. Pick a lesson\n2. Take the quiz\n3. Leave a comment\n4. Go back");
        int userInputINT = intCheck();

        switch (userInputINT) {
            case 1:
                lessonPrint = true;
                return;
            case 2:
                facade.setQuiz(2);
                facade.getQuiz().printQuestions();
                return;
            case 3:
                facade.setComment(1, 1);
            case 4:
                facade.setModule(-1);
            default:
                System.out.println("Please input a valid option");
                return;
        }
    }

    /**
     * Shows the options that the course creator has for the current module
     */
    private static void courseCreatorModuleOptions() {
        System.out.println(facade.getModule().getModuleName());
        consoleBarrier();

        System.out.println("1. Pick Lesson\n2. Edit the Quiz\n3. Edit the module's name\n4. Edit the module's description\n5. Add a lesson\n6. Remove a lesson\n7. Go back");
        int userInputINT = intCheck();

        switch (userInputINT) {
            case 1:
                lessonPrint = true;
                return;
            case 2:
                facade.setQuiz(2);
                facade.setQuiz(2);
                System.out.println("Current questions:");
                facade.getQuiz().printQuestions();
                System.out.println("What would you like the new quiz question to be?");
                facade.getQuiz().addQuestion(input.nextLine());
                saveData();
                for( int i=0; i<3; i++) {
                   System.out.println("What would you like the question answer " + (i+1) + " to be?");
                    facade.getQuiz().getQuestion(facade.getQuiz().getLastIndex()).addAnswer(input.nextLine());
                    saveData(); 
                }

                System.out.println("What is the index of the correct answer?\nPlease pick from 1-3");
                facade.getQuiz().getQuestion(facade.getQuiz().getLastIndex()).setCorrectIndex(Integer.parseInt(input.nextLine()));
                saveData();
                return;
            case 3:
                System.out.println("What would you like the new module name to be?");
                facade.updateModuleName(input.nextLine());
                return;
            case 4:
                System.out.println("What would you like the new module description to be?");
                facade.updateModuleDescription(input.nextLine());
                return;
            case 5:
                System.out.println("What would you like the new lesson to be called?");
                facade.addLesson(input.nextLine());
                return;
            case 6:
                System.out.println("Which lesson would you like to remove?");
                lessonPrinter();

                userInputINT = intCheck();
                removeLesson(userInputINT);
                return;
            case 7:
                facade.setModule(-1);
                return;
            default:
                System.out.println("Please input a valid option");
                return;
        }
    }

    /**
     * Removes a lesson based on the index provided
     * @param lessonIndex The index of the lesson being removed
     */
    private static void removeLesson(int lessonIndex) {
        switch (facade.removeLesson(lessonIndex - 1)) {
            case 0:
                System.out.println("Lesson removed");
                return;
            case 1:
                System.out.println("There are no lessons to remove");
                return;
            case 2:
                System.out.println("That lesson could not be found");
                return;
            case 3:
                System.out.println("You can't delete lessons that you didn't make");
                return;
            default:
                System.out.println("Please enter in a valid input");
                return;
        }
    }

    /**
     * Prints out the lesson names
     */
    private static void lessonPrinter() {
        String[] lessonNames = facade.getLessonNames();

        for (int i = 0; lessonNames[i] != null; i++) {
            System.out.println(lessonNames[i]);
        }
    }

    /**
     * Allows the user to select a lesson to view
     */
    private static void lessonLoader() {
        System.out.println("Pick a lesson");
        consoleBarrier();
        lessonPrinter();

        int userInputINT = intCheck();
        facade.setLesson(userInputINT - 1);
        lessonPrint = false;

        return;
    }

    /**
     * Loads the ui for student accounts
     * @return True if the program should continue, false if not
     */
    private static boolean studentUI() {
        addCourses();

        if (coursePrint) {
            courseLoader();
            return true;
        }

        if (!facade.hasCourse()) {
            return studentHome();
        }

        if (facade.hasQuestion()) {
            studentQuestionOptions();
            return true;
        }

        if (facade.hasQuiz()) {
            studentQuizOptions();
            return true;
        }

        if (modulePrint) {
            printModules();
            return true;
        }

        if (!facade.hasModule()) {
            studentCourseOptions();
            return true;
        }

        if (lessonPrint) {
            lessonLoader();
            return true;
        }

        if (!facade.hasLesson()) {
            studentModuleOptions();
            return true;
        }

        System.out.println(facade.getLesson().getContent());
        consoleBarrier();
        System.out.println("1. Go back\n2. Print lesson to txt file");

        int userInputINT = 0;

        while (true) {
            userInputINT = intCheck();

            switch (userInputINT) {
                case 1:
                    facade.setLesson(-1);
                    return true;
                case 2:
                    facade.getLesson().getLessonFiles();
                    return true;
                default:
                    System.out.println("Please input a valid option");
                    return true;
            }
            
        }
    }

    /**
     * Loads the ui for course creators
     * @return True if the program should continue, false if not
     */
    private static boolean courseCreatorUI() {
        addCourses();

        if (coursePrint) {
            courseLoader();
            return true;
        }

        if (!facade.hasCourse()) {
            return courseCreatorHome();
        }

        if (facade.hasQuiz()) {
            return courseCreatorQuizOptions();
        }

        if (modulePrint) {
            printModules();
            return true;
        }

        if (!facade.hasModule()) {
            courseCreatorCourseOptions();
            return true;
        }

        if (lessonPrint) {
            lessonLoader();
            return true;
        }

        if (!facade.hasLesson()) {
            courseCreatorModuleOptions();
            return true;
        }

        System.out.println(facade.getLesson().getContent());
        consoleBarrier();
        System.out.println("1. Edit\n2. Go back");

        int userInputINT = 0;

        while (true) {
            userInputINT = intCheck();
            
            switch (userInputINT) {
                case 1:
                    System.out.println("Type in what you would like the new lesson content to be");
                    facade.getLesson().updateContent(input.nextLine());
                case 2:
                    facade.setLesson(-1);
                    return true;
                default:
                    System.out.println("Please input a valid option");
                    return true;
            }
        }
    }

    /**
     * Loads the UI and lets the user give input
     * @return True if the program should continue, false if it should terminate
     */
    private static boolean loadUI() {
        if (!facade.hasUser()) {
            System.out.println("Welcome, would you like to register or login?\n1. Login\n2. Register\n3. Exit");
            int userInputINT = intCheck();

            switch (userInputINT) {
                case 1:
                    login();
                    return true;
                case 2:
                    register();
                    return true;
                case 3:
                    return false;
                default:
                    System.out.println("Please input a valid option");
                    return true;
            }
        }

        switch (facade.getUser().getType()) {
            case 1:
                return studentUI();
            case 2:
                return courseCreatorUI();
            default:
                System.out.println("An unexpected bug has occured");
                return false;
        }
    }

    public static void main(String[] args) {
        input = new Scanner(System.in);
        loadData();

        facade = new LMSFacade();
        //clearTerminal();

        while (loadUI()) {
            //clearTerminal();
        }

        //clearTerminal();
        System.out.println("Goodbye");
        saveData();
    }
}