/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArraryList;

public class DataLoader {

    public static ArrayList<UserList> getUserList() {

        ArraryList<UserList> userlist = new ArraryList<UserList>();

        try {

            UserList userlist = new UserList(username, email, password);
            userlist.add(userlist);

        } catch () {
            System.out.println("");
        }

        return userlist;

    } 
}