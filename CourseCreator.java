/*
 * Written by Anonmyous Pandas 
 */

import java.util.UUID;

/**
 * A type of user that can edit, save, and create courses
 */
public class CourseCreator extends User{

    /**
     * Course creator constructor
     * @param uuid ID of course creator user
     * @param firstName user's first name
     * @param lastName user's last name
     * @param email user's email
     * @param username user's username
     * @param password user's password
     */
    public CourseCreator(UUID uuid, String firstName, String lastName, String email, String username, String password){
        super(username, password, email, firstName, lastName);
        super.uuid = uuid;
        super.type = 2;
    }

    /**
     * course creator constructor w/o UUID
     * @param firstName user's first name
     * @param lastName user's last name
     * @param email user's email
     * @param username user's username
     * @param password user's password
     */
    public CourseCreator(String firstName, String lastName, String email, String username, String password){
        super(username, password, email, firstName, lastName);
        super.uuid = UUID.randomUUID();
        super.type = 2;
    }
}