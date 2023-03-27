/*
 * Written by Anonymous Pandas
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.UUID;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A course, which contains an ArrayList of modules, a name, a description, what language it's for, and if it's been completed
 */ 
public class Course extends DataConstants{

    private ArrayList<Module> modules;
    private String courseName;
    private String description;
    private Language language;
    private FinalCertification cert = new FinalCertification();
    public HashMap<UUID, ArrayList<Double>> grades;
    public UUID author;
    public ArrayList<Comment> courseComments;
    public ArrayList<UUID> students;

    /**
     * Creates a new course
     * @param courseName The name of the course
     * @param description What the course teachers the user
     * @param language Which language the course is for
     * @param authorID The UUID of whoever created the course
     */
    Course(String courseName, String description, Language language, UUID authorID) {
        modules = new ArrayList<Module>();
        this.courseName = courseName;
        this.description = description;
        this.language = language;
        this.students = new ArrayList<UUID>();
        author = authorID;
        //cert = new FinalCertification();
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

    public String getLanguageStr(Language language) {
        if (language == Language.JavaScript){
            return "JavaScript";
        } else if (language == Language.Python) {
            return "Python";
        } 
        return null;
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
     * Returns the final certificate associated with the course
     * @return The final certificate
     */
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

    /**
     * Returns the UUID of the author
     * @return The UUID of the author
     */
    public UUID getAuthorID(){
        return this.author;
    }

    /**
     * Returns an ArrayList of modules for this course
     * @return An ArrayList of modules
     */
    public ArrayList<Module> getModules(){
        return modules;
    }
    
    /**
     * Returns a module based on the inputted index, if it exists
     * @param moduleIndex The index of the module you want to get
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

    public ArrayList<UUID> getStudents(){
        return students;
    }

    public ArrayList<Comment> getCourseComments(){
        return courseComments;
    }

    public HashMap<UUID, ArrayList<Double>> getGrades(){
        return grades;
    }

    public void setLanguage(String languageStr){
        if (languageStr.equalsIgnoreCase("javascript")){
            this.language=Language.JavaScript;
        } else if (languageStr.equalsIgnoreCase("python")) {
            this.language=Language.Python;
        }
    }

    public void setAuthor(UUID uuid){
        this.author = uuid;
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
     * Removes a module via a name, if it exists
     * @param moduleName The module to remove
     */
    public int removeModule(int moduleIndex) {
        if (modules.size() == 0) {
            return 1;
        }
        
        if (0 > moduleIndex) {
            return 3;
        }

        if (modules.size() > moduleIndex) {
            modules.remove(moduleIndex);
            return 0;
        }

        return 2;
    }

    public void setGrades(HashMap<UUID, ArrayList<Double>> grades){
        this.grades = grades;
    }

    public void setCert(FinalCertification cert){
        this.cert = cert;
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

    //TODO Fix this
    public void createModules() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the module name?");
        String moduleName = sc.nextLine();
        Module newModule = new Module(moduleName);
        modules.add(newModule);
        String continueModule = "Y";
            System.out.println("\nLESSONS:");
            while(continueModule.equals("Y")){
                if (newModule.getLessons().size() == 0){
                    newModule.createLesson();
                    continue;
                } else {
                    System.out.println("Would you like to add a lesson? (Y/N)");
                    continueModule = sc.nextLine();
                }
                if (continueModule.equals("N")) {
                    System.out.println("\nQUIZ:");
                    newModule.createQuiz();
                    return;
                } else if (continueModule.equals("Y")) {
                    newModule.createLesson();
                } else {
                    System.out.println("Invalid input");
                    continueModule = "Y";
                    continue;
                }
            }
    }

    public void createFinalCert() {
        System.out.println("\nFINAL CERTIFICATION:");
        this.cert.makeCert();

    }

    public void takeCert(){
        double grade = this.cert.getQuiz().takeQuiz();
        if (grade > 75){
            System.out.println("Congraulations you passed the certification exam!");
            addUserCertifications();
            //testing
            getCertificationFile();
        } else {
            System.out.println("Unfortunately, you did not pass.");
        }
    }

    public void addUserCertifications(){
        String str = "*************************************\n     Certificate of Completion\n             "+UI.getFacade().getUser().getFirstName().toUpperCase() + " " + UI.getFacade().getUser().getLastName().toUpperCase() + "\n   passed the certifcation exam for\n     " + courseName+"!\n*************************************";
        Student user = (Student) UI.getFacade().getUser();
        user.setCertification(str);
        System.out.println(str);
    }

    public void getCertificationFile() {
        String user = UI.getFacade().getUser().getFirstName();
        System.out.println(getFinalCert());
        String fileName = "txtFileTests//" + user + "FinalCert.txt";
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write("*************************************\n     Certificate of Completion\n             "+UI.getFacade().getUser().getFirstName().toUpperCase() + " " + UI.getFacade().getUser().getLastName().toUpperCase() + "\n   passed the certifcation exam for\n     " + courseName+"!\n*************************************");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public void setGrade(double grade){
        UUID current = UI.getFacade().getUser().getUUID();
        ArrayList<Double> userGrades = grades.get(current);
        userGrades.add(grade);
        grades.put(current, userGrades);
    }
    public boolean hasModules() {
        return !modules.isEmpty();
    }

    public boolean hasModuleAt(int index) {
        return (modules.size() > index && index > -1);
    }
}