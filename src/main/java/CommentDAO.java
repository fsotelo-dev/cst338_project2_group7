import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {
    private final Connection connection;

    public CommentDAO() {
        this.connection = DatabaseManager.getInstance().getConnection();
    }

    /**
     * addComment(Int String String)
     */
    public boolean addComment(int postId, String username, String comment){
        String sql = "INSERT INTO comments(post_id, username, comment) VALUES(?, ?, ?)";

        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1, postId);
            pstmt.setString(2, username);
            pstmt.setString(3, comment);
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("addComment failed" + e.getMessage());
            return false;
        }
    }
    /**
     * deleteComments(int)
     */
    public boolean deletePost(int commentId){
        String sql = "DELETE FROM comments WHERE id = ?";

        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1, commentId);
            int AffectedR = pstmt.executeUpdate();
            return AffectedR>0; //False if user had no posts
        }catch(SQLException e){
            System.err.println("deleteComment Failed" + e.getMessage());
            return false;
        }
    }
    /**
     * get comments that have been added to a post and be able to call them into the post scene
     */
    public List<String> getCommentsByPost(int postId) {
        List<String> comments = new ArrayList<>();
        String sql = "SELECT username, comment FROM comments WHERE post_id = ? ORDER BY created ASC";

        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1, postId);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                comments.add(rs.getString("username") + ": " + rs.getString("comment"));
            }
        }catch(SQLException e){
            System.out.println("getCommentsByPost failed " + e.getMessage());
        }
        return comments;
    }
}
