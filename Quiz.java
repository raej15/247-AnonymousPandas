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

     public double getGrade() {
        for (int i = 0; questions.size() > i; i++) {
            if (!questions.get(i).hasUserAnswer()) {
                System.out.println("You can't submit the quiz since you haven't answered all the questions");
                return -1;
            }
        }

        int correct = 0;

        for (int i = 0; questions.size() > i; i++) {
            if (questions.get(i).isCorrect()) {
                correct++;
            }
        }

        return correct/questions.size();
     }

     public void removeQuestion(String question) {
        if (questions.size() == 0) {
            System.out.println("There are no quizzes to remove");
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