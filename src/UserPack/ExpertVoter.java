package UserPack;

/**
 * Represents an expert voter user.
 * imitates the class {@link Voter}
 */
public class ExpertVoter extends Voter{

    /**
     * Constructor for creating an expert voter user.
     *
     * @param username The username of the expert voter.
     * @param password The password of the expert voter.
     */
    public ExpertVoter(String username, String password) {
        super(username, password);
        setKoefHol(1);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String getRol(){
       return "Expert";
    }
    /**
     * Sets the coefficient of the vote.
     *
     * @param koefHol The coefficient of the vote.
     */
    public void setKoefHol(int koefHol){
        super.koefHol=koefHol*3;
    }
    /**
     * Gets the coefficient of the vote.
     *
     * @return The coefficient of the vote.
     */
    public int getKoefHol(){
        return super.koefHol;
    }
}
