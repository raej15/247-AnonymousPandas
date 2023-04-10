import java.io.FileWriter;
 import java.io.IOException;

/**
 * A lesson which consists of a name and its description, which is what the user will read
 * @author Anonymous Pandas
 */
public class Lesson extends DataConstants{
    private String lessonName;
    private String content;

    /**
     * Creates a new lesson
     * @param lessonName The name of the lesson
     * @param content The content of the lesson
     */
    Lesson(String lessonName, String content) {
        this.lessonName = lessonName;
        this.content = content;
    }

    /**
     * Updates the lesson name to a new one
     * @param lessonName The new lesson name
     */
    public void updateLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    /**
     * Updates the content to a new one
     * @param content The new content
     */
    public void updateContent(String content) {
        this.content = content;
    }

    /**
     * Returns the name of the lesson
     * @return The lesson name
     */
    public String getLessonName() {
        return lessonName;
    }

    /**
     * Returns the lesson's content
     * @return The content of the lesson
     */
    public String getContent() {
        return content;
    }

    /**
     * toString() method that parses together lesson name and content and sets to correct colors
     */
    public String toString() {
        return BLUE+BOLD+"Lesson Name: " + this.lessonName +RESET+BLUE+ "\nContent: "+ this.content+RESET;
    }

    /**
     * method that returns lesson information
     * @return string of lesson information
     */
    public String bwToString() {
        return "Lesson Name: " + this.lessonName + "\nContent: "+ this.content;
    }

    /**
     * method that writes lesson files to a text file
     */
    public String getLessonFiles() {
        
        String user = UI.getFacade().getUser().getFirstName();
        String module = UI.getFacade().getModule().getModuleName();
        String name = getLessonName();
        String fileName = "txtFileTests//" + user + module + name + ".txt";
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(bwToString());
            myWriter.close();
            return ("Successfully wrote to file.");
          } catch (IOException e) {
            return ("An error occurred.");
            //e.printStackTrace();
          }
    }

}