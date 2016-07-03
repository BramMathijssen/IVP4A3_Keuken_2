package main.java.businesslogic;


import main.java.datastorage.LoginDAO;
/**
 *
 * @author Bram
 */
public class LoginManager {
        
    public LoginManager() {
    }
    //Method
    public boolean checkPassword(String username, String password){
        String hashedPasswordFromDB = (new LoginDAO()).
            getHashedPasswordForUsername(username);                
        if (hashedPasswordFromDB == null ){
            return false;
        }        
        return checkPassword(password, hashedPasswordFromDB);
    }
}

