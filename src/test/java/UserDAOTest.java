import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class UserDAOTest {

    private UserDAO df;

    @BeforeEach
    public void setup() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:sqlite::memory:");

        Statement stmt = connection.createStatement();
        stmt.execute("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT NOT NULL, password TEXT NOT NULL)");

        df = new UserDAO();
    }

//    @Test
//    public void testInsertUser() {
//        boolean result = df.insertUser("Devin", "password");
//        assertTrue(result);
//    }

    @Test
    public void testInsertUser(){
        boolean test = df.insertUser("","" );
        assertTrue(test);
    }

    @Test
    public void testGetUserByUsername() {
        df.insertUser("Devin", "password");
        String result = df.getUserByUsername("Devin");
        assertEquals("found: Devin", result);
    }

    @Test
    public void testUpdatePassword() {
        boolean result = df.updatePassword("Devin", "newPassword");
        assertTrue(result);
    }

    @Test
    public void testDeleteUser() {
        boolean result = df.deleteUser("Devin");
        assertTrue(result);
    }
// test to check if typing the incorrect password makes the login not work
    @Test
    public void testLoginWithWrongPassword() {
        df.insertUser("Devin", "correctPassword");
        boolean result = df.userLogin("Devin", "wrongPassword");
        assertFalse(result, "Login should fail with wrong password");
    }
// test to check if logging in with the correct password takes user to next page
    @Test
    public void testLoginWithCorrectPassword() {
        df.insertUser("Devin", "correctPassword");
        boolean result = df.userLogin("Devin", "correctPassword");
        assertTrue(result, "Login should succeed with correct password");
    }
}
