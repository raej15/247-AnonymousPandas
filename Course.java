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
public class Course extends DataConstants{
    private ArrayList<Module> modules;
    private String courseName;
    private String description;
    private Language language;
    private FinalCertification cert;
    public HashMap<UUID, ArrayList<Double>> grades;
    public UUID author;
    public ArrayList<Comment> courseComments;
    public ArrayList<UUID> students;

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
        this.students = new ArrayList<UUID>();
        cert = new FinalCertification();
    }

    Course(String courseName, String description, String languageStr, UUID author, HashMap<UUID, ArrayList<Double>> grades, ArrayList<Module> modules,ArrayList<Comment> courseComments, ArrayList<UUID> students){
        this.courseName = courseName;
        this.description = description;
        setLanguage(languageStr);
        this.author = author;
        this.grades = grades;
        this.modules = modules;
        this.courseComments = courseComments;
        this.students = students;
    }

    public void setLanguage(String languageStr){
        if (languageStr.equalsIgnoreCase("javascript")){
            this.language=Language.JavaScript;
        } else if (languageStr.equalsIgnoreCase("python")) {
            this.language=Language.Python;
        }
    }

    public String getLanguageStr(Language language) {
        if (language == Language.JavaScript){
            return "JavaScript";
        } else if (language == Language.Python) {
            return "Python";
        } 
        return null;
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

    public ArrayList<Comment> getCourseComments(){
        return courseComments;
    }

    /**
     * Gets the description of the course
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public FinalCertification getCertificate() {
        return cert;
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

    public ArrayList<Module> getModules(){
        return modules;
    }
    
    /**
     * Returns a module based on the inputted name, if it exists
     * @param moduleName The module you want to get
     * @return A module object
     */
    public Module getModuleAtIndex(int moduleIndex) {
        if (modules.size() == 0) {
            System.out.println("There are no modules to get");
            return null;
        }
        
        if (modules.size() > moduleIndex) {
            return modules.get(moduleIndex);
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

    public void setGrades(HashMap<UUID, ArrayList<Double>> grades){
        this.grades = grades;
    }

    public String gradesToString() {
        String finalStr = "Student Grades:";
        for(Entry<UUID, ArrayList<Double>> entry: grades.entrySet()) {
            finalStr+="\n";
            finalStr+=entry;
        }
        return finalStr;
    }



    public void printModuleNames() {
        for(int i = 0; modules.size() > i; i++) {
            System.out.println(i + 1+": "+modules.get(i).getModuleName());
        }
    }

    public HashMap<UUID, ArrayList<Double>> getGrades(){
        return grades;
    }

    public String toString(){
        String finalStr =  BOLD+"Course Name: "+ this.courseName + RESET+"\nDescription: "+ this.description+"\nLanguage: "+this.language+"\nAuthor Id: "+this.author+ "\n"+gradesToString();
        for(Module module: modules) {
            finalStr+="\n";
            finalStr+=module.toString();
        }
        for (Comment comment: courseComments){
            finalStr+="\n";
            finalStr+=comment.toString();
        }
        return finalStr;
    }

    public void printStudents(){
        for (UUID student:students){
            System.out.println(student);
        }
    }

    public ArrayList<UUID> getStudents(){
        return students;
    }
}