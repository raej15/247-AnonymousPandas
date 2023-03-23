/*
 * Written by Anonmyous Pandas 
 */

import java.util.UUID;

public class CourseCreator extends User{
    public CourseCreator(UUID uuid, String firstName, String lastName, String email, String username, String password){
        super(username, password, email, firstName, lastName);
        super.uuid = uuid;
        super.type = 2;
    }

    public CourseCreator(String firstName, String lastName, String email, String username, String password){
        super(username, password, email, firstName, lastName);
        super.uuid = UUID.randomUUID();
        super.type = 2;
    }
}