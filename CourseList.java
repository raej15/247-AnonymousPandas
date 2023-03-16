
/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;

public class CourseList {

    private static CourseList courselist;
    public static ArrayList<Course> courses;

    private CourseList() {

    }
    public static CourseList getInstance(){
        if (courselist == null) {
			courselist = new CourseList();
		}
        return courselist;
    }

    public static void setCourseList(ArrayList <Course> courses){
        CourseList.courses = courses;
    }

    public Course getCourse(String courseName){
        return null;
    }

    public void removeCourse(String username){
       
    }

    public ArrayList<Course> getUsers() {
        return courses;
    }
}