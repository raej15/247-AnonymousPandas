/*
 * Written by Anonymous Pandas
 */

import java.util.ArrayList;

/**
 * A module which consists of an ArrayList of lessons, a module name, a boolean representing if it has been completed, and a quiz
 */
public class Module {
    private ArrayList<Lesson> lessons;
    private String moduleName;
    private boolean completed;
    private Quiz quiz;

    /**
     * Creates a new module
     * @param moduleName The name of the new module
     */
    Module(String moduleName) {
        lessons = new ArrayList<Lesson>();
        this.moduleName = moduleName;
        completed = false;
        quiz = new Quiz();
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

    /**
     * Returns the name of the module
     * @return The module's name
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * Returns the state of the completed variable
     * @return True if it has been completed, false if it has not
     */
    public boolean getCompleted() {
        return completed;
    }

    /**
     * Returns the quiz associated with the module
     * @return A quiz object
     */
    public Quiz getQuiz() {
        return quiz;
    }

    /**
     * Returns a lesson via its name, if it exists
     * @param lessonName The name of the lesson the user wants
     * @return A lesson
     */
    public Lesson getLesson(String lessonName) {
        if (lessons.size() == 0) {
            System.out.println("There are no lessons to get");
            return null;
        }
        
        for (int i = 0; lessons.size() > i; i++) {
            if (lessons.get(i).getLessonName().equals(lessonName)) {
                return lessons.get(i);
            }
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

    /**
     * Changes the state of the completed variable
     */
    public void toggleCompleted() {
        completed = !completed;
    }
}