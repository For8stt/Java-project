package UserPack;

public class Host extends User{
    public Host(String username, String password) {
        super.setUsername(username);
        super.setPassword(password);
    }
    public String getRol(){
        return "Host";
    }
}
