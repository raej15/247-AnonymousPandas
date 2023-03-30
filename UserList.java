/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;


/**
 * User list for dataconstants 
 */
public class UserList extends DataConstants{
    private static UserList userList = new UserList();
    public static ArrayList<User> users;
    
    /** 
     * method that returns our list of userList
     * @return UserList
     */
    public static UserList getInstance(){
        if(userList == null){
            userList = new UserList();
        }
        return userList;
    }

    
    /** 
     *  method thats set the userList to an ArrayList of type user
     * @param users arraylist of users
     */
    public static void setUserList(ArrayList <User> users){
        UserList.users = users;
    }

    
    /** 
     * method that searches and returns a user by username
     * @param username string representing the users username
     * @return User instance of user
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
     * method that returns a boolean representing if a user exists
     * @param username username of the user
     * @return boolean true if user exsists
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
     * method that allows a user to login
     * @param user type user
     * @param password string password
     * @return boolean true if user and their password matches
     */
    public boolean login(User user, String password) {
        if (user.checkPassword(password)) {
            return true;
        }

        return false;
    }

    
    /** 
     * method that returns the list of users
     * @return ArrayList<User> users list
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * method that prints out the users to string for each user
     */
    public void printUsers(){
        for (User user: users) {
            System.out.println(user.toString()+"\n---------------");
        }
    }

    /** 
     * method that adds a user to the users list
     * @param newUser instance of a user
     */
    public void addUser(User newUser) {
        users.add(newUser);
    }
}