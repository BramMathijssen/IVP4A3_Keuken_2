package main.java.datastorage;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.datastorage.DatabaseConnection;

public class LoginDAO {
    // Attributes
    private final DatabaseConnection dbc ;
    private final Connection con ;
    private static final String SQL = "SQL: ";

    public LoginDAO() {
        this.dbc = new DatabaseConnection();
        this.con = dbc.getOpenConnection();
    }
  

    public String getHashedPasswordForUsername(String username) {
        ResultSet resultset;
        String s = null;
        try {
            Statement st = con.createStatement();
            String query = "SELECT `password` FROM `userlogin` WHERE `username` = \"" + username + "\";";
            resultset = st.executeQuery(query);
                
            if (resultset != null & resultset.next()) {
                s = resultset.getString("password");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, SQL, ex);
        }
        return s;
    }
}

