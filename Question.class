/*
 * Written by Anonymous Pandas
 */

 import java.util.ArrayList;

 public class Question {
      private ArrayList<String> answers;
      private String question;
      private int correctAnswer;
      private int userAnswer;

      Question(String question) {
        answers = new ArrayList<String>();
        this.question = question;
        correctAnswer = -1;
        userAnswer = -1;
      }

      public void addAnswer(String answer) {
        answers.add(answer);
      }

      public void setCorrectAnswer(int answer) {
        correctAnswer = answer;
      }
      
      public void setUserAnswer(int answer) {
        userAnswer = answer;
      }

      public int getCorrectAnswer() {
        return correctAnswer;
      }

      public int getUserAnswer() {
        return userAnswer;
      }

      public String getQuestion() {
        return question;
      }

      public boolean hasUserAnswer() {
        if (userAnswer == -1) {
            return false;
        } else {
            return true;
        }
      }

      public void removeAnswer(String answer) {
        if (answers.size() == 0) {
            System.out.println("There are no answers to remove");
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

    public boolean isCorrect() {
        if (correctAnswer == userAnswer) {
            return true;
        }

        return false;
    }
}