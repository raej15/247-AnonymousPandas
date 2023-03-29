/*
 * Written by Anonymous Pandas
 */

import java.util.ArrayList;
/**
 * A quiz which consists of a title and an ArrayList of questions
 */
public class Quiz extends DataConstants{
   //private static final int MAXNUMANSWERCHOICES = 5;
   private ArrayList<Question> questions;

   /**
    * Creates a new quiz
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

   public String[] getQuestionNames() {
      String[] questionNames = new String[50];

      for(int i = 0; questions.size() > i; i++) {
          questionNames[i] = (i + 1+": "+questions.get(i).getQuestion());
      }

      return questionNames;
   }

   public int getLastIndex() {
      int lastIndex = 0;
      for(int i = 0; i < questions.size(); i++) {
         lastIndex = i;
      }

      return lastIndex;
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
         System.out.println(i+1+": "+questions.get(i).getQuestion());
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