/*
 * Written by Anonmyous Pandas 
 */

import java.util.UUID;

public class Student extends User{
    public Student(UUID uuid, String firstName, String lastName, String email, String username, String password){
        super(username, password, email, firstName, lastName);
        super.uuid = uuid;
        super.type = 1;
    }

    public Student(String firstName, String lastName, String email, String username, String password){
        super(username, password, email, firstName, lastName);
        super.uuid = UUID.randomUUID();
        super.type = 1;
    }
}