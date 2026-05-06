public class UserManager {
    private String currentUser;
    private String currentUserPassword;
    private final UserDAO userDAO;
    private static UserManager instance;

    private UserManager(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    public static UserManager getInstance(){
        if (instance==null){
            instance = new UserManager(new UserDAO());
        }
        return instance;
    }

    public String getCurrentUser() {
        return currentUser;
    }
    public String getCurrentUserPassword() {
        return currentUserPassword;
    }
    /**
     * Login connection
     */
    public boolean login(String username, String password){
        boolean loginSuccessfulStatus = userDAO.userLogin(username, password);
        if(loginSuccessfulStatus){
            currentUser = username;
            currentUserPassword = password;
        }
        return loginSuccessfulStatus;
    }
    /**
     * signup checks if username exists and the signup connection logic
     * should it check if password is taken?
     */
    public boolean signup(String username, String password, String rank){
        if(userDAO.getUserByUsername(username)!=null){
            return false;
        }
        return userDAO.insertUser(username, password, rank);
    }
    /**
     * for settingController
     * update password
     */
    public boolean updatePassword(String newPassword){
        if(currentUserPassword ==null) return false;
        if(userDAO.getUserByPassword(newPassword)!=null){
            return false;
        }
        boolean updateSuccessfulStatus = userDAO.updatePassword(currentUserPassword, newPassword);
        if(updateSuccessfulStatus)currentUserPassword = newPassword;
        return userDAO.updatePassword(currentUser, newPassword);
    }
    /**
     * for settingController
     * update username: like signup, checks if the field input is taken.
     */
    public boolean updateUsername(String newUsername){
        if(currentUser ==null)return false;
        if(userDAO.getUserByUsername(newUsername)!=null){
            return false;
        }
        boolean updateSuccessfulStatus = userDAO.updateUsername(currentUser, newUsername);
        if(updateSuccessfulStatus)currentUser = newUsername;
        return updateSuccessfulStatus;
    }


}
