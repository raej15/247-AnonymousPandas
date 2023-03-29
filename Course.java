/*
 * Written by Anonymous Pandas
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.UUID;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A course, which contains an ArrayList of modules, a name, a description, what language it's for
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
        cert = new FinalCertification();
    }

    /**
     * Course constructor used in the DataLoader class to assign all instance variables to Course
     * @param courseName name of the course
     * @param description description of the course
     * @param languageStr language of the course in the form of a string
     * @param author UUID of the user who made the course
     * @param grades hash map of grades
     * @param modules array list of type Module
     * @param courseComments array list of type Comment
     * @param students array list of UUID that keeps track of students currently enrolled in this course
     */
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

    /**
     * method that return corresponding string of language enum
     * @param language enum language 
     * @return string of the parameter
     */
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

    /**
     * method that gets the students enrolled in this course
     * @return Array list type UUID
     */
    public ArrayList<UUID> getStudents(){
        return students;
    }

    /**
     * method that get the course comments
     * @return array list of type comment
     */
    public ArrayList<Comment> getCourseComments(){
        return courseComments;
    }

    /**
     * method that gets the grades for this course
     * @return hashmap type UUID and ArrayList<Double> 
     */
    public HashMap<UUID, ArrayList<Double>> getGrades(){
        return grades;
    }

    /**
     * method that sets the enum language for this course
     * @param languageStr string of language brought in my user
     */
    public void setLanguage(String languageStr){
        if (languageStr.equalsIgnoreCase("javascript")){
            this.language=Language.JavaScript;
        } else if (languageStr.equalsIgnoreCase("python")) {
            this.language=Language.Python;
        }
    }

    /**
     * method that sets the author of this course
     * @param uuid ID of the author
     */
    public void setAuthor(UUID uuid){
        this.author = uuid;
    }

    /**
     * Adds a new module to the course
     * @param moduleName The name of the new module
     */
    public void addModule(String moduleName) {
        modules.add(new Module(moduleName));
        return;
    }

    /**
     * Adds a new comment directly to the course
     * @param commentContent The comment being left
     * @param commentor The author of the comment
     */
    public void addComment(String commentContent, UUID commentor) {
        courseComments.add(new Comment(commentor, commentContent, null));
        return;
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

    /**
     * method that sets the grades for this course
     * @param grades Hash map <UUID, ArrayList<Double> that has the grades
     */
    public void setGrades(HashMap<UUID, ArrayList<Double>> grades){
        this.grades = grades;
    }
    /**
     * method that sets the certification for this course
     * @param cert FinalCertification that is getting set to this course
     */
    public void setCert(FinalCertification cert){
        this.cert = cert;
    }

    /**
     * method that returns a string representation of student grades
     * @return String of grades
     */
    public String gradesToString() {
        String finalStr = "Student Grades:";
        for(Entry<UUID, ArrayList<Double>> entry: grades.entrySet()) {
            finalStr+="\n";
            finalStr+=entry;
        }
        return finalStr;
    }

    /**
     * method that prints out the modules name in this course
     */
    public void printModuleNames() {
        for(int i = 0; modules.size() > i; i++) {
            System.out.println(i + 1+": "+modules.get(i).getModuleName());
        }
    }

    /**
     * method that concatinates the instance variable of this course into a string
     * @return String representing of this course
     */
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

    /**
     * method that prints out the students in this course
     */
    public void printStudents(){
        for (UUID student:students){
            System.out.println(student);
        }
    }
    
   
    

    /**
     * method that tells the user if they have passed the certification exam 
     * @param grade grade of the quiz the user took
     */
    public void takeCert(double grade){
        if (grade > 75){
            System.out.println("Congraulations you passed the certification exam!");
            addUserCertifications();
        } else {
            System.out.println("Unfortunately, you did not pass.");
        }
    }

    /**
     * method that adds the certification to the list of certifications if the user passes the exam
     */
    public void addUserCertifications(){
        String str = "*************************************\n     Certificate of Completion\n             "+UI.getFacade().getUser().getFirstName().toUpperCase() + " " + UI.getFacade().getUser().getLastName().toUpperCase() + "\n   passed the certifcation exam for\n     " + courseName+"!\n*************************************";
        Student user = (Student) UI.getFacade().getUser();
        user.setCertification(str);
        System.out.println(str);
    }

    /**
     * method that writes the certifications to a text file
     */
    public void getCertificationFile() {
        String user = UI.getFacade().getUser().getFirstName();
        //System.out.println(getCertificate());
        String fileName = "txtFileTests//" + user + "FinalCert.txt";
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write("*************************************\n     Certificate of Completion\n             "+UI.getFacade().getUser().getFirstName().toUpperCase() + " " + UI.getFacade().getUser().getLastName().toUpperCase() + "\n   passed the certifcation exam for\n     " + courseName+"!\n*************************************");
            myWriter.close();
            System.out.println("Successfully wrote to file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    /**
     * method that adds a grade to the hash map of grades that corresponds with the current user
     * @param grade
     */
    public void setGrade(double grade){
        UUID current = UI.getFacade().getUser().getUUID();
        ArrayList<Double> userGrades = grades.get(current);
        userGrades.add(grade);
        grades.put(current, userGrades);
    }

    /**
     * method that checks if the list of modules is empty
     * @return boolean if the modules are empty or not
     */
    public boolean hasModules() {
        return !modules.isEmpty();
    }


    public boolean hasModuleAt(int index) {
        return (modules.size() > index && index > -1);
    }
}