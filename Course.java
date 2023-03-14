/*
 * Written by Anonymous Pandas
 */

 import java.util.ArrayList;

public class Course {
    private ArrayList<Module> modules;
    private String courseName;
    private String description;
    private Language language;
    private boolean completed;

    Course(String courseName, String description, Language language) {
        modules = new ArrayList<Module>();
        this.courseName = courseName;
        this.description = description;
        this.language = language;
        completed = false;
    }

    public void addModule(String moduleName) {
        modules.add(new Module(moduleName));
    }

    public void updateCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public void updateLanguage(Language language) {
        this.language = language;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public Language getLanguage() {
        return language;
    }
    
    public boolean getCompleted() {
        return completed;
    }

    public void removeModule(String moduleName) {
        if (modules.size() == 0) {
            System.out.println("There are no modules to remove");
            return;
        }
        
        for (int i = 0; modules.size() > i; i++) {
            if (modules.get(i).getModuleName().equals(moduleName)) {
                modules.remove(i);
                return;
            }
        }

        System.out.println("That module could not be found");
    }

    public void toggleCompleted() {
        completed = !completed;
    }
}