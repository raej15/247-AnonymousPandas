/*
 * Written by Anonymous Pandas
 */

import java.util.ArrayList;

public class Quiz {
     private ArrayList<Question> questions;
     private String title;

     Quiz() {
        questions = new ArrayList<Question>();
        title = "Quiz";
     }

     public void addQuestion(String question) {
        questions.add(new Question(question));
     }

     public void updateTitle(String title) {
        this.title = title;
     }

     public Question getQuestion(int index) {
        if (!(questions.size() > index)) {
            System.out.println("That is not an answer");
            return null;
        }

        return questions.get(index);
     }

     public String getTitle() {
        return title;
     }
}