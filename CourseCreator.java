import java.util.UUID;

public class CourseCreator extends User{

    public String type;
    public UUID uuid;

    public CourseCreator(UUID uuid, String username, String password, String email, String firstName, String lastName){
        super(username, password, email, firstName, lastName);
        this.uuid = uuid;
        this.type = "Creator";
    }
}