/*
 * Written by Anonymous Pandas
 */

 import java.util.ArrayList;

/**
 * A question (If an answer is set to -1, then that means it has not been set yet)
 */
public class Question extends DataConstants{
    private ArrayList<String> answers;
    private String question;
    public int correctIndex;

    /**
     * Creates a new question
     * @param question The question which the user must answer
     */
    Question(String question) {
        answers = new ArrayList<String>();
        this.question = question;
        correctIndex = -1;
    }

    Question(String question, ArrayList<String> answers, int correctIndex) {
        this.question = question;
        this.answers = answers;
        this.correctIndex = correctIndex;
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
    public void setCorrectIndex(int answer) {
        correctIndex = answer;
    }

    /**
     * Gets the correct answer
     * @return The correct answer
     */
    public int getCorrectIndex() {
        return correctIndex;
    }

    /**
     * Returns the question being asked
     * @return The question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Returns a string array of all the answers
     * @return An array of all the answers
     */
    public String[] getAnswerNames() {
        String[] answerNames = new String[50];

        for (int i = 0; answers.size() > i; i++) {
            answerNames[i] = (i + 1 +": "+answers.get(i));
        }

        return answerNames;
    }

    public ArrayList<String> getAnswers() {
        return answers;
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
     * 
     * @return
     */
    public boolean hasAnswers() {
        return !answers.isEmpty();
    }

    /**
     * 
     * @param index
     * @return
     */
    public boolean hasAnswerAt(int index) {
        return (answers.size() > index && index > -1);
    }

    
    /** 
     * @return String
     */
    public String toString(){
        String finalStr = GREEN+BOLD+"Question: "+RESET+GREEN+ question+RESET;
        for (String answer: answers) {
            finalStr+="\n\t";
            finalStr+=answer;
        }
        return finalStr;
    }
}