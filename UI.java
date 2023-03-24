/*
 * Written by Anonymous Pandas
 */

import java.util.Scanner;

/**
 * I'm currently using this to test the code that I've written. This will need to be updated eventually
 */

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

    public LMSFacade getFacade(){
        return this.facade;
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
            }
        }

        facade.register(username, password, email, firstName, lastName, type);
        login(username);
        return;
    }

    /**
     * This loads the home screen of the user
     * @return True if the program should continue, false if not
     */
    private static boolean home() {
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
     * Lets the user pick whichever course they want to access
     */
    private static void courseLoader() {
        System.out.println("Please select which course you wish to access");
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
    private static void courseOptions() {
        System.out.println(facade.getCourse().getCourseName());
        consoleBarrier();

        System.out.println("1. Pick a module\n2. Take the certificate exam\n3. Go back");
        int userInputINT = intCheck();

        if (userInputINT == 1) {
            modulePrint = true;
        } else if (userInputINT == 2) {
            facade.setQuiz(1);
        } else if (userInputINT == 3) {
            facade.setCourse(-1);
        } else {
            System.out.println("Please input a valid option");
        }

        return;
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
     * Shows the options that the user has for the current module
     */
    private static void moduleOptions() {
        System.out.println(facade.getModule().getModuleName());
        consoleBarrier();

        System.out.println("1. Pick a lesson\n2. Take the quiz\n3. Go back");
        int userInputINT = intCheck();

        if (userInputINT == 1) {
            lessonPrint = true;
        } else if (userInputINT == 2) {
            facade.setQuiz(2);
        } else if (userInputINT == 3) {
            facade.setModule(-1);
        } else {
            System.out.println("Please input a valid option");
        }

        return;
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

        if (!facade.hasUser()) {
            login();
            return true;
        }

        if (coursePrint) {
            courseLoader();
            return true;
        }

        if (!facade.hasCourse()) {
            return home();
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
            courseOptions();
            return true;
        }

        if (lessonPrint) {
            printLessons();
            return true;
        }

        if (!facade.hasLesson()) {
            moduleOptions();
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
                    // testing create course
                    facade.getCourseList().addCourse();
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
                System.out.println("Course Creator");
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