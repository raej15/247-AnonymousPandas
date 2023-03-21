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
    protected UUID id;
    

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
        this.id = id;
    }

    
    /** 
     * @return String
     */
    public String toString() {
        return "First Name: "+firstName+ "\nLast Name: "+lastName+"\nemail: "+email+"\nUsername: " + username +"\nPassword: "+password;
    }

    
    /** 
     * @return String
     */
    public String getUserName() {
        return this.username;
    }

    
    /** 
     * @return String
     */
    public String getPassword() {
        return this.password;
    }

    
    /** 
     * @return String
     */
    public String getEmail() {
        return this.email;
    }

    
    /** 
     * @return String
     */
    public String getFirstName() {
        return this.firstName;
    }

    
    /** 
     * @return String
     */
    public String getLastName() {
        return this.lastName;
    }

    
    /** 
     * @return int
     */
    public int getUserType() {
        return 1;
    }
    
    /** 
     * @return String
     */
    public String getUsername(){
        return username;
    }

    
    /** 
     * @param username
     */
    public void setUsername(String username){
        this.username = username;
    }

    
    /** 
     * @return UUID
     */
    public UUID getID(){
        return id;
    }

    
    /** 
     * @param password
     */
    public void setPassword(String password){
        this.password=password;
    }

    
    /** 
     * @param email
     */
    public void setEmail(String email){
        this.email = email;
    }

    
    /** 
     * @param firstName
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    
    /** 
     * @param lastName
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    
    /** 
     * @param password
     * @return boolean
     */
    public boolean checkPassword(String password) {
        if (password.equals(this.password))
            return true;
        return false;
    }
 }