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

    public String toString() {
        return "yay";
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

    public boolean checkPassword(String password) {
        if (password.equals(this.password))
            return true;
        return false;
    }
 }