/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;
import java.util.UUID;

public class Student extends User{

    ArrayList<String> certifications = new ArrayList<String>();

    public Student(UUID uuid, String firstName, String lastName, String email, String username, String password, ArrayList<String> certifications){
        super(username, password, email, firstName, lastName);
        super.uuid = uuid;
        super.type = 1;
        this.certifications = certifications;
    }

    public Student(String firstName, String lastName, String email, String username, String password){
        super(username, password, email, firstName, lastName);
        super.uuid = UUID.randomUUID();
        super.type = 1;
    }

    public ArrayList<String> getCertifications(){
        return certifications;
    }

    public void setCertification(String str){
        certifications.add(str);
    }

    public void printCertifications() {
        for(String cert: certifications) {
            System.out.println(cert+"\n");
        }
    }
}