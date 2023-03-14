/*
 * Written by Anonmyous Pandas 
 */

 import java.util.UUID;

 public class User {
    private UUID UUID;
    protected String username;
    protected String password;
    protected String email;
    protected String firstName;
    protected String lastName;

    //What to put in this?
    public User() {

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