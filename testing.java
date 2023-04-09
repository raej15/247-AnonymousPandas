import java.util.ArrayList;

public class testing {

    private static ArrayList<User> users = DataLoader.loadUsers();
    public static void main(String[] args) {
 
        System.out.println(users.size());
        UserList.getInstance().getUsers().clear();
        System.out.println("9");
        DataWriter.saveUsers();
        users = DataLoader.loadUsers();
        System.out.println(users.size());
        for (User user: users){
            System.out.println(user.toString());
        }
        UserList.setUserList(users);
        DataWriter.saveUsers();
        ArrayList <User> writtenUsers = DataLoader.loadUsers();
    }
}
