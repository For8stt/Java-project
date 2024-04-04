package UserPack;

import java.io.Serializable;

public abstract class User implements Serializable {
    protected String username;
    protected String password;
    public abstract String getRol();


    public void setUsername(String username){
        this.username=username;
    }
    public  String getUsername(){
        return this.username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public  String getPassword(){
        return this.password;
    }
    

    public boolean login(String username,String password){
        if (this.username.equals(username) && this.password.equals(password)){
            return true;
        }else{
            return false;
        }
    }
}
