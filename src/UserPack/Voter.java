package UserPack;

public class Voter extends User{
   protected int koefHol=1;
    public Voter(String username,String password){
        super.setUsername(username);
        super.setPassword(password);
        super.login(username,password);
    }
    public void setKoefHol(int koefHol){
        this.koefHol=koefHol;
    }
    public String getRol(){
        return "Votera";
    }

    public int getKoefHol(){
        return this.koefHol;
    }
}
