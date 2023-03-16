
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

        if (user == null) {
            System.out.println("Please enter in your username");
            userInput = input.nextLine();
            setUser(userInput);
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

        this.user = user;
        System.out.println("It worked");
        return;
    }

    private static void setCourse() {

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