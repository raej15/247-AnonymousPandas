/*
 * Written by Anonymous Pandas
 */

/**
 * A lesson which consists of a name and its description, which is what the user will read
 */
public class Lesson {
    private String lessonName;
    private String description;

    /**
     * Creates a new lesson
     * @param lessonName The name of the lesson
     * @param description The content of the lesson
     */
    Lesson(String lessonName, String description) {
        this.lessonName = lessonName;
        this.description = description;
    }

    /**
     * Updates the lesson name to a new one
     * @param lessonName The new lesson name
     */
    public void updateLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    /**
     * Updates the description to a new one
     * @param description The new description
     */
    public void updateDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the name of the lesson
     * @return The lesson name
     */
    public String getLessonName() {
        return lessonName;
    }

    /**
     * Returns the lesson's description
     * @return The description of the lesson
     */
    public String getDescription() {
        return description;
    }
}