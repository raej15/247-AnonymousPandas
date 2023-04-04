import java.util.ArrayList;

/**
 * A quiz which consists of a title and an ArrayList of questions
 * @author Anonymous Pandas
 */
public class Quiz extends DataConstants{
   //private static final int MAXNUMANSWERCHOICES = 5;
   private ArrayList<Question> questions;

   /**
    * Creates a new quiz for user 
    */
   Quiz() {
      questions = new ArrayList<Question>();
   }

   /**
    *  Returns an array list of questions 
    * @param questions
    */
   public Quiz(ArrayList<Question> questions ) {
      this.questions = questions;
   }

   /**
    * Returns an array List of questions
    * @return quiz questions 
    */
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
    * Returns questions 
    * @return Question names 
    */
   public String[] getQuestionNames() {
      String[] questionNames = new String[50];

      for(int i = 0; questions.size() > i; i++) {
          questionNames[i] = (i + 1 +": "+questions.get(i).getQuestion());
      }

      return questionNames;
   }

   /**
    * Returns index 
    * @return index 
    */
   public int getLastIndex() {
      return questions.size() - 1;
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

   /**
    * Prints each question 
    */
   public void printQuestions() {
      for(int i = 0; questions.size() > i; i++) {
         System.out.println(i+1+": "+questions.get(i).getQuestion());
      }
   }

     
   /** 
    * Returns each question and answer 
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