/*
 * Written by Anonymous Pandas
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.UUID;

/**
 * A course, which contains an ArrayList of modules, a name, a description, what language it's for, and if it's been completed
 */
public class Course {
    private ArrayList<Module> modules;
    private String courseName;
    private String description;
    private Language language;
    public HashMap<UUID, ArrayList<Long>> grades;
    public UUID author;

    /**
     * Creates a new course
     * @param courseName The name of the course
     * @param description What the course teachers the user
     * @param language Which language the course is for
     */
    Course(String courseName, String description, Language language) {
        modules = new ArrayList<Module>();
        this.courseName = courseName;
        this.description = description;
        this.language = language;
    }

    Course(UUID author, HashMap<UUID, ArrayList<Long>> grades){
        this.author = author;
        this.grades = grades;
    }

    /**
     * Adds a new module to the course
     * @param moduleName The name of the new module
     */
    public void addModule(String moduleName) {
        modules.add(new Module(moduleName));
    }

    /**
     * Updates the course name to something new
     * @param courseName The new course name
     */
    public void updateCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Updates the course description to something new
     * @param description The new description
     */
    public void updateDescription(String description) {
        this.description = description;
    }

    /**
     * Updates the language to a new language
     * @param language The new language
     */
    public void updateLanguage(Language language) {
        this.language = language;
    }

    /**
     * Gets the name of the course
     * @return courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Gets the description of the course
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the language that the course is for
     * @return language
     */
    public Language getLanguage() {
        return language;
    }
    public UUID getAuthorID(){
        return this.author;
    }
    
    /**
     * Returns a module based on the inputted name, if it exists
     * @param moduleName The module you want to get
     * @return A module object
     */
    public Module getModule(String moduleName) {
        if (modules.size() == 0) {
            System.out.println("There are no modules to get");
            return null;
        }
        
        for (int i = 0; modules.size() > i; i++) {
            if (modules.get(i).getModuleName().equals(moduleName)) {
                return modules.get(i);
            }
        }

        System.out.println("That module could not be found");
        return null;
    }

    /**
     * Removes a module via a name, if it exists
     * @param moduleName The module to remove
     */
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

    public void setGrades(HashMap<UUID, ArrayList<Long>> grades){
        this.grades = grades;
    }

/*
 * // iterating through key/value mappings
    System.out.print("Entries: ");
    for(Entry<String, String> entry: languages.entrySet()) {
      System.out.print(entry);
      System.out.print(", ");
    }
    }
 */

    public void getGrades() {
        // iterating through key/value mappings
        System.out.println("Student Grades: ");
        for(Entry<UUID, ArrayList<Long>> entry: grades.entrySet()) {
            System.out.println(entry);
            //System.out.print(", ");
        }
    }
}