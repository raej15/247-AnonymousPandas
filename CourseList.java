
/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

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
     * @param username
     */
    public void removeCourse(String username){
       
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
        // set current user as author ---- TODO FIX
        UUID authorID = UUID.randomUUID();
        Language lan = selectLanguages();
        System.out.println("What is the course name?");
        String courseName = sc.nextLine();
        System.out.println("What is the course description?");
        String courseDescription = sc.nextLine();
        Course newCourse = new Course(courseName,courseDescription, lan);
        newCourse.setAuthor(authorID);
        addCourse(newCourse);
        String continueCourse = "Y";
            while(continueCourse.equals("Y")){
                System.out.println("Would you like to add a module? (Y/N)");
                continueCourse = sc.nextLine();
                if (continueCourse.equals("N")) {
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
        String strLanguages[] = new String[languages.length];
        int counter = 0;
        for(Language language: languages) {
            System.out.println(language.toString());
            strLanguages[counter] = language.toString();
            counter++;
        }
        String selectedLanguage = sc.nextLine().toUpperCase();
        for (int i = 0; i < strLanguages.length; i++) {
            if(selectedLanguage.equals(strLanguages[i].toUpperCase())) {
                return languages[i];
            }
        }
        return null;
    }
}