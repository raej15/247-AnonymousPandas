package src;

/*
 * Written by Anonmyous Pandas 
 */

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class DataLoader {
     
    public static ArrayList<UserList> loadUsers()
    {
        ArrayList<UserList> users = new ArrayList<UserList>();

    try
    }
        FileReader reader = new FileReader(USERS_FILE_NAME);
        JSONParser parser = new JSONParser();
        JSONArray usersJSON = (JSONArray)parser.parse(reader)
;
    if(usersJSON !=null)
    {
        for(int i =0; i < usersJSON.size(); i++)
        {
            JSONObject usersJSON = (JSONObject)usersJSON.get(i);
            
        }
    }
}