import java.sql.*;

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
//            createTables();   // set up schema on first run
        }catch (SQLException e){
            System.err.println("Connection failed: " + e.getMessage());
        }
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




}
