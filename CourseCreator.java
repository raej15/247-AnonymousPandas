
/*
 * Written by Anonmyous Pandas 
 */

import java.util.UUID;

public class CourseCreator extends User{

    public int type;
    public UUID uuid;

    public CourseCreator(UUID uuid, String username, String password, String email, String firstName, String lastName){
        super(username, password, email, firstName, lastName);
        this.uuid = uuid;
        this.type = 2;
    }

    public CourseCreator(String username, String password, String email, String firstName, String lastName){
        super(username, password, email, firstName, lastName);
        this.uuid = UUID.randomUUID();
        this.type = 2;
    }

    public int getType(){
        return type;
    }
}