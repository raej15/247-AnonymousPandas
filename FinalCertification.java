
/**
 * Final certification holds the official certificate for the users
 * @author Anonymous Pandas
 */
 public class FinalCertification{

    private Quiz quiz;

    /**
     * method constructor that sets each quiz to the FinalCertification
     */
    FinalCertification() {
        this.quiz = new Quiz();
    }

    /**
     * method that returns the quiz in the final certifcation
     * @return type quiz
     */
    public Quiz getQuiz(){
        return this.quiz;
    }

    /**
     * method that sets the quiz of this certification
     * @param quiz type quiz
     */
    public void setQuiz(Quiz quiz){
        this.quiz = quiz;
    }

 }