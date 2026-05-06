import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    private final Connection connection;

    public PostDAO(){
        this.connection = DatabaseManager.getInstance().getConnection();
    }
    private static List<String[]> posts = new ArrayList<>();


    private int getUserId(String username) {
        String sql = "SELECT id FROM users WHERE username = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt("id");
        } catch (SQLException e) {
            System.err.println("getUserId failed: " + e.getMessage());
        }
        return -1;
    }
    /**
     * addPost(Int String String String)
     */
    public boolean addPost(String username, String title, String body) {
        int userId = getUserId(username);
        String sql = "INSERT INTO posts(user_id, username, title, body) VALUES(?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setString(2, username);
            pstmt.setString(3, title);
            pstmt.setString(4, body);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("addPost failed: " + e.getMessage());
            return false;
        }
    }

    /**
     * deletePosts(int)
     */
    public boolean deletePost(int postId) {
        String sql = "DELETE FROM posts WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, postId);
            int AffectedR = pstmt.executeUpdate();
            return AffectedR > 0;
        } catch (SQLException e) {
            System.err.println("deletePost Failed" + e.getMessage());
            return false;
        }
    }
    /**
     * getAllPost()
     */
    public List<String[]> getAllPosts() {
        List<String[]> posts = new ArrayList<>();
        String sql = "SELECT id, username, title, body FROM posts ORDER BY created DESC";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                posts.add(new String[]{
                        rs.getString("id"),
                        rs.getString("username"),
                        rs.getString("title"),
                        rs.getString("body")
                });
            }
        } catch (SQLException e) {
            System.err.println("getAllPosts failed: " + e.getMessage());
        }
        return posts;
    }

}
