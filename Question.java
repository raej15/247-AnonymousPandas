/*
 * Written by Anonymous Pandas
 */

 import java.util.ArrayList;

 public class Question {
      private ArrayList<String> answers;
      private String question;
      private int correstAnswer;

      Question(String question) {
        answers = new ArrayList<String>();
        this.question = question;
      }

      public void addAnswer(String answer) {
        answers.add(answer);
      }

      public void removeQuestion(String answer) {
        if (answers.size() == 0) {
            System.out.println("There are no answer to remove");
            return;
        }
        
        for (int i = 0; answers.size() > i; i++) {
            if (answers.get(i) == answer) {
                answers.remove(i);
                return;
            }
        }

        System.out.println("That answer could not be found");
    }
}