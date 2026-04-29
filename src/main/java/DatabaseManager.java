import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

//    "jdbc:sqlite:" tells JDBC which driver to use.
//    the path after it is the database file location.

    private static final String DB_URL = "jdbc:sqlite:app.db";
    private Connection connection;

    public DatabaseManager(){
        try{
//           open (creates) app.db in the project root
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Database connected.");
            createUserTables();   // set up schema on first run
        }catch (SQLException e){
            System.err.println("Connection failed: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close(){
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }catch(SQLException e){
            System.err.println("failed to close: " + e.getMessage());
        }
    }

    public void createUserTables(){
        // Text blocks ( Java 15+) keep multi - line SQL readable
        //Every user has its own table
        String userTable = """
            CREATE TABLE IF NOT EXISTS users (
                id            INTEGER PRIMARY KEY AUTOINCREMENT,
                username      TEXT    NOT NULL,
                password      TEXT    NOT NULL,
                rank          TEXT    NOT NULL DEFAULT 'low',
                done          INTEGER NOT NULL DEFAULT 0,
                created       TEXT    DEFAULT(datetime('now'))
            )
            """;
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(userTable) ;
        } catch (SQLException e) {
            System.err.println(" userTables failed : " + e . getMessage () ) ;
        }
    }

    public void createPostTable(){
        // Text blocks ( Java 15+) keep multi - line SQL readable
        //Every user has its own table
        String postTable = """
            CREATE TABLE IF NOT EXISTS posts (
                id            INTEGER PRIMARY KEY AUTOINCREMENT,
                user_id       INTEGER NOT NULL,
                username      TEXT    NOT NULL,
                title         TEXT    NOT NULL,
                body          TEXT    NOT NULL,
                done          INTEGER NOT NULL DEFAULT 0,
                created       TEXT    DEFAULT(datetime('now'))
                FOREIGN KEY (user_id) REFERENCES users(id)
            )
            """;
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(postTable) ;
        } catch (SQLException e) {
            System.err.println(" postTables failed : " + e . getMessage () ) ;
        }
    }
//changed item  to table name | column name to username and password bec neither can be null
    public void insertItems(String name, String password){
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, name); // column// bind parameter 1 to ’name’
            pstmt.setString(2, password);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("insertItem failed: " + e.getMessage()) ;
        }

    }

    public List<String> getAllItems() {
        List<String> items = new ArrayList<>();
        String sql = "SELECT name FROM items WHERE done = 0 ORDER BY created DESC";

        //Try wtih resources closes both Statement and ResultSet sutomatically
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {                              //move to next row
                items.add(rs.getString("name")); //read column by name
            }
        } catch (SQLException e) {
            System.err.println("getAllItems failed: " + e.getMessage());
        }
        return items;
    }
    public void markDone(int id){
        String sql = "UPDATE items SET done = 1 WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("markDone failed : " + e.getMessage());
        }
    }

    public void deleteItem(int id) {
        String sql = " DELETE FROM items WHERE id = ? ";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(" deleteItem failed : " + e.getMessage());
        }
    }

}
