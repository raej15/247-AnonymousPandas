
/*
 * Written by Anonmyous Pandas 
 */

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants{
     
private static final String USERS_FILE_NAME = null;

/**
 * Load users method 
 * users JSON  
 * Json Parser reads & writes 
 * JSON array store data
 * for loop has JSONObject, username, email, and password 
 * @return ArrayList<UserList> 
 */

//userid, firstName, lastName, email, username, type (order in json file)

    public static ArrayList<UserList> loadUsers() {
            ArrayList<UserList> users = new ArrayList<UserList>();
        try {
            FileReader reader = new FileReader(USERS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray)parser.parse(reader);

        if(usersJSON !=null)
        {
            for(int i =0; i < usersJSON.size(); i++)
            {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                UUID id = UUID.fromString((String)userJSON.get(USER_ID));
                String firstName = (String)userJSON.get(USER_FIRST_NAME);
                String lastName = (String)userJSON.get(USER_LAST_NAME);
                String email = (String)userJSON.get(USER_EMAIL);
                String username = (String)userJSON.get(USER_USER_NAME);
                String type = (String)userJSON.get(USER_TYPE);

                //users.add(new User(username, email, password));
                if (type.equals("Student")) {
                    users.add(new Student());
                }
            }
        }
        return users;
        } 

        catch(Exception e) {
            e.printStackTrace();
        }

        return null;

    }
}