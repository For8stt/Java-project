package UserPack;

/**
 * Represents a simple voter user.
 * imitates the class {@link Voter}
 */
public class SimpleVoter extends Voter{
    /**
     * Constructor for creating a simple voter user.
     *
     * @param username The username of the voter.
     * @param password The password of the voter.
     */
    public SimpleVoter(String username, String password) {
        super(username, password);
        setKoefHol(1);
    }
    /**
     * Gets the role of the simple voter.
     *
     * @return The role of the simple voter.
     */
    @Override
    public String getRol(){
        return "Voter";
    }
    /**
     * Sets the coefficient of the vote.
     *
     * @param koefHol The coefficient of the vote.
     */
    public void setKoefHol(int koefHol){
        super.koefHol=koefHol*1;
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
