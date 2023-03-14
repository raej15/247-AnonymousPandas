/*
 * Written by Anonymous Pandas
 */

/**
 * I'm currently using this to test the code that I've written. This will need to be updated eventually
 */
public class UI {
    public static void main(String[] args) {
        Course currentCourse = new Course("JavaScript", "A JavaScript course", Language.JavaScript);
        currentCourse.addModule("JavaScript Basics");

        Module currentModule = currentCourse.getModule("JavaScript Basics");
        currentModule.addLesson("Hello World", "Example Code\nMore Code\nLast Code\n\nThis outputs what is called a \"String\"\n");

        Lesson currentLesson = currentModule.getLesson("Hello World");
        System.out.println(currentLesson.getDescription());

        Quiz currentQuiz = currentModule.getQuiz();
        currentQuiz.addQuestion("What is \"Hello World\"?");

        Question currentQuestion = currentQuiz.getQuestion(0);
        System.out.println(currentQuestion.getQuestion());

        currentQuestion.addAnswer("A string");
        currentQuestion.addAnswer("An int");
        currentQuestion.addAnswer("A boolean");
        currentQuestion.getAnswers();

        currentQuestion.setCorrectAnswer(1);
        currentQuestion.setUserAnswer(2);

        System.out.println();
        currentQuiz.addQuestion("How many lines of code is this?\n20 Lines of code\n");

        currentQuestion = currentQuiz.getQuestion(1);
        System.out.println(currentQuestion.getQuestion());

        currentQuestion.addAnswer("5 Lines");
        currentQuestion.addAnswer("10 Lines");
        currentQuestion.addAnswer("20 Lines");
        currentQuestion.getAnswers();

        currentQuestion.setCorrectAnswer(2);
        currentQuestion.setUserAnswer(2);

        System.out.println();
        currentQuiz.addQuestion("What is an int");

        currentQuestion = currentQuiz.getQuestion(2);
        System.out.println(currentQuestion.getQuestion());

        currentQuestion.addAnswer("A datatype for storing numbers");
        currentQuestion.addAnswer("A datatype for storing ascii text");
        currentQuestion.addAnswer("Both of the above");
        currentQuestion.getAnswers();

        currentQuestion.setCorrectAnswer(0);
        currentQuestion.setUserAnswer(0);

        System.out.println();
        System.out.println(currentQuiz.getGrade()+"%");
    }
}