public class UserManager {
    private String currentUser;
    private final UserDAO userDAO;



    public UserManager(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    public String getCurrentUser() {
        return currentUser;
    }
    /**
     * Login connection
     */
    public boolean login(String username, String password){
        boolean loginSuccessfulStatus = userDAO.userLogin(username, password);
        if(loginSuccessfulStatus){
            currentUser = username;
        }
        return loginSuccessfulStatus;
    }
    /**
     * signup checks if username exists and the signup connection logic
     * should it check if password is taken?
     */
    public boolean signup(String username, String password){
        if(userDAO.getUserByUsername(username)!=null){
            return false;
        }
        return userDAO.insertUser(username, password);
    }
    /**
     * for settingController
     * update password
     */
    public boolean updatePassword(String newPassword){
        if(currentUser ==null) return false;
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
