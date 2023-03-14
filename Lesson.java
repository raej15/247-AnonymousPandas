/*
 * Written by Anonymous Pandas
 */

public class Lesson {
    private String lessonName;
    private String description;

    Lesson(String lessonName, String description) {
        this.lessonName = lessonName;
        this.description = description;
    }

    public void updateLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public String getLessonName() {
        return lessonName;
    }

    public String getDescription() {
        return description;
    }
}