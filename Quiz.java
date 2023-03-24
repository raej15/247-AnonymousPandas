/*
 * Written by Anonymous Pandas
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A quiz which consists of a title and an ArrayList of questions
 */
public class Quiz extends DataConstants{
   private static final int MAXNUMANSWERCHOICES = 5;
     private ArrayList<Question> questions;

     /**
      * Creates a new quiz titled "Quiz"
      */
     Quiz() {
        questions = new ArrayList<Question>();
     }

     public Quiz(ArrayList<Question> questions ) {
        this.questions = questions;
     }

     public ArrayList<Question> getQuestions(){
      return questions;
     }

     /**
      * Adds a new question to the quiz
      * @param question The question
      */
     public void addQuestion(String question) {
        questions.add(new Question(question));
     }

     /**
      * Returns a question, if it exists
      * @param index The number of the question you want
      * @return A question object
      */
     public Question getQuestion(int index) {
        if (!(questions.size() > index)) {
            System.out.println("Invalid input");
            return null;
        }

        return questions.get(index);
     }
     
   /**
   * Removes a question, if it exist
   * @param question The question to remove
   */
   public void removeQuestion(String question) {
      if (questions.size() == 0) {
         System.out.println("There are no questions to remove");
         return;
      }
        
      for (int i = 0; questions.size() > i; i++) {
         if (questions.get(i).getQuestion().equals(question)) {
            questions.remove(i);
            return;
         }
      }

      System.out.println("That question could not be found");
   }

   public void printQuestions() {
      for(int i = 0; questions.size() > i; i++) {
         System.out.println(i+": "+questions.get(i).getQuestion());
      }
   }

     
     /** 
      * @return String
      */
     public String toString(){
        String finalStr = GREEN+BOLD+"\nQuiz"+RESET;
        for (Question question: questions) {
            finalStr+="\n";
            finalStr+=question.toString();
        }
        return finalStr;
     }

   public void newQuestion(){
      Scanner sc = new Scanner(System.in);
      ArrayList<String> answerChoices = new ArrayList<String>();
      System.out.println("What is the question?");
      String questiontitle = sc.nextLine();
      String continueAC = "Y";
      int numOfAnswerChoices = 0;
      while(continueAC.equals("Y")){
         if (numOfAnswerChoices == 0){
            System.out.println("What is the answer choice?");
            answerChoices.add(sc.nextLine());
            numOfAnswerChoices++;
            continue;
         } else {
            System.out.println("Would you like to add an answer choice? (Y/N)");
            continueAC = sc.nextLine();
         }
          if (continueAC.equals("N")|| numOfAnswerChoices >= MAXNUMANSWERCHOICES) {
               if (numOfAnswerChoices >= MAXNUMANSWERCHOICES)
                  System.out.println("Too many answer choices.");
               System.out.println("What is the correct answer? Please indicate using the corresponding number...");
               int index = 0;
               for (String ac: answerChoices){
                  System.out.println(index+": "+ac);
                  index++;
               }
              Question newQuestion = new Question(questiontitle, answerChoices, sc.nextInt());
              this.questions.add(newQuestion);
              return;
          } else if (continueAC.equals("Y")) {
              System.out.println("What is the answer choice?");
              answerChoices.add(sc.nextLine());
          } else {
              System.out.println("Invalid input");
              continueAC = "Y";
              continue;
          }
          numOfAnswerChoices++;
      }   
  }

  public void takeQuiz() {
   Scanner sc = new Scanner(System.in);
        int points = 0;
        int total = 0;
        int grade = 0;
        ArrayList<Question> questions = UI.getFacade().getModule().getQuiz().getQuestions();
        for (Question question: questions){
            total+=10;
            System.out.println(question.getQuestion());
            ArrayList<String> answerChoices = question.getAnswers();
            int counter = 0;
            for (String ac: answerChoices){
                System.out.println(counter+": "+ac);
            }
            int choice = sc.nextInt();
            if (choice == question.getCorrectIndex()){
                points+=10;
            }
        }
        grade = (points/total)*100;

        if (grade > 75){
            System.out.println("Congraulations you passed the quiz!");
        }
        // need current user to add grades to grade hashmap and current course
  }

  

}