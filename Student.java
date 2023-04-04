import java.util.ArrayList;
import java.util.UUID;

/**
 * Creates a student object with the appropiate variables
 * @author Anonymous Pandas
 */
public class Student extends User{

    ArrayList<String> certifications = new ArrayList<String>();

    /**
     * Constructor for student
     * @param uuid Student's UUID
     * @param firstName Student's first name
     * @param lastName Student's last name
     * @param email Student's email
     * @param username Student's username
     * @param password Student's password
     * @param certifications Student's certifications
     */
    public Student(UUID uuid, String firstName, String lastName, String email, String username, String password, ArrayList<String> certifications){
        super(username, password, email, firstName, lastName);
        super.uuid = uuid;
        super.type = 1;
        this.certifications = certifications;
    }

    /**
     * Second constructor for student
     * @param firstName Student's first name
     * @param lastName Student's last name
     * @param email Student's email
     * @param username Student's username
     * @param password Student's password     * 
     */
    public Student(String firstName, String lastName, String email, String username, String password){
        super(username, password, email, firstName, lastName);
        super.uuid = UUID.randomUUID();
        super.type = 1;
    }

    /**
     * gets existing final certification info
     * @return returns a certification
     */
    public ArrayList<String> getCertifications(){
        return certifications;
    }

    /**
     * sets a final certification for the student
     * @param str the string for the final certification to contain
     */
    public void setCertification(String str){
        certifications.add(str);
    }

    /**
     * prints the certifications
     */
    public void printCertifications() {
        for(String cert: certifications) {
            System.out.println(cert+"\n");
        }
    }
}