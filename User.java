/*
 * Written by Anonmyous Pandas 
 */

 import java.util.UUID;

 /**
  * A parent class for all user info
  */
 public class User {
    protected String username;
    protected String password;
    protected String email;
    protected String firstName;
    protected String lastName;
    protected UUID uuid;
    protected int type;    

     /**
      * Creates a new user
      * @param username The new user's username
      * @param password The new user's password
      * @param email The new user's email
      * @param firstName The new user's first name
      * @param lastName The new user's last name
      */
    public User(String username, String password, String email, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * creates a new user
     * @param id users uuid ID
     * @param username The new user's username
     * @param password The new user's password
     * @param email The new user's email
     * @param firstName The new user's first name
     * @param lastName The new user's last type
     */
    public User(UUID id, String username, String password, String email, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the type of user
     * @return 1 for students, 2 for course creators
     */
    public int getType(){
        return type;
    }

    /**
     * Return's the UUID of the user
     * @return The UUID
     */
    public UUID getUUID(){
        return uuid;
    }

    /** 
     * method that returns the basic user info
     * @return String about user
     */
    public String toString() {
        return "First Name: "+firstName+ "\nLast Name: "+lastName+"\nemail: "+email+"\nUsername: " + username +"\nPassword: "+password;
    }

    
    /** 
     * @return String
     * get username
     */
    public String getUserName() {
        return this.username;
    }

    
    /** 
     * method that returns the users password
     * @return String representing password
     */
    public String getPassword() {
        return this.password;
    }

    
    /** 
     * method that returns the users email
     * @return String representing email
     */
    public String getEmail() {
        return this.email;
    }

    
    /** 
     * method that returns the users first name
     * @return String representing first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    
   /** 
     * method that returns the users last name
     * @return String representing last name
     */
    public String getLastName() {
        return this.lastName;
    }


    
    /** 
     * method that sets the user name of the user
     * @param username new username
     */
    public void setUsername(String username){
        this.username = username;
    }
    
    /** 
     * method that sets the password of the user
     * @param password new password
     */
    public void setPassword(String password){
        this.password=password;
    }

    
    /** 
     * method that sets the email of the user
     * @param email new email
     */
    public void setEmail(String email){
        this.email = email;
    }

    
    /** 
     * method that sets the first name of the user
     * @param firstName new first name
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    
    /** 
     * method that sets the last name of the user
     * @param lastName new last name
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    
    /** 
     * method that checks the password
     * @param password password that needs to be checked
     * @return boolean returns true if password is correct
     */
    public boolean checkPassword(String password) {
        if (password.equals(this.password))
            return true;
        return false;
    }
 }