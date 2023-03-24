/*
 * Written by Anonmyous Pandas 
 */

 public class FinalCertification{
    /* */
    //
    //private double grade;
    //private String title;
    private Quiz quiz;
    private Boolean passed;


    FinalCertification() {
        this.passed = false;
        this.quiz = new Quiz();
    }

    public Boolean checkPassedStr(String passed){
        boolean toReturn = false;
        if (passed.equalsIgnoreCase("true")){
            toReturn = true;
        }
        return toReturn;
    }

    public Boolean getPassed(){
        return this.passed;
    }

    public Quiz getQuiz(){
        return this.quiz;
    }

    public void setQuiz(Quiz quiz){
        this.quiz = quiz;
    }

    public void setPassed(String passed){
        if (passed.equalsIgnoreCase("true")){
            this.passed = true;
        } else {
            this.passed = false;
        }
    }
    //needs to be completed
    public void addFinalCertification() {

    }
    
    //public String getTitle() {
        //return title;
    //}
    
    /** 
     * @return double
     * get grade 
     */
    //public double getGrade() {
        //return this.grade;
    //}
    
    
    /** 
     * @return String
     */
    //might need to be changed later
    //public String toString() {
        //return "This User has recieved a certificate in " + certificate + " and a final grade of " + grade;
    //}
 }