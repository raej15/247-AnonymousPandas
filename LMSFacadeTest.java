import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LMSFacadeTest {
    private LMSFacade facade = new LMSFacade();
    CourseList courses = new CourseList();
    
    @Test
    void initialize() {
        UI.loadData();
    }

    @Test
    void registerUser() {
        UI.loadData();
        int size = facade.getUserList().getUsers().size();
        facade.register("JSmith02", "SecurePass", "JSmith@gmail.com", "John", "Smith", 1);
        assertEquals(size + 1, facade.getUserList().getUsers().size());
    }

    @Test
    void registerNullIsIgnored() {
        int size = facade.getUserList().getUsers().size();
        facade.register(null, null, null, null, null, 1);
        assertEquals(size, facade.getUserList().getUsers().size());
    }

    @Test
    void registerEmptyIsIgnored() {
        int size = facade.getUserList().getUsers().size();
        facade.register("", "", "", "", "", 1);
        assertEquals(size, facade.getUserList().getUsers().size());
    }

    @Test
    void registerInvalidTypeIsIgnored() {
        int size = facade.getUserList().getUsers().size();
        facade.register("Omega14", "Kaix15", "Omega14ls@hotmail.com", "Mai", "Kai", 6);
        assertEquals(size, facade.getUserList().getUsers().size());
    }

    @Test
    void registerDuplicateIsIgnored() {
        int size = facade.getUserList().getUsers().size();
        facade.register("MaxMan14", "Locked4You", "Maxwell01@gmail.com", "Maxwell", "White", 1);
        facade.register("MaxMan14", "Locked4You", "Maxwell01@gmail.com", "Maxwell", "White", 1);
        assertEquals(size + 1, facade.getUserList().getUsers().size());
    }

    @Test
    void setUser() {
        facade.setUser(new Student("MaxMan14", "Locked4You", "Maxwell01@gmail.com", "Maxwell", "White"));
        assertEquals(true, facade.hasUser());
    }

    @Test
    void setUserNull() {
        facade.setUser(null);
        assertEquals(false, facade.hasUser());
    }

    @Test
    void setUserDefaultUserIsRejected() {
        facade.setUser(new User("MaxMan14", "Locked4You", "Maxwell01@gmail.com", "Maxwell", "White"));
        assertEquals(false, facade.hasUser());
    }

    @Test
    void setEnrolledCourse() {
        UI.loadData();
        LMSFacade facade = new LMSFacade();

        String[] enrolledCourses = new String[2];
        enrolledCourses[0] = "Introduction to JavaScript";
        assertEquals(0, facade.setEnrolledCourse(enrolledCourses, 0));
    }

    @Test
    void setEnrolledCourseInvalidIndexIsRejected() {
        String[] enrolledCourses = new String[2];
        enrolledCourses[0] = "Introduction to JavaScript";
        assertEquals(1, facade.setEnrolledCourse(enrolledCourses, 10));
    }

    @Test
    void setEnrolledCourseNotEnrolledIsRejected() {
        String[] enrolledCourses = new String[2];
        enrolledCourses[0] = "Introduction to JavaScript";
        assertEquals(2, facade.setEnrolledCourse(enrolledCourses, 1));
    }

    @Test
    void setEnrolledCourseNullArrayIsRejected() {
        String[] enrolledCourses = null;
        assertEquals(2, facade.setEnrolledCourse(enrolledCourses, 0));
    }

    @Test
    void setCourse() {
        int result = facade.setCourse(1);
        assertEquals(0, result);
    }

    @Test
    void setCourseInvalidIsRejected() {
        int result = facade.setCourse(99);
        assertEquals(1, result);
    }

    @Test
    void setCourseRemoveCourse() {
        int result = facade.setCourse(0);
        result = facade.setCourse(-1);
        assertEquals(0, result);
    }

    @Test
    void setModule() {
        facade.setCourse(0);
        facade.setModule(0);
        assertEquals(true, facade.hasModule());
    }

    @Test
    void setModuleInvalidIsRejected() {
        facade.setCourse(0);
        facade.setModule(99);
        assertEquals(false, facade.hasModule());
    }

    @Test
    void setModuleRemove() {
        facade.setCourse(0);
        facade.setModule(0);
        facade.setModule(-1);
        assertEquals(false, facade.hasModule());
    }

    @Test
    void setTest() {
        facade.setCourse(0);
        facade.setModule(0);
        facade.setLesson(0);
        assertEquals(true, facade.hasLesson());
    }

    @Test
    void setTestInvalidIsRejected() {
        facade.setCourse(0);
        facade.setModule(0);
        facade.setLesson(99);
        assertEquals(false, facade.hasLesson());
    }

    @Test
    void setTestRemove() {
        facade.setCourse(0);
        facade.setModule(0);
        facade.setLesson(0);
        facade.setLesson(-1);
        assertEquals(false, facade.hasLesson());
    }

    @Test
    void setQuizCourse() {
        facade.setCourse(0);
        facade.setQuiz(1);
        assertEquals(true, facade.hasQuiz());
    }

    @Test
    void setQuizModule() {
        facade.setCourse(0);
        facade.setModule(0);
        facade.setQuiz(2);
        assertEquals(true, facade.hasQuiz());
    }

    @Test
    void setQuizInvalidIsRejected() {
        facade.setCourse(0);
        facade.setModule(0);
        facade.setQuiz(99);
        assertEquals(false, facade.hasQuiz());
    }

    @Test
    void setQuizRemove() {
        facade.setCourse(0);
        facade.setQuiz(1);
        facade.setQuiz(-1);
        assertEquals(false, facade.hasQuiz());
    }

    @Test
    void setQuestion() {
        facade.setCourse(0);
        facade.setQuiz(1);
        facade.setQuestion(0);
        assertEquals(true, facade.hasQuestion());
    }

    @Test
    void setQuestionInvalidIsRejected() {
        facade.setCourse(0);
        facade.setQuiz(1);
        facade.setQuestion(99);
        assertEquals(false, facade.hasQuestion());
    }

    @Test
    void setQuestionRemove() {
        facade.setCourse(0);
        facade.setQuiz(1);
        facade.setQuestion(0);
        facade.setQuestion(-1);
        assertEquals(false, facade.hasQuestion());
    }

    @Test
    void setCommentCourse() {
        facade.setCourse(0);
        facade.setComment(0, 1);
        assertEquals(true, facade.hasComment());
    }

    @Test
    void setCommentModule() {
        facade.setCourse(0);
        facade.setModule(0);
        facade.setComment(0, 2);
        assertEquals(true, facade.hasComment());
    }

    @Test
    void setCommentReply() {
        facade.setCourse(0);
        facade.setComment(0, 1);
        facade.setComment(0, 3);
        assertEquals(true, facade.hasComment());
    }

    @Test
    void setCommentInvalidIndexIsIgnored() {
        facade.setCourse(0);
        facade.setModule(0);
        facade.setComment(99, 2);
        assertEquals(false, facade.hasComment());
    }

    @Test
    void setCommentInvalidModeModule() {
        facade.setCourse(0);
        facade.setModule(0);
        facade.setComment(0, 99);
        assertEquals(false, facade.hasComment());
    }

    @Test
    void addCourse() {
        int result = facade.getCourseList().getCourses().size();
        facade.addCourse("Python 3 Basics", "This teaches the basics of Python 3", Language.Python);;
        assertEquals(result + 1, facade.getCourseList().getCourses().size());
    }

    @Test
    void addCourseRejectDuplicate() {
        int result = facade.getCourseList().getCourses().size();
        facade.addCourse("Python Tricks", "This teaches a few tricks for Python", Language.Python);;
        facade.addCourse("Python Tricks", "This teaches a few tricks for Python", Language.Python);;
        assertEquals(result + 1, facade.getCourseList().getCourses().size());
    }

    @Test
    void addCourseRejectEmptyCourse() {
        int result = facade.getCourseList().getCourses().size();
        facade.addCourse(null, null, null);
        assertEquals(result, facade.getCourseList().getCourses().size());
    }

    @Test
    void removeCourse() {
        int result = facade.removeCourse(2);
        assertEquals(3, result);
        // Nothing should be removed since the user has no UUID
    }

    @Test
    void removeCourseInvalidIsIgnored() {
        int result = facade.removeCourse(99);
        assertEquals(2, result);
    }

    @Test
    void addModule() {
        facade.setCourse(2);
        int result = facade.getCourse().getModules().size();
        facade.addModule("A quick introduction");
        assertEquals(result + 1, facade.getCourse().getModules().size());
    }

    @Test
    void addModuleNullIsRejected() {
        facade.setCourse(2);
        int result = facade.getCourse().getModules().size();
        facade.addModule(null);
        assertEquals(result, facade.getCourse().getModules().size());
    }

    @Test
    void removeModule() {
        facade.setCourse(2);
        int result = facade.removeModule(0);
        assertEquals(3, result);
        // Nothing should be removed since the user has no UUID
    }
    
    @Test
    void removeModuleInvalidIsIgnored() {
        facade.setCourse(2);
        int result = facade.removeModule(33);
        assertEquals(2, result);
    }

    @Test
    void addLesson() {
        facade.setCourse(2);
        facade.setModule(0);
        int result = facade.getModule().getLessons().size();
        facade.addLesson("The very start");
        assertEquals(result + 1, facade.getModule().getLessons().size());
    }

    @Test
    void addLessonNullIsRejected() {
        facade.setCourse(2);
        facade.setModule(0);
        int result = facade.getModule().getLessons().size();
        facade.addLesson(null);
        assertEquals(result, facade.getModule().getLessons().size());
    }

    @Test
    void removeLesson() {
        facade.setCourse(2);
        facade.setModule(0);
        int result = facade.removeLesson(0);
        assertEquals(3, result);
        // Nothing should be removed since the user has no UUID
    }

    @Test
    void removeLessonInvalidIsIgnored() {
        facade.setCourse(2);
        facade.setModule(0);
        int result = facade.removeLesson(99);
        assertEquals(2, result);
    }

    @Test
    void addCommentCourse() {
        facade.setCourse(2);
        facade.addComment("Hello", 1);
        facade.setComment(0, 1);
        assertEquals(true, facade.hasComment());
    }

    @Test
    void addCommentModule() {
        facade.setCourse(2);
        facade.setModule(0);
        facade.addComment("Hello", 2);
        facade.setComment(0, 2);
        assertEquals(true, facade.hasComment());
    }

    @Test
    void addCommentReply() {
        facade.setCourse(2);
        facade.addComment("Hello", 1);
        facade.setComment(0, 3);
        assertEquals(true, facade.hasComment());
    }

    @Test
    void addCommentInvalidIsIgnored() {
        facade.setCourse(2);
        facade.addComment("Hello", 99);
        facade.setComment(2, 1);
        assertEquals(false, facade.hasComment());
    }

    @Test
    void enroll() {
        facade.setUser(facade.getUserList().getUser("JC"));
        assertEquals(0, facade.enroll(1));
    }

    @Test
    void enrollDuplicateIsIgnored() {
        facade.setUser(facade.getUserList().getUser("JC"));
        assertEquals(2, facade.enroll(1));
    }

    @Test
    void enrollInvalidIsIgnored() {
        facade.setUser(facade.getUserList().getUser("JC"));
        assertEquals(1, facade.enroll(99));
    }
}
