import java.util.UUID;

public class Student extends User{

    public String type;
    public UUID uuid;

    public Student(UUID uuid, String username, String password, String email, String firstName, String lastName){
        super(username, password, email, firstName, lastName);
        this.uuid = uuid;
        this.type = "Student";
    }
}