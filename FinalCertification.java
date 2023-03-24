/*
 * Written by Anonmyous Pandas 
 */

 public class FinalCertification extends Quiz{
    private String certificate;
    private double grade;
    private String title;

    FinalCertification() {
        this.title = "Final Cert";
    }

    //needs to be completed
    public void addFinalCertification() {

    }
    
    public String getTitle() {
        return title;
    }
    
    /** 
     * @return double
     * get grade 
     */
    public double getGrade() {
        return this.grade;
    }
    
    
    /** 
     * @return String
     */
    //might need to be changed later
    public String toString() {
        return "This User has recieved a certificate in " + certificate + " and a final grade of " + grade;
    }
 }