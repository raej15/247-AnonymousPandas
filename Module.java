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

    public void addLesson() {
        lessons.add(new Lesson());
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
    
    public void toggleCompleted() {
        completed = !completed;
    }
}