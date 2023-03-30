/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;
import java.util.UUID;

public class CourseList extends DataConstants{
    public static ArrayList<Course> courses;
    private static CourseList courseList = new CourseList();
    
    /** 
     * @return CourseList
     */
    public static CourseList getInstance(){
        if (courseList == null) {
			courseList = new CourseList();
            System.out.println("Course List is null - debugging - Class UserList line 38");
		}
        return courseList;
    }

    
    /** 
     * @param courses 
     * setcourselist 
     */
    public static void setCourseList(ArrayList <Course> courses){
        CourseList.courses = courses;
    }

    
    /** 
     * @param courseName 
     * @return Course
     */
    public Course getCourse(String courseName){
        for(Course course : courses) {
            if(course.getCourseName().equals(courseName)) {
                return course;
            }
        }
        
        return null;
    }

    
    /** 
     * @param index
     * @return Course
     */
    public Course getCourse(int index) {
        if (courses.size() > index) {
            return courses.get(index);
        }

        return null;
    }

     
    /** 
     * determines if courses contains a specific index
     * @param index
     * @return boolean
     */
    public boolean has(int index) {
        if (courses.size() > index) {
            return true;
        }

        return false;
    }

    
    /** 
     * Selects a course to remove
     * @param course
     */
    public void removeCourse(Course course){
        courses.remove(course);
    }

    /**
     * Removes the course at the index
     * @param index The location of the course being removed
     */
    public void removeCourseIndex(int index) {
        courses.remove(index);
    }

    /**
     * Returns an array of strings of the course names in the course list
     * @return An array of course names
     */
    public String[] getCourseNames() {
        String[] courseNames = new String[50];

        for(int i = 0; courses.size() > i; i++) {
            courseNames[i] = (i+1+": "+courses.get(i).getCourseName());
        }

        return courseNames;
    }

    public void printCourses(){
        for (Course course: courses) {
            System.out.println("------------------------------------------------------------------------");
            System.out.println(course.toString());
            System.out.println("------------------------------------------------------------------------");
        }
    }

    
    /** 
     * @return ArrayList<Course>
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    
    /** 
     * @param newCourse 
     * add newcourse 
     */
    public void addCourse(Course newCourse) {
        courses.add(newCourse);
    }

    public void printStudents(){
        for (Course course: courses){
            System.out.println(course.getCourseName());
            course.printStudents();
        }
    }


    // loops through courseList and returns a list of courses that the student is enrolled in
    public String[] printEnrolledCourses(UUID userID){
        String[] enrolledCoursesList = new String[10];
        int numOfCoursesEnrolled = 0;
        int index = 0;

        for(Course course:courseList.getCourses()){
            if (course.getGrades().containsKey(userID)) {
                enrolledCoursesList[index] = (index + 1 +". "+course.getCourseName());
                numOfCoursesEnrolled++;
            }

            index++;
        }
        
        if (numOfCoursesEnrolled == 0){
            enrolledCoursesList[0] = "You are not enrolled into any courses!";
            return enrolledCoursesList;
        }

        return enrolledCoursesList;
    }
}