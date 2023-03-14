/*
 * Written by Anonymous Pandas
 */

import java.util.ArrayList;

public class Module {
    private ArrayList<Lesson> lessons;
    private String moduleName;
    private boolean completed;
    private Quiz quiz;

    Module(String moduleName) {
        lessons = new ArrayList<Lesson>();
        this.moduleName = moduleName;
        completed = false;
        quiz = new Quiz();
    }

    public void addLesson(String lesson, String description) {
        lessons.add(new Lesson(lesson, description));
    }

    public void updateModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public boolean getCompleted() {
        return completed;
    }

    public Quiz getQuiz() {
        return quiz;
    }

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

    public void toggleCompleted() {
        completed = !completed;
    }
}