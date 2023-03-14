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
        System.out.println(currentQuestion.isCorrect());
    }
}