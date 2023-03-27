import java.util.Scanner;

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

    public void makeCert(){
        Scanner sc = new Scanner(System.in);
        Quiz newQuiz = new Quiz();
        String continueQuiz = "Y";
        while(continueQuiz.equals("Y")){
            if (newQuiz.getQuestions().size() == 0){
                newQuiz.newQuestion();
                continue;
            } else {
                System.out.println("Would you like to add a question? (Y/N)");
                continueQuiz = sc.nextLine();
            }
            if (continueQuiz.equals("N")) {
                return;
            } else if (continueQuiz.equals("Y")) {
                newQuiz.newQuestion();
            } else {
                System.out.println("Invalid input");
                continueQuiz = "Y";
                continue;
            }
        }
    }

 }