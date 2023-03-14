import java.util.ArrayList;

/*
 * Written by Anonymous Pandas
 */


public class Comment {
    private String comment;
    public Student commenter;
    private ArrayList<Comment> comments;

    public Comment(String comment, Student commenter) {
        this.comment = comment;
        this.commenter = commenter;
        comments = new ArrayList<Comment>();
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


}