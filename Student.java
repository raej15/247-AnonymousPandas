
/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;
import java.util.UUID;

public class Student extends User{

    public int type;
    public UUID uuid;

    public Student(UUID uuid, String username, String password, String email, String firstName, String lastName){
        super(username, password, email, firstName, lastName);
        this.uuid = uuid;
        this.type = 1;
    }

    public Student(String username, String password, String email, String firstName, String lastName){
        super(username, password, email, firstName, lastName);
        this.uuid = UUID.randomUUID();
        this.type = 1;
    }

    public int getType(){
        return type;
    }
}