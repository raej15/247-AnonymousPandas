/*
 * Written by Anonymous Pandas
 */

/**
 * I'm currently using this to test the code that I've written. This will need to be updated eventually
 */

public class UI {
    private static void clearTerminal() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    private static void loadData() {
        DataLoader.loadCourses();
        //CourseList.getInstance().printCourses();
        DataLoader.loadUsers();
        //UserList.getInstance().printUsers();
    }

    private static void saveData() {

    }

    public static void main(String[] args) {
        LearningManagementSystemFacade facade = new LearningManagementSystemFacade();
        loadData();

        while (true) {
            
            clearTerminal();

            facade.loadUI();
        }

        //saveData();
    }
}