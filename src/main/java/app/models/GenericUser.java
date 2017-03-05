package app.models;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author Erik David Zubia Hernandez
 */
public class GenericUser {

    private String userName;
    private String password;
    private String email;

    public GenericUser(String userName, String password, String email) {
        this.userName = userName;
        this.password = this.password;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}
