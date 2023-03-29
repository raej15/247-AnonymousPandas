/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;

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
}