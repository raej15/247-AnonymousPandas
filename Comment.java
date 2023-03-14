import java.util.ArrayList;

/*
 * Written by Anonymous Pandas
 */


public class Comment {
    private String comment;
    private Student user;
    private ArrayList<Comment> comments;

    public void Comment(Module module) {
        comments = new ArrayList<Comment>();
    }
    
    //does this need to be passsing in a comment object rather than a string??
    public void addComment(String comment) {
        comments.add(comment);
    }

    public void removeComment() {

    }

    public String getComment() {
        return this.comment;
    }


}