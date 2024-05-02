package UserPack;

import java.io.Serializable;
/**
 * Abstract class representing a user.
 * are inherited by such classes as {@link Voter} and {@link Host}
 * Serialization is used {@link Serializable}
 */
public abstract class User implements Serializable {
    protected String username;
    protected String password;
    /**
     * Abstract method to get the role of the user.
     *
     * @return The role of the user.
     */
    public abstract String getRol();


    /**
     * Sets the username for the user.
     *
     * @param username The username to set.
     */
    public void setUsername(String username){
        this.username=username;
    }
    /**
     * Gets the username of the user.
     *
     * @return The username of the user.
     */
    public  String getUsername(){
        return this.username;
    }
    /**
     * Sets the password for the user.
     *
     * @param password The password to set.
     */
    public void setPassword(String password){
        this.password=password;
    }
    /**
     * Gets the password of the user.
     *
     * @return The password of the user.
     */
    public  String getPassword(){
        return this.password;
    }


    /**
     * Method to login a user.
     *
     * @param username The username to check.
     * @param password The password to check.
     * @return True if the username and password match, otherwise false.
     */
    public boolean login(String username,String password){
        if (this.username.equals(username) && this.password.equals(password)){
            return true;
        }else{
            return false;
        }
    }
}
