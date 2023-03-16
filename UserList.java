/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;

public class UserList {
    private static UserList userList = new UserList();
    public static ArrayList<User> users;

    private UserList() {
        users = new ArrayList<User>();
        users.add(new User("Johnny", "Password", "John@gmail.com", "John", "Smith"));
    }

    public static UserList getInstance(){
        if(userList == null){
            userList = new UserList();
        }
        
        return userList;
    }

    public static void setUserList(ArrayList <User> users){
        UserList.users = users;
    }

    public User getUser(String username){
        for(User user : users) {
            if(user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void removeUser(String username){
        for(User user : users) {
            if(user.getUserName().equals(username)) {
                users.remove(user);
                return;
            }
        }
    }

    public boolean has(String username) {
        for(User user : users) {
            if(user.getUserName().equals(username)) {
                return true;
            }
        }

        return false;
    }

    public boolean login(User user, String password) {
        if (user.checkPassword(password)) {
            return true;
        }

        return false;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}