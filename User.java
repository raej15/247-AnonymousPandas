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

    public String toString() {
        return "First Name: "+firstName+ "\nLast Name: "+lastName+"\nemail: "+email+"\nUsername: " + username +"\nPassword: "+password;
    }

    public String getUserName() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getUserType() {
        return 1;
    }
    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public UUID getID(){
        return id;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public boolean checkPassword(String password) {
        if (password.equals(this.password))
            return true;
        return false;
    }
 }