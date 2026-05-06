import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * get posts so that we can read posts
     */
    public List<String[]> getAllPosts() {
        List<String[]> posts = new ArrayList<>();

        String sql = "SELECT id, username, title, body FROM posts ORDER BY created DESC ";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            var data = pstmt.executeQuery();

            while(data.next()) {
                posts.add(new String[]{
                        String.valueOf(data.getInt("id")),
                        data.getString("username"),
                        data.getString("title"),
                        data.getString("body")
                });
            }
        } catch (SQLException e) {
            System.out.println("getAllPosts Failed " + e.getMessage());
        }

        return posts;
    }
}
