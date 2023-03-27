/*
 * Written by Anonymous Pandas
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 * A module which consists of an ArrayList of lessons, a module name, a boolean representing if it has been completed, and a quiz
 */
public class Module extends DataConstants{
    private ArrayList<Lesson> lessons;
    private String moduleName;
    private Quiz quiz;
    private ArrayList<Comment> comments;

    /**
     * Creates a new module
     * @param moduleName The name of the new module
     */
    Module(String moduleName) {
        lessons = new ArrayList<Lesson>();
        this.moduleName = moduleName;
        quiz = new Quiz();
    }


    Module(String moduleName, ArrayList<Lesson> lessons, Quiz quiz, ArrayList<Comment> comments) {
        this.moduleName = moduleName;
        this.lessons = lessons;
        this.quiz = quiz;
        this.comments = comments;
    }

    /**
     * Adds a new lesson to the module
     * @param lesson The name of the new lesson
     * @param description The description of the new lesson
     */
    public void addLesson(String lesson, String description) {
        lessons.add(new Lesson(lesson, description));
    }

    /**
     * Changes the name of the module to a new name
     * @param moduleName The new name
     */
    public void updateModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public ArrayList<Lesson> getLessons(){
        return lessons;
    }

    /**
     * Returns the name of the module
     * @return The module's name
     */
    public String getModuleName() {
        return moduleName;
    }

    public ArrayList<Comment> getComments(){
        return comments;
    }

    /**
     * Returns the quiz associated with the module
     * @return A quiz object
     */
    public Quiz getQuiz() {
        return quiz;
    }

    public ArrayList<Question> getQuizQuestions(){
        return quiz.getQuestions();
    }

    /**
     * Returns a lesson via its name, if it exists
     * @param lessonName The name of the lesson the user wants
     * @return A lesson
     */
    public Lesson getLessonbyIndex(int lessonIndex) {
        if (lessons.size() == 0) {
            System.out.println("There are no lessons to get");
            return null;
        }
        
        if (lessons.size() > lessonIndex) {
            return lessons.get(lessonIndex);
        }

        System.out.println("That lesson could not be found");
        return null;
    }
    
    /**
     * Removes a lesson via its name, if it exists
     * @param lessonName The name of the lesson the user wants to remove
     */
    public void removeLesson(String lessonName) {
        if (lessons.size() == 0) {
            System.out.println("There are no lessons to remove");
            return;
        }
        
        for (int i = 0; lessons.size() > i; i++) {
            if (lessons.get(i).getLessonName().equals(lessonName)) {
                lessons.remove(i);
                return;
            }
        }

        System.out.println("That lesson could not be found");
    }

    public void printLessonNames() {
        for(int i = 0; lessons.size() > i; i++) {
            System.out.println(i + 1+": "+lessons.get(i).getLessonName());
        }
    }

    
    /** 
     * @return String
     */
    public String toString(){
        String finalStr = RED+BOLD+"\nModule Name: "+ moduleName+RESET;
        for (Lesson lesson: lessons){
            finalStr+="\n";
            finalStr+=lesson.toString();
        }
        finalStr+=quiz.toString();
        for (Comment comment: comments){
            finalStr+="\n";
            finalStr+=comment.toString();
        }
        return finalStr;
    }
    

    public void createQuiz(){
        Scanner sc = new Scanner(System.in);
        Quiz newQuiz = new Quiz();
        setQuiz(newQuiz);
        String continueQuiz = "Y";
        while(continueQuiz.equals("Y")){
            if (newQuiz.getQuestions().size() == 0){
                newQuiz.newQuestion();
                continue;
            } else {
                System.out.println("Would you like to add a question? (Y/N)");
                continueQuiz = sc.nextLine();
            }
            if (continueQuiz.equals("N")) {
                return;
            } else if (continueQuiz.equals("Y")) {
                newQuiz.newQuestion();
            } else {
                System.out.println("Invalid input");
                continueQuiz = "Y";
                continue;
            }
        }
    }

    public void createLesson(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the lesson name?");
        String lessonName = sc.nextLine();
        System.out.println("What is the lesson content?");
        String lessonDescription = sc.nextLine();
        Lesson newLesson = new Lesson(lessonName, lessonDescription);
        lessons.add(newLesson);
    }

    public void setQuiz(Quiz quiz){
        this.quiz = quiz;
    }

    public void takeQuiz(){
        double grade = this.quiz.takeQuiz();
        if (grade > 75){
            System.out.println("Congraulations you passed the quiz!");
            addGrade(grade);
        } else {
            System.out.println("Unfortunately, you did not pass.");
        }
    }

    public void addGrade(double grade){
        UI.getFacade().getCourse().setGrade(grade);
    }
}