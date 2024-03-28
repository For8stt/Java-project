package UserPack;

public class ExpertVoter extends Voter{

    public ExpertVoter(String username, String password) {
        super(username, password);
        setKoefHol(1);
    }
    @Override
    public String getRol(){
       return "Expert";
    }
    public void setKoefHol(int koefHol){
        super.koefHol=koefHol*3;
    }
    public int getKoefHol(){
        return super.koefHol;
    }
}
