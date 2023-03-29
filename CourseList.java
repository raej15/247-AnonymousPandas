
/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;

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

    public void printCourseNames() {
        for(int i = 0; courses.size() > i; i++) {
            System.out.println(i+1+": "+courses.get(i).getCourseName());
        }
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
    public void printEnrolledCourses(){
        int numOfCoursesEnrolled = 0;
        for(Course course:UI.getFacade().getCourseList().getCourses()){
            if (course.getGrades().containsKey(UI.getFacade().getUser().getUUID())) {
                System.out.println(numOfCoursesEnrolled+": "+course.getCourseName());
                numOfCoursesEnrolled++;
            }
        }
        if (numOfCoursesEnrolled == 0){
            System.out.println("You are not enrolled into any courses!");
        }
    }
}