import java.sql.Connection;
import java.sql.*;

public class DatabaseFunction {

    private Connection connection;
    // constructor that connects to DatabaseManager
    public DatabaseFunction(Connection connection) {
        this.connection = connection;
    }

    // ToDo: insertUser(String , String )

    //insert method
    //adding a new user to the database
    public boolean insertUser(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("insertUser failed to insert: " + e.getMessage());
            return false;
        }
    }

    //ToDo: getUserByUsername(String )

    //read method
    //find a user by their username
    public String getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return "found: " + rs.getString("username");
            }
        } catch(SQLException e){
            System.out.println("getUserByUsername failed to find: " + e.getMessage());
        }
        return null;
    }

    //ToDo: updatePassword(String , String )

    //update method
    //change a users password
    public boolean updatePassword(String username, String newPassword) {
        String sql = "UPDATE users SET password = ? WHERE username = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setString(2, username);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("updatePassword failed to update: " + e.getMessage());
            return false;
        }
    }

    //ToDo: deleteUser(String )

    //delete method
    //remove a user from the database
    public boolean deleteUser(String username) {
        String sql = "DELETE FROM users WHERE username = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.executeUpdate();
            return true;
        } catch(SQLException e) {
            System.out.println("deleteUser failed to delete: " + e.getMessage());
            return false;
        }
    }
}
