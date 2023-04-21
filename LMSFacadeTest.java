import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class LMSFacadeTest {

    @Test
    void registerUser() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();
        int size = facade.getUserList().getUsers().size();
        facade.register("JSmith02", "SecurePass", "JSmith@gmail.com", "John", "Smith", 1);
        assertEquals(size + 1, facade.getUserList().getUsers().size());
    }

    @Test
    void registerNullIsIgnored() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();
        int size = facade.getUserList().getUsers().size();
        facade.register(null, null, null, null, null, 1);
        assertEquals(size, facade.getUserList().getUsers().size());
    }

    @Test
    void registerEmptyIsIgnored() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();
        int size = facade.getUserList().getUsers().size();
        facade.register("", "", "", "", "", 1);
        assertEquals(size, facade.getUserList().getUsers().size());
    }

    @Test
    void registerInvalidTypeIsIgnored() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();
        int size = facade.getUserList().getUsers().size();
        facade.register("Omega14", "Kaix15", "Omega14ls@hotmail.com", "Mai", "Kai", 6);
        assertEquals(size, facade.getUserList().getUsers().size());
    }

    @Test
    void registerDuplicateIsIgnored() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();
        int size = facade.getUserList().getUsers().size();
        facade.register("MaxMan14", "Locked4You", "Maxwell01@gmail.com", "Maxwell", "White", 1);
        facade.register("MaxMan14", "Locked4You", "Maxwell01@gmail.com", "Maxwell", "White", 1);
        assertEquals(size + 1, facade.getUserList().getUsers().size());
    }

    @Test
    void setUser() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();
        facade.setUser(new Student("MaxMan14", "Locked4You", "Maxwell01@gmail.com", "Maxwell", "White"));
        assertEquals(true, facade.hasUser());
    }

    @Test
    void setUserNull() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();
        facade.setUser(null);
        assertEquals(false, facade.hasUser());
    }

    @Test
    void setUserDefaultUserIsRejected() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();
        facade.setUser(new User("MaxMan14", "Locked4You", "Maxwell01@gmail.com", "Maxwell", "White"));
        assertEquals(false, facade.hasUser());
    }

    @Test
    void setEnrolledCourse() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "test", Language.JavaScript);

        String[] enrolledCourses = new String[2];
        enrolledCourses[0] = "Introduction to JavaScript";
        
        assertEquals(0, facade.setEnrolledCourse(enrolledCourses, 0));
    }

    @Test
    void setEnrolledCourseInvalidIndexIsRejected() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        String[] enrolledCourses = new String[2];
        enrolledCourses[0] = "Introduction to JavaScript";

        assertEquals(1, facade.setEnrolledCourse(enrolledCourses, 10));
    }

    @Test
    void setEnrolledCourseNotEnrolledIsRejected() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);

        String[] enrolledCourses = new String[2];
        enrolledCourses[0] = "Introduction to JavaScript";

        assertEquals(2, facade.setEnrolledCourse(enrolledCourses, 1));
    }

    @Test
    void setEnrolledCourseNullArrayIsRejected() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);

        String[] enrolledCourses = null;
        assertEquals(2, facade.setEnrolledCourse(enrolledCourses, 0));
    }

    @Test
    void setCourse() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);

        int result = facade.setCourse(1);
        assertEquals(0, result);
    }

    @Test
    void setCourseInvalidIsRejected() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);

        int result = facade.setCourse(99);
        assertEquals(1, result);
    }

    @Test
    void setCourseRemoveCourse() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);

        int result = facade.setCourse(0);
        result = facade.setCourse(-1);

        assertEquals(0, result);
    }

    @Test
    void setModule() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.addModule("Introduction");
        facade.setModule(0);

        assertEquals(true, facade.hasModule());
    }

    @Test
    void setModuleInvalidIsRejected() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.addModule("Introduction");
        facade.setModule(99);

        assertEquals(false, facade.hasModule());
    }

    @Test
    void setModuleRemove() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.addModule("Introduction");
        facade.setModule(0);
        facade.setModule(-1);

        assertEquals(false, facade.hasModule());
    }

    @Test
    void setLesson() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.addModule("Introduction");
        facade.setModule(0);

        facade.addLesson("The basics");
        facade.setLesson(0);
        assertEquals(true, facade.hasLesson());
    }

    @Test
    void setLessonInvalidIsRejected() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.addModule("Introduction");
        facade.setModule(0);

        facade.addLesson("The basics");
        facade.setLesson(99);
        assertEquals(false, facade.hasLesson());
    }

    @Test
    void setTestRemove() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();
        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Test", "Test", Language.Python);
        facade.setCourse(0);
        facade.addModule("Test");
        facade.setModule(0);
        facade.addLesson("Test");
        facade.setLesson(0);
        facade.setLesson(-1);
        assertEquals(false, facade.hasLesson());
    }

    @Test
    void setQuizCourse() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);
        facade.setQuiz(1);

        assertEquals(true, facade.hasQuiz());
    }

    @Test
    void setQuizModule() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.addModule("Introduction");
        facade.setModule(0);
        facade.setQuiz(2);

        assertEquals(true, facade.hasQuiz());
    }

    @Test
    void setQuizInvalidIsRejected() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.addModule("Introduction");
        facade.setModule(0);

        facade.setQuiz(99);
        assertEquals(false, facade.hasQuiz());
    }

    @Test
    void setQuizRemove() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.setQuiz(1);
        facade.setQuiz(-1);

        assertEquals(false, facade.hasQuiz());
    }

    @Test
    void setQuestion() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);
        
        facade.setQuiz(1);
        facade.getQuiz().addQuestion("This is a question");
        facade.setQuestion(0);

        assertEquals(true, facade.hasQuestion());
    }

    @Test
    void setQuestionInvalidIsRejected() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);
        
        facade.setQuiz(1);
        facade.getQuiz().addQuestion("This is a question");        
        facade.setQuestion(99);

        assertEquals(false, facade.hasQuestion());
    }

    @Test
    void setQuestionRemove() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);
        
        facade.setQuiz(1);
        facade.getQuiz().addQuestion("This is a question");
        facade.setQuestion(0);
        facade.setQuestion(-1);

        assertEquals(false, facade.hasQuestion());
    }

    @Test
    void setCommentCourse() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.getCourse().setCommentArray(new ArrayList<Comment>());
        facade.addComment("This is a comment", 1);
        facade.setComment(0, 1);

        assertEquals(true, facade.hasComment());
    }

    @Test
    void setCommentModule() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.addModule("Introduction");
        facade.setModule(0);

        facade.getModule().setCommentArray(new ArrayList<Comment>());
        facade.addComment("This is a comment", 2);
        facade.setComment(0, 2);

        assertEquals(true, facade.hasComment());
    }

    @Test
    void setCommentReply() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();
        
        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.getCourse().setCommentArray(new ArrayList<Comment>());
        facade.addComment("This is a comment", 1);
        facade.setComment(0, 1);

        facade.addComment("This is a reply", 3);
        facade.setComment(0, 3);
        assertEquals(true, facade.hasComment());
    }

    @Test
    void setCommentInvalidIndexIsIgnored() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.getCourse().setCommentArray(new ArrayList<Comment>());
        facade.setComment(99, 1);
        assertEquals(false, facade.hasComment());
    }

    @Test
    void setCommentInvalidModeModule() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.getCourse().setCommentArray(new ArrayList<Comment>());
        facade.setComment(0, 99);
        assertEquals(false, facade.hasComment());
    }

    @Test
    void addCourse() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        int result = facade.getCourseList().getCourses().size();

        facade.addCourse("Python 3 Basics", "This teaches the basics of Python 3", Language.Python);;
        assertEquals(result + 1, facade.getCourseList().getCourses().size());
    }

    @Test
    void addCourseRejectDuplicate() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        int result = facade.getCourseList().getCourses().size();

        facade.addCourse("Python Tricks", "This teaches a few tricks for Python", Language.Python);;
        facade.addCourse("Python Tricks", "This teaches a few tricks for Python", Language.Python);;
        assertEquals(result + 1, facade.getCourseList().getCourses().size());
    }

    @Test
    void addCourseRejectEmptyCourse() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        int result = facade.getCourseList().getCourses().size();

        facade.addCourse(null, null, null);
        assertEquals(result, facade.getCourseList().getCourses().size());
    }

    @Test
    void removeCourse() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        
        int result = facade.removeCourse(0);
        assertEquals(0, result);
    }

    @Test
    void removeCourseInvalidIsIgnored() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        
        int result = facade.removeCourse(99);
        assertEquals(1, result);
    }

    @Test
    void addModule() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        int result = facade.getCourse().getModules().size();
        
        facade.addModule("A quick introduction");
        assertEquals(result + 1, facade.getCourse().getModules().size());
    }

    @Test
    void addModuleNullIsRejected() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        int result = facade.getCourse().getModules().size();
        
        facade.addModule(null);
        assertEquals(result, facade.getCourse().getModules().size());
    }

    @Test
    void removeModule() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.getCourse().addModule("Introduction");
        int result = facade.removeModule(0);

        assertEquals(0, result);
    }
    
    @Test
    void removeModuleInvalidIsIgnored() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.getCourse().addModule("Introduction");
        int result = facade.removeModule(33);

        assertEquals(2, result);
    }

    @Test
    void addLesson() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.addModule("Introduction");
        facade.setModule(0);

        int result = facade.getModule().getLessons().size();

        facade.addLesson("The very start");
        assertEquals(result + 1, facade.getModule().getLessons().size());
    }

    @Test
    void addLessonNullIsRejected() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.addModule("Introduction");
        facade.setModule(0);

        int result = facade.getModule().getLessons().size();

        facade.addLesson(null);
        assertEquals(result, facade.getModule().getLessons().size());
    }

    @Test
    void removeLesson() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.addModule("Introduction");
        facade.setModule(0);

        facade.addLesson("The very start");
        int result = facade.removeLesson(0);
        assertEquals(0, result);
    }

    @Test
    void removeLessonInvalidIsIgnored() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();
        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.addModule("Introduction");
        facade.setModule(0);

        facade.addLesson("The very start");
        int result = facade.removeLesson(99);
        assertEquals(2, result);
    }

    @Test
    void addCommentCourse() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.getCourse().setCommentArray(new ArrayList<Comment>());
        facade.addComment("Hello", 1);
        facade.setComment(0, 1);

        assertEquals(true, facade.hasComment());
    }

    @Test
    void addCommentModule() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.addModule("Introduction");
        facade.setModule(0);

        facade.getModule().setCommentArray(new ArrayList<Comment>());
        facade.addComment("Hello", 2);
        facade.setComment(0, 2);

        assertEquals(true, facade.hasComment());
    }

    @Test
    void addCommentReply() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();
        
        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.getCourse().setCommentArray(new ArrayList<Comment>());
        facade.addComment("Hello", 1);
        facade.setComment(0, 1);

        facade.addComment("Hi", 3);
        facade.setComment(0, 3);

        assertEquals(true, facade.hasComment());
    }

    @Test
    void addCommentInvalidIsIgnored() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);
        facade.setCourse(0);

        facade.getCourse().setCommentArray(new ArrayList<Comment>());
        facade.addComment("Hello", 99);
        facade.setComment(0, 1);
        assertEquals(false, facade.hasComment());
    }

    @Test
    void enroll() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);

        assertEquals(0, facade.enroll(1));
    }

    @Test
    void enrollDuplicateIsIgnored() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);

        assertEquals(2, facade.enroll(1));
    }

    @Test
    void enrollInvalidIsIgnored() {
        CourseList.setCourseList(new ArrayList<Course>());
        LMSFacade facade = new LMSFacade();

        facade.setUser(new Student("J", "C", "JC@Gmail.com", "JC2023", "JC2023"));
        facade.addCourse("Introduction to JavaScript", "Test", Language.JavaScript);
        facade.addCourse("Python 3", "Test", Language.Python);

        assertEquals(1, facade.enroll(99));
    }
}
