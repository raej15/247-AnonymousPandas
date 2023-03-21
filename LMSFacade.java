/*
 * Written by Anonmyous Pandas 
 */

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Scanner;

public class LMSFacade {
    private CourseList courseList;
    private static UserList userList;
    private Course course;
    public User user;
    private CourseCreator courseCreator;
    private Module module;
    private Lesson lesson;
    private Quiz quiz;
    private Question question;
    private Comment comment;
    private Scanner input;
    private boolean check;
    private boolean modulePrint;
    private boolean lessonPrint;

    LMSFacade() {
        courseList = CourseList.getInstance();
        userList = UserList.getInstance();
        input = new Scanner(System.in);
        modulePrint = false;
        lessonPrint = false;
        check = true;
    }

    /**
     * This loads in the UI based on whichever variables are null
     */
    public void loadUI() {
        String userInput = "";
        int userInputINT = 0;

        addCourses();


        if (user == null) {
            System.out.println("Please enter in your username");
            userInput = input.nextLine();
            setUser(userInput);
            //System.out.println(courseList.currentCourses());
            return;
        }
        /*
        if (course == null) {
            System.out.println("You are logged in as "+user.getUserName());
            consoleBarrier();

            System.out.println("Please select which course you wish to access");
            courseList.printCourseNames();

            userInputINT = intCheck();
            setCourse(userInputINT);
            return;
        }

        // This needs to be completed
        if (quiz != null) {
            System.out.println(quiz.getTitle());
            consoleBarrier();
            quiz.printQuestions();

            userInputINT = intCheck();
            return;
        }

        if (modulePrint) {
            System.out.println("Pick a module");
            consoleBarrier();
            course.printModuleNames();

            userInputINT = intCheck();
            setModule(userInputINT - 1);
            modulePrint = false;
            return;
        }

        if (module == null) {
            System.out.println(course.getCourseName());
            consoleBarrier();

            System.out.println("1. Pick a module\n2. Take the certificate exam\n3. Go back");
            userInputINT = intCheck();

            if (userInputINT == 1) {
                modulePrint = true;
            } else if (userInputINT == 2) {
                setQuiz(1);
            } else if (userInputINT == 3) {
                course = null;
            } else {
                System.out.println("Please input a valid option");
            }

            return;
        }

        if (lessonPrint) {
            System.out.println("Pick a lesson");
            consoleBarrier();
            module.printLessonNames();

            userInputINT = intCheck();
            setLesson(userInputINT - 1);
            lessonPrint = false;
            return;
        }

        if (lesson == null) {
            System.out.println(module.getModuleName());
            consoleBarrier();

            System.out.println("1. Pick a lesson\n2. Take the quiz\n3. Go back");
            userInputINT = intCheck();

            if (userInputINT == 1) {
                lessonPrint = true;
            } else if (userInputINT == 2) {
                setQuiz(2);
            } else if (userInputINT == 3) {
                module = null;
            } else {
                System.out.println("Please input a valid option");
            }

            return;
        }

        System.out.println(lesson.getContent());
        consoleBarrier();
        System.out.println("1. Go back");

        while (true) {
            userInputINT = intCheck();
            
            if (userInputINT == 1) {
                lesson = null;
                return;
            }
        }
        */
    }

    /**
     * Im using this for testing purposes
     */
    private void addCourses() {
        if (check) {
            courseList.addCourse(new Course("Python Basics", "The basics of python", Language.Python));
            courseList.getCourse("Python Basics").addModule("The first week");
            courseList.getCourse("Python Basics").getModule(0).addLesson("What are data types?", "This goes over various data types");
            check = false;
        }
    }

    
    /** 
     * @param username
     */
    private void setUser(String username) {
        if (!userList.has(username)) {
            System.out.println("The user does not exist");
            return;
        }

        System.out.println("\nPlease enter in your password");
        User user = userList.getUser(username);
        String password = input.nextLine();

        if (!userList.login(user, password)) {
            System.out.println("The password is incorrect");
            return;
        }

        System.out.println("\nYou have logged in as "+username);
        this.user = user;
        return;
    }

    
    /** 
     * @param courseIndex
     */
    private void setCourse(int courseIndex) {
        if (!courseList.has(courseIndex)) {
            System.out.println("The course does not exist");
            return;
        }

        this.course = courseList.getCourse(courseIndex);
        return;
    }

    
    /** 
     * @param moduleIndex
     */
    private void setModule(int moduleIndex) {
        module = course.getModule(moduleIndex);
        return;
    }

    
    /** 
     * @param lessonIndex
     */
    private void setLesson(int lessonIndex) {
        lesson = module.getLesson(lessonIndex);
        return;
    }

    
    /** 
     * @param mode
     */
    private void setQuiz(int mode) {
        if (mode == 1) {
            quiz = course.getCertificate();
        } else if (mode == 2) {
            quiz = module.getQuiz();
        }
    }

    
    /** 
     * @param questionIndex
     */
    private void setQuestion(int questionIndex) {
        question = quiz.getQuestion(questionIndex);
    }

