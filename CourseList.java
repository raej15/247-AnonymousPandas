
/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;

public class CourseList {
    private static CourseList courseList = new CourseList();
    private ArrayList<Course> courses;

    private CourseList() {

    }

    public static CourseList getInstance() {
        return courseList;
    }
}