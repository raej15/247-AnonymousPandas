/*
 * Written by Anonmyous Pandas 
 */
 import java.util.UUID;

 public class User {
    protected String username;
    protected String password;
    protected String email;
    protected String firstName;
    protected String lastName;
    

    //What to put in this?
    public User(String username, String password, String email, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(UUID id, String username, String password, String email, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    
    /** 
     * @return String
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
     * @return String
     * get password
     */
    public String getPassword() {
        return this.password;
    }

    
    /** 
     * @return String
     * get email
     */
    public String getEmail() {
        return this.email;
    }

    
    /** 
     * @return String
     * get first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    
    /** 
     * @return String
     * get last name
     */
    public String getLastName() {
        return this.lastName;
    }

    
    /** 
     * @return String
     * get username
     */
    public String getUsername(){
        return username;
    }

    
    /** 
     * @param username
     * set username
     */
    public void setUsername(String username){
        this.username = username;
    }
    
    /** 
     * @param password
     * set password
     */
    public void setPassword(String password){
        this.password=password;
    }

    
    /** 
     * @param email
     * set email
     */
    public void setEmail(String email){
        this.email = email;
    }

    
    /** 
     * @param firstName
     * set first name
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    
    /** 
     * @param lastName
     * set last name
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    
    /** 
     * @param password
     * check password 
     * @return boolean
     */
    public boolean checkPassword(String password) {
        if (password.equals(this.password))
            return true;
        return false;
    }
 }