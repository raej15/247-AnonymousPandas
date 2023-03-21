/*
 * Written by Anonmyous Pandas 
 */

 public class FinalCertification extends Quiz{
    private String certificate;
    private double grade;

    FinalCertification() {
        super.title = "Final Cert";
    }

    //needs to be completed
    public void addFinalCertification() {

    }
    public double getGrade() {
        return this.grade;
    }
    
    //might need to be changed later
    public String toString() {
        return "This User has recieved a certificate in " + certificate + " and a final grade of " + grade;
    }
 }