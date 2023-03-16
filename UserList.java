/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;

public class UserList {
    private static UserList userList;

    public static ArrayList<User> users;
    public static UserList getInstance(){
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

    public ArrayList<User> getUsers() {
        return users;
    }

    
}