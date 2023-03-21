/*
 * Written by Anonymous Pandas
 */

import java.util.Scanner;

/**
 * I'm currently using this to test the code that I've written. This will need to be updated eventually
 */

public class UI {
    private static boolean modulePrint = false;
    private static boolean lessonPrint = false;
    private static boolean check = true;
    private static Scanner input;

    private static void clearTerminal() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    private static void consoleBarrier() {
        System.out.println("--------------------------------------------------");
    }

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
    private static void addCourses(LearningManagementSystemFacade facade) {
        if (check == true) {
            facade.getCourseList().addCourse(new Course("Python Basics", "The basics of python", Language.Python));
            facade.getCourseList().getCourse("Python Basics").addModule("The first week");
            facade.getCourseList().getCourse("Python Basics").getModule(0).addLesson("What are data types?", "This goes over various data types");
            check = false;
        }
    }

    private static void loadData() {
        DataLoader.loadCourses();
        //CourseList.getInstance().printCourses();
        DataLoader.loadUsers();
        UserList.getInstance().printUsers();
    }

    private static void saveData() {

    }

    private static void login(LearningManagementSystemFacade facade) {
        System.out.println("Please enter in your username");
        String userInput = input.nextLine();
        facade.setUser(userInput);
        return;
    }

    private static void courseSelect(LearningManagementSystemFacade facade) {
        System.out.println("You are logged in as "+facade.getUser().getUserName());
        consoleBarrier();

        System.out.println("Please select which course you wish to access");
        facade.getCourseList().printCourseNames();

        int userInputINT = intCheck();
        facade.setCourse(userInputINT);
        return;
    }

    private static boolean courseOptions(LearningManagementSystemFacade facade, boolean modulePrint) {
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

    private static boolean printModules(LearningManagementSystemFacade facade) {
        System.out.println("Pick a module");
        consoleBarrier();
        facade.getCourse().printModuleNames();

        int userInputINT = intCheck();
        facade.setModule(userInputINT - 1);
        return false;
    }

    private static void quizLoader(LearningManagementSystemFacade facade) {
        System.out.println(facade.getQuiz().getTitle());
        consoleBarrier();
        facade.getQuiz().printQuestions();

        int userInputINT = intCheck();
        return;
    }

    private static boolean moduleOptions(LearningManagementSystemFacade facade, boolean lessonPrint) {
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

    private static boolean printLessons(LearningManagementSystemFacade facade) {
        System.out.println("Pick a lesson");
        consoleBarrier();
        facade.getModule().printLessonNames();

        int userInputINT = intCheck();
        facade.setLesson(userInputINT - 1);
        return false;
    }

    private static void loadUI(LearningManagementSystemFacade facade) {
        int userInputINT = 0;

        addCourses(facade);

        if (!facade.hasUser()) {
            login(facade);
            return;
        }

        if (!facade.hasCourse()) {
            courseSelect(facade);
            return;
        }

        // This needs to be completed
        if (facade.hasQuiz()) {
            quizLoader(facade);
            return;
        }

        if (modulePrint) {
            modulePrint = printModules(facade);
            return;
        }

        if (!facade.hasModule()) {
            modulePrint = courseOptions(facade, modulePrint);
            return;
        }

        if (lessonPrint) {
            lessonPrint = printLessons(facade);
            return;
        }

        if (!facade.hasLesson()) {
            lessonPrint = moduleOptions(facade, lessonPrint);
            return;
        }

        System.out.println(facade.getLesson().getContent());
        consoleBarrier();
        System.out.println("1. Go back");

        while (true) {
            userInputINT = intCheck();
            
            if (userInputINT == 1) {
                facade.setLesson(-1);
                return;
            }
        }
    }

    public static void main(String[] args) {
        LearningManagementSystemFacade facade = new LearningManagementSystemFacade();
        input = new Scanner(System.in);
        loadData();

        while (true) {
            
            clearTerminal();

            loadUI(facade);
        }

        //saveData();
    }
}