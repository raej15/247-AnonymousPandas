
/*
 * Written by Anonmyous Pandas 
 */

import java.util.ArrayList;
import java.util.UUID;


/**
 * Comment object holds author and content info
 * @author Anonymous Pandas
 */
public class Comment {
    private String comment;
    public UUID commenter;
    private ArrayList<Comment> comments;
    
    /**
     * Comment constructor for all instance variables
     * @param commenter UUID of the user making the comment
     * @param comment contents of the comment
     * @param comments arraylist of nested comments
     */
    public Comment(UUID commenter, String comment, ArrayList<Comment> comments) {
        this.commenter = commenter;
        this.comment = comment;
        this.comments = comments;
    }

    /**
     * Comment constructor that sets commenter and comment null, creates an empty arraylist of nested comments
     */
    public Comment(){
        comment = null;
        commenter = null;
        comments = new ArrayList<Comment>();
    }
    
    
    /** 
     * @param comment object Comment that gets added to the list of comments
     * adding comments to list
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    
    /** 
     * @return String comment contents
     * returns comment contents
     */
    public String getComment() {
        return this.comment;
    }

    
    /** 
     * method that returns the commenters UUID
     * @return UUID of commenter
     */
    public UUID getCommenter(){
        return commenter;
    }

    
    /** 
     *  method that gets the list of comments
     * @return ArrayList<Comment> nested comments
     */
    public ArrayList<Comment> getComments(){
        return comments;
    }

    /**
     * Arraylist to get each comment
     * @return Returns comments 
     */
    public String[] getCommentArray() {
        String[] commentArray = new String[50];

        for (int i = 0; comments.size() > i; i++) {
            commentArray[i] = comments.get(i).getComment();
        }

        return commentArray;
    }

    
    /** 
     * @return String of comment and nested comments
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