
/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;

public class CourseList {
    public static ArrayList<Course> courses;
    private static CourseList courselist;

    private CourseList() {
        courses = new ArrayList<Course>();
        courses.add(new Course("JavaScript", "JavaScript Basics", Language.JavaScript));
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

    public void printCourses() {
        for(int i = 0; courses.size() > i; i++) {
            System.out.println(i+": "+courses.get(i).getCourseName());
        }
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}