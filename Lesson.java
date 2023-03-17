/*
 * Written by Anonymous Pandas
 */

/**
 * A lesson which consists of a name and its description, which is what the user will read
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

    public String toString() {
        return BLUE+BOLD+"Lesson Name: " + this.lessonName +RESET+BLUE+ "\nContent: "+ this.content+RESET;
    }
}