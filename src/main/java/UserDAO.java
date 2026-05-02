import java.sql.Connection;
import java.sql.*;

public class UserDAO {

    private final Connection connection;
    // constructor that connects to DatabaseManager
    public UserDAO(Connection connection) {
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
        String sql = "SELECT username FROM users WHERE username = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
//                return "found: " + rs.getString("username");
                return rs.getString("username");
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
//        if(username.isEmpty()||newPassword.isEmpty()){
//            return false;
//        }
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, newPassword);
            ps.setString(2, username);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("updatePassword failed to update: " + e.getMessage());
            return false;
        }
    }

    /**
     * update username
     */
    public boolean updateUsername(String OldUsername, String newUsername) {
        String sql = "UPDATE users SET username = ? WHERE username = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, newUsername);
            ps.setString(2, OldUsername);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("updateUsername failed: " + e.getMessage());
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

    //Todo: make a check that returns true if a username and password exist in the database

    public boolean userLogin(String username, String password) {
        String sql ="SELECT 1 FROM users WHERE username = ? AND password = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
//            if(rs.next()){
//                return true;
//            }else{
//                return false;
//            }
        } catch(SQLException e) {
            System.out.println("login failed" + e.getMessage());
        }
        return false;
    }

    /**
     * Checks if the username exists already
     */
    public boolean usernameExists(String username){

        return true;
    }




}
