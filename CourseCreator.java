
/*
 * Written by Anonmyous Pandas 
 */

import java.util.UUID;

public class CourseCreator extends User{

    public String type;
    public UUID uuid;

    public CourseCreator(UUID uuid, String firstName, String lastName, String email, String username, String password){
        super(username, password, email, firstName, lastName);
        this.uuid = uuid;
        this.type = "Creator";
    }

    public CourseCreator(String firstName, String lastName, String email, String username, String password){
        super(username, password, email, firstName, lastName);
        this.uuid = UUID.randomUUID();
        this.type = "Creator";
    }

    
    /** 
     * @return int
     */
    public String getType(){
        return type;
    }

    public UUID getUUID(){
        return uuid;
    }
}