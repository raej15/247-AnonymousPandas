import java.util.ArrayList;

public class testing {

    private static ArrayList<User> users = DataLoader.loadUsers();
    public static void main(String[] args) {
 
        User user1 = new Student("Kennedy1", "last", "email", "username1", "password");
        User user2 = new Student("Kennedy2", "last", "email", "username2", "password");
        User user3 = new Student("Kennedy3", "last", "email", "username2", "password");

        
        //UserList.users.add(user1);
        UserList.getInstance().getUsers().add(user1);
        UserList.getInstance().getUsers().add(user2);
        UserList.getInstance().getUsers().add(user3);
        boolean hasUser1 = UserList.getInstance().has("username1");
        System.out.println(hasUser1);
    }
}
