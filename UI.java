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

    /**
     * Im using this for testing purposes
     */
    private static void addCourses() {
        if (check == true) {
            facade.getCourseList().addCourse(new Course("Python Basics", "The basics of python", Language.Python));
            facade.getCourseList().getCourse("Python Basics").addModule("The first week");
            facade.getCourseList().getCourse("Python Basics").getModule(0).addLesson("What are data types?", "This goes over various data types");
            check = false;
        }
    }

    /**
     * Loads in data from the JSON files
     */
    private static void loadData() {
        DataLoader.loadCourses();
        //CourseList.getInstance().printCourses();
        DataLoader.loadUsers();
        UserList.getInstance().printUsers();
    }

    private static void saveData() {

    }

    /**
     * Lets the user login
     */
    private static void login() {
        System.out.println("Please enter in your username");
        String userInput = input.nextLine();
        facade.setUser(userInput);
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
     * 
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

    private static boolean courseOptions() {
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

        return modulePrint;
    }

    private static boolean printModules() {
        System.out.println("Pick a module");
        consoleBarrier();
        facade.getCourse().printModuleNames();

        int userInputINT = intCheck();
        facade.setModule(userInputINT - 1);
        return false;
    }

    private static void quizLoader() {
        System.out.println(facade.getQuiz().getTitle());
        consoleBarrier();
        facade.getQuiz().printQuestions();

        int userInputINT = intCheck();
        return;
    }

    private static boolean moduleOptions() {
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

        return lessonPrint;
    }

    private static boolean printLessons() {
        System.out.println("Pick a lesson");
        consoleBarrier();
        facade.getModule().printLessonNames();

        int userInputINT = intCheck();
        facade.setLesson(userInputINT - 1);
        return false;
    }

    private static boolean loadUI() {
        int userInputINT = 0;
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
            modulePrint = printModules();
            return true;
        }

        if (!facade.hasModule()) {
            modulePrint = courseOptions();
            return true;
        }

        if (lessonPrint) {
            lessonPrint = printLessons();
            return true;
        }

        if (!facade.hasLesson()) {
            lessonPrint = moduleOptions();
            return true;
        }

        System.out.println(facade.getLesson().getContent());
        consoleBarrier();
        System.out.println("1. Go back");

        while (true) {
            userInputINT = intCheck();
            
            if (userInputINT == 1) {
                facade.setLesson(-1);
                return true;
            }
        }
    }

    public static void main(String[] args) {
        input = new Scanner(System.in);
        loadData();

        facade = new LMSFacade(input);
        clearTerminal();

        while (loadUI()) {
            clearTerminal();
        }

        clearTerminal();
        System.out.println("Goodbye");
        //saveData();
    }
}