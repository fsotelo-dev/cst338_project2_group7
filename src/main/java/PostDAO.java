import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class PostDAO {
    private final Connection connection;

    public PostDAO() {
        this.connection = DatabaseManager.getInstance().getConnection();
    }

    /**
     * addPost(Int String String String)
     */
    public boolean addPost(int userId, String username, String head, String body){
        String sql = "INSERT INTO posts(user_id, username, head, body) VALUES(?, ?, ?, ?)";

        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1, userId);
            pstmt.setString(2, username);
            pstmt.setString(3, head);
            pstmt.setString(4, body);
            pstmt.executeUpdate();

            return true;
        }catch(SQLException e){
            System.err.println("addPost failed" + e.getMessage());
            return false;
        }
    }

    /**
     * deletePosts(int)
     */
    public boolean deletePost(int postId){
        String sql = "DELETE FROM posts WHERE id = ?";

        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1, postId);
            int AffectedR = pstmt.executeUpdate();
            return AffectedR>0; //False if user had no posts
        }catch(SQLException e){
            System.err.println("deletePost Failed" + e.getMessage());
            return false;
        }
    }
}
