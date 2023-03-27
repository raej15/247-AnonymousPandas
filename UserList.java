/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class UserList extends DataConstants{
    private static UserList userList = new UserList();
    public static ArrayList<User> users;

    /*
    private UserList() {
       users = DataLoader.loadUsers();
    }
     */
    
    /** 
     * @return UserList
     */
    public static UserList getInstance(){
        if(userList == null){
            System.out.println("null userList - debugging purposes - UserList Class line 23");
            userList = new UserList();
        }
        return userList;
    }

    
    /** 
     * @param users
     */
    public static void setUserList(ArrayList <User> users){
        UserList.users = users;
    }

    
    /** 
     * @param username
     * @return User
     */
    public User getUser(String username){
        for(User user : users) {
            if(user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    
    /** 
     * @param username
     */
    public void removeUser(String username){
        for(User user : users) {
            if(user.getUserName().equals(username)) {
                users.remove(user);
                return;
            }
        }
    }

    
    /** 
     * @param username
     * @return boolean
     */
    public boolean has(String username) {
        for(User user : users) {
            if(user.getUserName().equals(username)) {
                return true;
            }
        }

        return false;
    }

    
    /** 
     * @param user
     * @param password
     * @return boolean
     */
    public boolean login(User user, String password) {
        if (user.checkPassword(password)) {
            return true;
        }

        return false;
    }

    
    /** 
     * @return ArrayList<User>
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    public void printUsers(){
        for (User user: users) {
            System.out.println(user.toString()+"\n---------------");
        }
    }

    
    /** 
     * @param newUser
     */
    public void addUser(User newUser) {
        users.add(newUser);
    }

    
    /** 
     * @param currentUser
     */
    public void editUser(User currentUser) {
        try (Scanner sc = new Scanner(System.in)) {
            currentUser.toString();
            System.out.println("What would you like to edit?");
            for(int i = 1; i < 6; i++){
                System.out.println(i + ". "+ PROFILE[i-1]);
            }
            int input = sc.nextInt();
            switch (input) {
            case 1:
                System.out.println("New First Name:");
                sc.nextLine();
                currentUser.setFirstName(sc.nextLine());
                currentUser.toString();
                break;
            case 2:
                System.out.println("New Last Name:");
                sc.nextLine();
                currentUser.setLastName(sc.nextLine());
                currentUser.toString();
                break;
            case 3:
                System.out.println("New Email:");
                sc.nextLine();
                currentUser.setEmail(sc.nextLine());
                currentUser.toString();
                break;    
            case 4:
                System.out.println("New Username:");
                sc.nextLine();
                currentUser.setUsername(sc.nextLine());
                currentUser.toString();
                break;
            case 5:
                System.out.println("New Password:");
                sc.nextLine();
                String newPassword = sc.nextLine();
                currentUser.setPassword(newPassword);
                currentUser.toString();
            break;
            }
        }
    }

    public static void newUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Student(1) or Course Creator(2)");
        int type = sc.nextInt();
        sc.nextLine();
    
        String[] userInput = new String[5];
        for(int i = 0; i < PROFILE.length; i++){
            System.out.println(PROFILE[i]+":");
            userInput[i] = sc.nextLine();
        }
        if (type == 1) {
            Student newUser = new Student(userInput[0], userInput[1], userInput[2],userInput[3], userInput[4]);
            users.add(newUser);
        } else if (type == 2) {
            CourseCreator newUser = new CourseCreator(userInput[0], userInput[1], userInput[2],userInput[3], userInput[4]);
            users.add(newUser);
        }
        
        sc.close();
        
    }
}