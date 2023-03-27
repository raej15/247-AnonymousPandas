/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Student extends User{

    ArrayList<String> certifications = new ArrayList<String>();

    public Student(UUID uuid, String firstName, String lastName, String email, String username, String password, ArrayList<String> certifications){
        super(username, password, email, firstName, lastName);
        super.uuid = uuid;
        super.type = 1;
        this.certifications = certifications;
    }

    public Student(String firstName, String lastName, String email, String username, String password){
        super(username, password, email, firstName, lastName);
        super.uuid = UUID.randomUUID();
        super.type = 1;
    }

    public ArrayList<String> getCertifications(){
        return certifications;
    }

    public void setCertification(String str){
        certifications.add(str);
    }

    public void printCertifications() {
        for(String cert: certifications) {
            System.out.println(cert+"\n");
        }
    }

    // loops through courseList - allows user to select and enroll in a course - adds user to haspmap of grades
    public void enrollCourse(){
        Scanner sc = new Scanner(System.in);
        int courseNumber = 1;
        for(Course course:UI.getFacade().getCourseList().getCourses()){
            System.out.println(courseNumber + ": "+"Course Name: "+course.getCourseName());
            System.out.println("Description: "+course.getDescription());
            System.out.println("Course Language: "+course.getLanguage().toString());
            courseNumber++;
        }
        System.out.println("What course would you like to enroll in?");
        int enrollIn = sc.nextInt();
        courseNumber = 1;
        for(Course course:UI.getFacade().getCourseList().getCourses()){
            if (courseNumber == enrollIn) {
                course.getGrades().put(UI.getFacade().getUser().getUUID(), new ArrayList<Double>());
                System.out.println("You have successfully been enrolled into the "+ course.getCourseName() + " course!");
            } else {
                System.out.println("That is invalid.");
                enrollCourse();
            }
            courseNumber++;
        }
    }
}