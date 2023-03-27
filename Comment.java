import java.util.ArrayList;
import java.util.UUID;

/*
 * Written by Anonymous Pandas
 */

public class Comment {
    private String comment;
    public UUID commenter;
    private ArrayList<Comment> comments;


    public Comment(String comment, Student commenter) {
        this.comment = comment;
        comments = new ArrayList<Comment>();
    }
    
    public Comment(UUID commenter, String comment, ArrayList<Comment> comments) {
        this.commenter = commenter;
        this.comment = comment;
        this.comments = comments;
    }

    public Comment(){
        comment = null;
        commenter = null;
        comments = new ArrayList<Comment>();
    }
    
    
    /** 
     * @param comment
     * adding comments
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    
    /** 
     * @param removeComment
     * removing comments
     */
    public void removeComment(String removeComment){
        for(Comment comment : comments) {
            if(comment.getComment().equals(removeComment)) {
                comments.remove(comment);
                return;
            }
        }
    }

    
    /** 
     * @return String
     * get comments
     */
    public String getComment() {
        return this.comment;
    }

    public UUID getCommenter(){
        return commenter;
    }

    public ArrayList<Comment> getComments(){
        return comments;
    }

    
    /** 
     * @return String
     * print out comments 
     */
    public String toString(){
        String finalStr = "Comment: " + this.comment;
        for(Comment comment: comments) {
            finalStr+="\n";
            finalStr+="\tNested Comment: " + comment.getComment();
        }
        return finalStr;
    }


}