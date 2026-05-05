import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentDAO {
    private final Connection connection;

    public CommentDAO() {
        this.connection = DatabaseManager.getInstance().getConnection();
    }

    /**
     * addComment(Int String String)
     */
    public boolean addComment(int postId, String username, String comment){
        String sql = "INSERT INTO posts(user_id, username, head, body) VALUES(?, ?, ?)";

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
}
