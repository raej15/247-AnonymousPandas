/*
 * Written by Anonymous Pandas
 */

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * A quiz which consists of a title and an ArrayList of questions
 */
public class Quiz {
     private ArrayList<Question> questions;
     private String title;

     /**
      * Creates a new quiz titled "Quiz"
      */
     Quiz() {
        questions = new ArrayList<Question>();
        title = "Quiz";
     }

     /**
      * Adds a new question to the quiz
      * @param question The question
      */
     public void addQuestion(String question) {
        questions.add(new Question(question));
     }

     /**
      * Updates the title to a new one
      * @param title The new title
      */
     public void updateTitle(String title) {
        this.title = title;
     }

     /**
      * Returns a question, if it exists
      * @param index The number of the question you want
      * @return A question object
      */
     public Question getQuestion(int index) {
        if (!(questions.size() > index)) {
            System.out.println("That is not an answer");
            return null;
        }

        return questions.get(index);
     }

     /**
      * Returns the quiz's title
      * @return The title
      */
     public String getTitle() {
        return title;
     }
/* 
 * 
*/
     
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
}