package src;

/*
 * Written by Anonmyous Pandas 
 */

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class DataLoader {
     
/**
 * Load users method 
 * Json Parser reads and writes while JSON array store data
 * for loap: JSONObject, username, email, password 
 * @return ArrayList<UserList> 
 */

    public static ArrayList<UserList> loadUsers()
    {
        ArrayList<UserList> users = new ArrayList<UserList>();

    try
    }
        FileReader reader = new FileReader(USERS_FILE_NAME);
        JSONParser parser = new JSONParser();
        JSONArray usersJSON = (JSONArray)parser.parse(reader);

    if(usersJSON !=null)
    {
        for(int i =0; i < usersJSON.size(); i++)
        {
            JSONObject usersJSON = (JSONObject)usersJSON.get(i);
            UUID id = UUID.fromString((String)userJSON.get(ID));
            String title = (String)userJSOn.get(USER);
            String description = (String)userJSON.get(DESCRIPTION);

            users.add(new User(username, email, password));
        }
    }
    return users;
} catch(Exception e)
{
    e.printStackTrace();
}

return null;

}