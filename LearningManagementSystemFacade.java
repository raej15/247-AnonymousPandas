
/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class LearningManagementSystemFacade {
    private CourseList courseList;
    private UserList userList;
    private Course course;
    private User user;
    private CourseCreator courseCreator;
    private Module module;
    private Lesson lesson;
    private Quiz quiz;
    private Question question;
    private Comment comment;
    private Scanner input;

    LearningManagementSystemFacade() {
        courseList = CourseList.getInstance();
        userList = UserList.getInstance();
        input = new Scanner(System.in);
    }

    public void loadUI() {
        String userInput = "";
        int userInputINT = 0;

        if (user == null) {
            System.out.println("Please enter in your username");
            userInput = input.nextLine();
            setUser(userInput);
            return;
        }

        if (course == null) {
            System.out.println("You are logged in as "+user.getUserName());
            System.out.println("Please select which course you wish to access");
            courseList.printCourseNames();
            userInputINT = input.nextInt();
            setCourse(userInputINT);
            return;
        }

        if (module == null) {

        }
    }

    private void setUser(String username) {
        if (!userList.has(username)) {
            System.out.println("The user does not exist");
            return;
        }

        System.out.println("\nPlease enter in your password");
        User user = userList.getUser(username);
        String password = input.nextLine();

        if (!userList.login(user, password)) {
            System.out.println("The password is incorrect");
            return;
        }

        System.out.println("\nYou have logged in as "+username);
        this.user = user;
        return;
    }

    private void setCourse(int courseIndex) {
        if (!courseList.has(courseIndex)) {
            System.out.println("The course does not exist");
            return;
        }

        this.course = courseList.getCourse(courseIndex);
        return;
    }

    private static void setModule() {
        

    }

    private static void setLesson() {

    }

    private static void setQuiz() {

    }

    private static void setQuestion() {

    }

    private static void setComment() {

    }
}