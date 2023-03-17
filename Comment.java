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
    
    //does this need to be passsing in a comment object rather than a string?? Yesss
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(String removeComment){
        for(Comment comment : comments) {
            if(comment.getCommentString().equals(removeComment)) {
                comments.remove(comment);
                return;
            }
        }
    }

    public String getComment() {
        return this.comment;
    }

    public String getCommentString(){
        return comment;
    }

    public String toString(){
        String finalStr = "Comment: " + this.comment;
        for(Comment comment: comments) {
            finalStr+="\n";
            finalStr+="\tNested Comment: " + comment.getComment();
        }
        return finalStr;
    }


}