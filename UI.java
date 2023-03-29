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

        System.out.println("\nYou have logged in as "+userInput);
        facade.setUser(user);
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

        facade.register(username, password, email, firstName, lastName, type);
        login(username);
        return;
    }

    /**
     * This loads the home screen for students
     * @return True if the program should continue, false if not
     */
    private static boolean studentHome() {
        System.out.println("You are logged in as "+facade.getUser().getUserName());
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
                //UI.getFacade().getCourseList().addCourse();
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
     * Lets the course creator remove a course
     */
    private static void courseRemove() {
        System.out.println("What course would you like to remove?\n0. Go back");
        facade.getCourseList().printCourseNames();
        int userInputINT = 0;

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

        facade.getCourseList().printCourseNames();

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
        System.out.println("1. Pick a module\n2. Take the certificate exam\n3. Go back");
        int userInputINT = intCheck();

        switch(userInputINT) {
            case 1:
                modulePrint = true;
                return;
            case 2:
                facade.setQuiz(1);
                return;
            case 3:
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
                facade.getCourse().addModule(input.nextLine());
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
        switch (facade.getCourse().removeModule(moduleIndex - 1)) {
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
        facade.getCourse().printModuleNames();

        int userInputINT = intCheck();
        facade.setModule(userInputINT - 1);
        modulePrint = false;
        return;
    }

    /**
     * This lets the user access and complete quizzes (Need to finish this)
     */
    private static void quizLoader() {
        System.out.println(facade.getQuiz().toString());
        consoleBarrier();
        facade.getQuiz().printQuestions();

        int userInputINT = intCheck();
        return;
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
                return;
            case 3:
                facade.setModule(-1);
            case 4:
                facade.setComment(1);
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

        System.out.println("1. <INSERT TEXT>\n2. Edit the Quiz\n3. Edit Module Name\n4. Edit Module Description\n5. Make New Lesson\n6. Remove Lesson\n7. Go back");
        int userInputINT = intCheck();

        switch (userInputINT) {
            case 1:
                modulePrint = true;
                return;
            case 2:
                facade.setQuiz(2);
                return;
            case 3:
                System.out.println("What would you like the new module name to be?");
                facade.getModule().updateModuleName(input.nextLine());
                return;
            case 4:
                System.out.println("What would you like the new module description to be?");
                facade.getModule().updateDescription(input.nextLine());
                return;
            case 5:
                System.out.println("What would you like the new lesson to be called?");
                facade.getModule().addLesson(input.nextLine());
                return;
            case 6:
                System.out.println("Which lesson would you like to remove?");
                printLessons();

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
        switch (facade.getModule().removeLesson(lessonIndex - 1)) {
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
                System.out.println("Please enter in a valid input");
                return;
            default:
                return;
        }
    }

    /**
     * Prints out the various options for lessons that the user has
     */
    private static void printLessons() {
        System.out.println("Pick a lesson");
        consoleBarrier();
        facade.getModule().printLessonNames();

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

        // This needs to be completed
        if (facade.hasQuiz()) {
            //quizLoader();
            UI.getFacade().getCourse().takeCert();
            return false;
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
            printLessons();
            return true;
        }

        if (!facade.hasLesson()) {
            studentModuleOptions();
            return true;
        }

        System.out.println(facade.getLesson().getContent());
        consoleBarrier();
        System.out.println("1. Go back");

        int userInputINT = 0;

        while (true) {
            userInputINT = intCheck();
            
            if (userInputINT == 1) {
                facade.setLesson(-1);
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

        // This needs to be completed
        if (facade.hasQuiz()) {
            quizLoader();
            return true;
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
            printLessons();
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