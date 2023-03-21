
/*
 * Written by Anonmyous Pandas 
 */

import java.util.UUID;

public class CourseCreator extends User{

    public int type;
    public UUID uuid;

    public CourseCreator(UUID uuid, String firstName, String lastName, String email, String username, String password){
        super(username, password, email, firstName, lastName);
        this.uuid = uuid;
        this.type = 2;
    }

    public CourseCreator(String firstName, String lastName, String email, String username, String password){
        super(username, password, email, firstName, lastName);
        this.uuid = UUID.randomUUID();
        this.type = 2;
    }

    public int getType(){
        return type;
    }
}