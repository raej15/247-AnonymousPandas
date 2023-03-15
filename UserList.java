/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;

public class UserList {
    private UserList userList;
    public static ArrayList<User> users;
    public UserList getInstance(){
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

    
}