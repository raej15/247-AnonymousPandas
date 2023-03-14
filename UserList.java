
import java.util.ArrayList;

public class UserList {
    private UserList userList;
    private ArrayList<User> users;
    public UserList getInstance(){
        return userList;
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