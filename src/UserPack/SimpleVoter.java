package UserPack;

public class SimpleVoter extends Voter{
    public SimpleVoter(String username, String password) {
        super(username, password);
        setKoefHol(1);
    }
    @Override
    public String getRol(){
        return "Voter";
    }
    public void setKoefHol(int koefHol){
        super.koefHol=koefHol;
    }
    public int getKoefHol(){
        return super.koefHol;
    }

}
