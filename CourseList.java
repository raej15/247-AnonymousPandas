
/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;
import java.util.UUID;

public class CourseList extends DataConstants{
    public static ArrayList<Course> courses;
    private static CourseList courseList;

    private CourseList() {
        courses = new ArrayList<Course>();
        //courses.add(new Course("JavaScript", "JavaScript Basics", Language.JavaScript));
    }

    public static CourseList getInstance(){
        if (courseList == null) {
			courseList = new CourseList();
		}

        return courseList;
    }

    public static void setCourseList(ArrayList <Course> courses){
        CourseList.courses = courses;
    }

    public Course getCourse(String courseName){
        for(Course course : courses) {
            if(course.getCourseName().equals(courseName)) {
                return course;
            }
        }
        
        return null;
    }

    public Course getCourse(int index) {
        if (courses.size() > index) {
            return courses.get(index);
        }

        return null;
    }
    

    public boolean has(int index) {
        if (courses.size() > index) {
            return true;
        }

        return false;
    }

    public void removeCourse(String username){
       
    }

    public void printCourseNames() {
        for(int i = 0; courses.size() > i; i++) {
            System.out.println(i+": "+courses.get(i).getCourseName());
        }
    }

    public void printCourses(){
        for (Course course: courses) {
            System.out.println("------------------------------------------------------------------------");
            System.out.println(course.toString());
            System.out.println("------------------------------------------------------------------------");
        }
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course newCourse) {
        courses.add(newCourse);
    }

    public void printStudents(){
        for (Course course: courses){
            System.out.println(course.getCourseName());
            course.printStudents();
        }
    }
}