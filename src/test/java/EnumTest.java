import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author Freddy Sotelo
 * created: 4/26/26
 * @since Assignment: App
 **/
public class EnumTest {
    @Test
    void enum_hasLoginValue(){
        assertNotNull(SceneType.LOGIN);
    }
    @Test
    void enum_hasSignupValue(){
        assertNotNull(SceneType.SIGNUP);
    }
    @Test
    void enum_hasMainValue(){
        assertNotNull(SceneType.MAIN);
    }
    @Test
    void enum_hasProfileValue(){
        assertNotNull(SceneType.PROFILE);
    }
    @Test
    void enum_count_isThree(){
    assertEquals(4, SceneType.values().length);
    }
    @Test
    void enum_Login_returnscorrectType(){
    assertEquals(SceneType.LOGIN, SceneType.valueOf("LOGIN"));
    }
    @Test
    void enum_Main_returnscorrectType(){
    assertEquals(SceneType.MAIN, SceneType.valueOf("MAIN"));
    }
    @Test
    void enum_Signup_returncsorrectType(){
    assertEquals(SceneType.SIGNUP, SceneType.valueOf("SIGNUP"));
    }
    @Test
    void enum_Profile_returncsorrectType(){
        assertEquals(SceneType.PROFILE, SceneType.valueOf("PROFILE"));
    }
}
