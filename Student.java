
/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;
import java.util.UUID;

public class Student extends User{

    public int type;
    public UUID uuid;

    public Student(UUID uuid, String firstName, String lastName, String email, String username, String password){
        super(username, password, email, firstName, lastName);
        this.uuid = uuid;
        this.type = 1;
    }

    public Student(String firstName, String lastName, String email, String username, String password){
        super(username, password, email, firstName, lastName);
        this.uuid = UUID.randomUUID();
        this.type = 1;
    }

    public int getType(){
        return type;
    }
}