    private void setComment() {

    }
    
    private void consoleBarrier() {
        System.out.println("--------------------------------------------------");
    }

    
    /** 
     * @return int
     */
    private int intCheck() {
        String userInput = "";

        while (true) {
            userInput = input.nextLine();

            try {
                return Integer.parseInt(userInput);
            } catch (Exception e) {
                System.out.println("Please input a number");
            }
        }
    }

    
}
=======
 import java.util.Scanner;

 public class LMSFacade {
     private CourseList courseList;
     private UserList userList;
     private Course course;
     private User user;
     private CourseCreator courseCreator;
     private Module module;
     private Lesson lesson;
     private Quiz quiz;
     private Question question;
     private Comment comment;
     private Scanner input;
     private boolean check;
 
     LMSFacade(Scanner input) {
         courseList = CourseList.getInstance();
         userList = UserList.getInstance();
         this.input = input;
         check = true;
     }
 
     // Used for testing purposes
     public CourseList getCourseList() {
         return courseList;
     }
 
     public User getUser() {
         return user;
     }
 
     public Course getCourse() {
         return course;
     }
 
     public Module getModule() {
         return module;
     }
 
     public Lesson getLesson() {
         return lesson;
     }
 
     public Quiz getQuiz() {
         return quiz;
     }
 
     public boolean hasUser() {
         if (user == null) {
             return false;
         } else {
             return true;
         }
     }
 
     public boolean hasCourse() {
         if (course == null) {
             return false;
         } else {
             return true;
         }
     }
 
     public boolean hasModule() {
         if (module == null) {
             return false;
         } else {
             return true;
         }
     }
 
     public boolean hasLesson() {
         if (lesson == null) {
             return false;
         } else {
             return true;
         }
     }
 
     public boolean hasQuiz() {
         if (quiz == null) {
             return false;
         } else {
             return true;
         }
     }
 
     public void setUser(String username) {
         if (!userList.has(username)) {
             System.out.println("The user does not exist");
             return;
         }
 
         System.out.println("\nPlease enter in your password");
         User user = userList.getUser(username);
         String password = input.nextLine();
 
         if (!userList.login(user, password)) {
             System.out.println("The password is incorrect");
             return;
         }
 
         System.out.println("\nYou have logged in as "+username);
         this.user = user;
         return;
     }
 
     public void setCourse(int courseIndex) {
         if (courseIndex == -1) {
             course = null;
             return;
         }
 
         if (!courseList.has(courseIndex - 1)) {
             System.out.println("The course does not exist");
             return;
         }
 
         this.course = courseList.getCourse(courseIndex - 1);
         return;
     }
 
     public void setModule(int moduleIndex) {
         if (moduleIndex == -1)  {
             module = null;
             return;
         }
         
         module = course.getModule(moduleIndex);
         return;
     }
 
     public void setLesson(int lessonIndex) {
         if (lessonIndex == -1) {
             lesson = null;
             return;
         }
 
         lesson = module.getLesson(lessonIndex);
         return;
     }
 
     public void setQuiz(int mode) {
         if (mode == -1) {
             quiz = null;
             return;
         }
 
         if (mode == 1) {
             quiz = course.getCertificate();
         } else if (mode == 2) {
             quiz = module.getQuiz();
         }
     }
 
     public void setQuestion(int questionIndex) {
         if (questionIndex == -1) {
             question = null;
             return;
         }
 
         question = quiz.getQuestion(questionIndex);
     }
 
     //TODO fix this
     public void setComment(int commentIndex) {
         if (commentIndex == -1) {
             comment = null;
             return;
         }
     }
 }
>>>>>>> 696ada944cbc515d13fff588db7a7e351e57613b
