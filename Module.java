/*
 * Written by Anonymous Pandas
 */

import java.util.ArrayList;
import java.util.UUID;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A module which consists of an ArrayList of lessons, a module name, a boolean representing if it has been completed, and a quiz
 */
public class Module extends DataConstants{
    private ArrayList<Lesson> lessons;
    private String moduleName;
    private String description;
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


    /**
     * adding each module name, lesson, quiz, and comment to module 
     * @param moduleName gets name
     * @param lessons gets lesson 
     * @param quiz gets each quiz 
     * @param comments get comments 
     */
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
    public void addLesson(String lesson) {
        lessons.add(new Lesson(lesson, null));
    }

    
    /** 
     * adds the lesson content 
     * @param lesson the new lesson content 
     * @param content the description of content 
     */
    public void addLesson(String lesson, String content) {
        lessons.add(new Lesson(lesson, content));
    }

    /**
     * Adds a new comment directly to the course
     * @param commentContent The comment being left
     * @param commentor The author of the comment
     */
    public void addComment(String commentContent, UUID commentor) {
        comments.add(new Comment(commentor, commentContent, null));
        return;
    }

    /**
     * Changes the name of the module to a new name
     * @param moduleName The new nmodule name given 
     */
    public void updateModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    
    /** 
     * adds the description
     * @param description updating each descritpion 
     */
    public void updateDescription(String description) {
        this.description = description;
    }

    
    /** 
     * return lessons 
     * @return ArrayList<Lesson> 
     */
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

    /** 
     * return description
     * @return String of descriptions
     */
    public String getDescription() {
        return description;
    }
    
    /** 
     * return arraylist to get each updated comment 
     * @return ArrayList<Comment>
     */
    public ArrayList<Comment> getComments(){
        return comments;
    }

    
    /** 
     * get comments through array 
     * @return String[] of comments 
     */
    public String[] getCommentArray() {
        String[] commentArray = new String[50];

        for (int i = 0; comments.size() > i; i++) {
            commentArray[i] = comments.get(i).getComment();
        }

        return commentArray;
    }

    /**
     * Returns the quiz associated with the module
     * @return A quiz object
     */
    public Quiz getQuiz() {
        return quiz;
    }

    
    /** 
     * Returns the quiz questions associated with the module 
     * @return ArrayList<Question> quiz questions from arraylist 
     */
    public ArrayList<Question> getQuizQuestions(){
        return quiz.getQuestions();
    }

    /**
     * Returns a lesson from its name (if it exists)
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
     * Removes a lesson from its name, if it exists
     * @param lessonName The name of the lesson the user wants to remove
     */
    public int removeLesson(int lessonIndex) {
        if (lessons.size() == 0) {
            return 1;
        }
        
        if (0 > lessonIndex) {
            return 3;
        }

        if (lessons.size() > lessonIndex) {
            lessons.remove(lessonIndex);
            return 0;
        }

        return 2;
    }

    /**
     * Returns an array of strings of the lesson names in this module
     * @return An array of each lesson names
     */
    public String[] getLessonNames() {
        String[] lessonNames = new String[50];

        for(int i = 0; lessons.size() > i; i++) {
            lessonNames[i] = (i + 1+": "+lessons.get(i).getLessonName());
        }

        return lessonNames;
    }

    
    /** 
     * Reutrns module name 
     * @return String of each name 
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

    /**
     * Setting each quiz 
     * @param quiz gives quiz 
     */
    public void setQuiz(Quiz quiz){
        this.quiz = quiz;
    }

    /**
     * Returning each quiz grade with description, tells you if you pass and if else gives you another description 
     * @param grade 
     */
    public void takeQuiz(Double grade){
        if (grade > 75){
            System.out.println("Congraulations you passed the quiz!");
            addGrade(grade, null);
        } else {
            System.out.println("Unfortunately, you did not pass.");
        }
    }

    /**
     *  Adds grade and outprints final grade to user 
     * @param grade Sets grade and addes it 
     * @param user User gets grade
     * @return Returns description of final grade overall 
     */
    public String addGrade(double grade, User user){
        UI.getFacade().getCourse().setGrade(grade, user);
        return "Your final grade was "+grade;
    }

    /**
     * Gets each lesson content
     * @return Returns lesson name description and all content 
     */
    public String getLessonContents() {
        String allContent = "";
        for(int i = 0; lessons.size() > i; i++) {
            allContent = allContent + lessons.get(i).getLessonName() + "\n" + lessons.get(i).getContent() + "\n" ;
        } 

        return allContent;
    }

    /**
     * 
     */
    public void getModuleFiles() {    
        String user = UI.getFacade().getUser().getFirstName();
        String module = UI.getFacade().getModule().getModuleName();
        String fileName = "txtFileTests//" + user + module + "Lessons.txt";
        
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(getLessonContents());
            myWriter.close();
            System.out.println("Successfully wrote to file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    /**
     * 
     * @return
     */
    public boolean hasLessons() {
        return !lessons.isEmpty();
    }

    /**
     * 
     * @param index
     * @return
     */
    public boolean hasLessonAt(int index) {
        return (lessons.size() > index && index > -1);
    }
}