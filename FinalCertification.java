
/*
 * Written by Anonmyous Pandas 
 */

 public class FinalCertification{

    private Quiz quiz;

    FinalCertification() {
        this.quiz = new Quiz();
    }

    public Boolean checkPassedStr(String passed){
        boolean toReturn = false;
        if (passed.equalsIgnoreCase("true")){
            toReturn = true;
        }
        return toReturn;
    }

    public Quiz getQuiz(){
        return this.quiz;
    }

    public void setQuiz(Quiz quiz){
        this.quiz = quiz;
    }

 }