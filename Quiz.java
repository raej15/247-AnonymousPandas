/*
 * Written by Anonymous Pandas
 */

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * A quiz which consists of a title and an ArrayList of questions
 */
public class Quiz extends DataConstants{
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
}