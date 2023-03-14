/*
 * Written by Anonymous Pandas
 */

public class UI {
    public static void main(String[] args) {
        Course newCourse = new Course("JavaScript", "A JavaScript course", Language.JavaScript);
        newCourse.toggleCompleted();
        System.out.println(newCourse.getCompleted());
        newCourse.toggleCompleted();
        System.out.println(newCourse.getCompleted());
    }
}