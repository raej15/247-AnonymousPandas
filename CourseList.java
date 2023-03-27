
/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class CourseList extends DataConstants{
    public static ArrayList<Course> courses;
    private static CourseList courseList = new CourseList();
    
/* 
    public static void main(String[] args){
        DataLoader.loadUsers();
        DataLoader.loadCourses();
        DataWriter2.saveUsers();
        DataWriter2.saveCourses();
        
        courseList.addCourse();
        DataWriter2.saveCourses();
    }

    private CourseList() {
        //courses = new ArrayList<Course>();
        //DataLoader.loadCourses();
        //courses = DataLoader.loadCourses();
        //courses.add(new Course("JavaScript", "JavaScript Basics", Language.JavaScript));
    }
*/
    
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

    public void addCourse() {
        Scanner sc = new Scanner(System.in);
        Language lan = selectLanguages();
        System.out.println("What is the course name?");
        String courseName = sc.nextLine();
        System.out.println("What is the course description?");
        String courseDescription = sc.nextLine();
        Course newCourse = new Course(courseName,courseDescription, lan, null);
        newCourse.setAuthor(UI.getFacade().getUser().getUUID());
        addCourse(newCourse); // adding course to the courseList
        System.out.println("\nMODULES:");
        String continueCourse = "Y";
            while(continueCourse.equals("Y")){
                if (newCourse.getModules().size() == 0) {
                   newCourse.createModules();
                   continue;
                } else {
                    System.out.println("MODULES:\nWould you like to add a module? (Y/N)");
                    continueCourse = sc.nextLine();
                }
                if (continueCourse.equals("N")) {
                    newCourse.createFinalCert();
                    return;
                } else if (continueCourse.equals("Y")) {
                    newCourse.createModules();
                } else {
                    System.out.println("Invalid input");
                    continueCourse = "Y";
                    continue;
                }
            }
    }

    public Language selectLanguages(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What language would you like your course to be?");
        Language languages[] = Language.values();
        int counter = 0;
        for(Language language: languages) {
            System.out.println(counter+": "+language.toString());
            counter++;
        }
        int selectedLanguage = sc.nextInt();
        return languages[selectedLanguage];
    }
}