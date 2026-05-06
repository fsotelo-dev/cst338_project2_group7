import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Angel Magana
 * created: 4/26/26
 * @since Assignment: INFERIOR APP
 **/

public class SceneFactoryTest {

        @Test
        void testAllSceneTypesExist() {
            SceneType[] types = SceneType.values();
            assertNotNull(types, "SceneType values should not be null");
            assertTrue(types.length > 0, "Should have at least one SceneType");
        }

        @Test
        void testLoginTypeExists() {
            assertDoesNotThrow(() -> SceneType.valueOf("LOGIN"),
                    "LOGIN should be a valid SceneType");
        }

        @Test
        void testSignupTypeExists() {
            assertDoesNotThrow(() -> SceneType.valueOf("SIGNUP"),
                    "SIGNUP should be a valid SceneType");
        }

        @Test
        void testMainTypeExists() {
            assertDoesNotThrow(() -> SceneType.valueOf("MAIN"),
                    "MAIN should be a valid SceneType");
        }

        @Test
        void testProfileTypeExists() {
            assertDoesNotThrow(() -> SceneType.valueOf("PROFILE"),
                    "PROFILE should be a valid SceneType");
        }

        @Test
        void testSettingsTypeExists() {
            assertDoesNotThrow(() -> SceneType.valueOf("SETTINGS"),
                    "SETTINGS should be a valid SceneType");
        }

        @Test
        void testPostTypeExists() {
            assertDoesNotThrow(() -> SceneType.valueOf("POST"),
                    "POST should be a valid SceneType");
        }

        @Test
        void testCommentTypeExists() {
            assertDoesNotThrow(() -> SceneType.valueOf("COMMENT"),
                    "COMMENT should be a valid SceneType");
        }

        @Test
        void testLogoutTypeExists() {
            assertDoesNotThrow(() -> SceneType.valueOf("LOGOUT"),
                    "LOGOUT should be a valid SceneType");
        }

        @Test
        void testCreatePostTypeExists() {
            assertDoesNotThrow(() -> SceneType.valueOf("CREATE_POST"),
                    "CREATE_POST should be a valid SceneType");
        }

        @Test
        void testSceneTypeCount() {
            assertEquals(9, SceneType.values().length,
                    "Should have exactly 9 SceneTypes matching SceneFactory cases");
        }

        @Test
        void testSceneTypeEquality() {
            assertEquals(SceneType.LOGIN, SceneType.LOGIN);
            assertNotEquals(SceneType.LOGIN, SceneType.SIGNUP);
        }

        @Test
        void testSceneTypeValueOf() {
            assertEquals(SceneType.LOGIN,       SceneType.valueOf("LOGIN"));
            assertEquals(SceneType.SIGNUP,      SceneType.valueOf("SIGNUP"));
            assertEquals(SceneType.MAIN,        SceneType.valueOf("MAIN"));
            assertEquals(SceneType.PROFILE,     SceneType.valueOf("PROFILE"));
            assertEquals(SceneType.SETTINGS,    SceneType.valueOf("SETTINGS"));
            assertEquals(SceneType.POST,        SceneType.valueOf("POST"));
            assertEquals(SceneType.COMMENT,     SceneType.valueOf("COMMENT"));
            assertEquals(SceneType.LOGOUT,      SceneType.valueOf("LOGOUT"));
            assertEquals(SceneType.CREATE_POST, SceneType.valueOf("CREATE_POST"));
        }

        @Test
        void testInvalidSceneType() {
            assertThrows(IllegalArgumentException.class, () ->
                            SceneType.valueOf("INVALID"),
                    "Unknown SceneType should throw IllegalArgumentException");
        }
}
