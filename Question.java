/*
 * Written by Anonymous Pandas
 */

 import java.util.ArrayList;

/**
 * A question (If an answer is set to -1, then that means it has not been set yet)
 */
public class Question {
    private ArrayList<String> answers;
    private String question;
    private int correctAnswer;
    private int userAnswer;

    /**
     * Creates a new question
     * @param question The question which the user must answer
     */
    Question(String question) {
        answers = new ArrayList<String>();
        this.question = question;
        correctAnswer = -1;
        userAnswer = -1;
    }

    /**
     * Adds a new answer to the answer list
     * @param answer The possible answer to the question
     */
    public void addAnswer(String answer) {
        answers.add(answer);
    }

    /**
     * Sets an answer as correct
     * @param answer The correct answer's number
     */
    public void setCorrectAnswer(int answer) {
        correctAnswer = answer;
    }
    
    /**
     * Stores the user's answer
     * @param answer The user's answer
     */
    public void setUserAnswer(int answer) {
        userAnswer = answer;
    }

    /**
     * Gets the correct answer
     * @return The correct answer
     */
    public int getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Gets the user's answer
     * @return The user's answer
     */
    public int getUserAnswer() {
        return userAnswer;
    }

    /**
     * Returns the question being asked
     * @return The question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Prints out all of the answers
     */
    public void getAnswers() {
        if (answers.size() == 0) {
            System.out.println("There are no answers to return");
            return;
        }

        for (int i = 0; answers.size() > i; i++) {
            System.out.println(i+": "+answers.get(i));
        }
    }

    /**
     * Checks if the user has answered this question
     * @return True if the user has, false if not
     */
    public boolean hasUserAnswer() {
        if (userAnswer == -1) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Removes an answer from the answer list
     * @param answer The answer being removed
     */
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

    /**
     * Checks if the user's answer is correct
     * @return True if the user is correct, false if not
     */
    public boolean isCorrect() {
        if (correctAnswer == userAnswer) {
            return true;
        }

        return false;
    }
}