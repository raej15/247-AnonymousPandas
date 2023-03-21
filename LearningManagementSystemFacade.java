/*
 * Written by Anonmyous Pandas 
 */

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
    private boolean check;

    LearningManagementSystemFacade() {
        courseList = CourseList.getInstance();
        userList = UserList.getInstance();
        input = new Scanner(System.in);
        check = true;
    }

    // Used for testing purposes
    public CourseList getCourseList() {
        return courseList;
    }

    public User getUser() {
        return user;
    }

    public Course getCourse() {
        return course;
    }

    public Module getModule() {
        return module;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public boolean hasUser() {
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasCourse() {
        if (course == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasModule() {
        if (module == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasLesson() {
        if (lesson == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasQuiz() {
        if (quiz == null) {
            return false;
        } else {
            return true;
        }
    }

    public void setUser(String username) {
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

    public void setCourse(int courseIndex) {
        if (courseIndex == -1) {
            course = null;
            return;
        }

        if (!courseList.has(courseIndex)) {
            System.out.println("The course does not exist");
            return;
        }

        this.course = courseList.getCourse(courseIndex);
        return;
    }

    public void setModule(int moduleIndex) {
        if (moduleIndex == -1)  {
            module = null;
            return;
        }
        
        module = course.getModule(moduleIndex);
        return;
    }

    public void setLesson(int lessonIndex) {
        if (lessonIndex == -1) {
            lesson = null;
            return;
        }

        lesson = module.getLesson(lessonIndex);
        return;
    }

    public void setQuiz(int mode) {
        if (mode == -1) {
            quiz = null;
            return;
        }

        if (mode == 1) {
            quiz = course.getCertificate();
        } else if (mode == 2) {
            quiz = module.getQuiz();
        }
    }

    public void setQuestion(int questionIndex) {
        if (questionIndex == -1) {
            question = null;
            return;
        }

        question = quiz.getQuestion(questionIndex);
    }

    //TODO fix this
    public void setComment(int commentIndex) {
        if (commentIndex == -1) {
            comment = null;
            return;
        }
    }
}