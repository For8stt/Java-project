package UserPack;


import java.io.Serializable;
/**
 * Represents a voter user.
 * Serialization is used {@link Serializable}
 * imitates the class {@link User}
 */
public class Voter  extends User implements  Serializable {

    protected middleVoiceAgr middleVoiceAgr;
   protected int koefHol=1;
    /**
     * Constructor for creating a voter user.
     * creates a class {@link middleVoiceAgr} which is an aggregation for this class which stores its average rating for the restaurant and cafe
     *
     * @param username The username of the voter.
     * @param password The password of the voter.
     */
    public Voter(String username,String password){
        super.setUsername(username);
        super.setPassword(password);
        super.login(username,password);

        creatMiddleVoiceAgr();
    }
    /**
     * Creates the middle voice aggregation.
     * This is an aggregation of this class
     */
    public void creatMiddleVoiceAgr(){
        middleVoiceAgr=new middleVoiceAgr(0,0);
    }
    /**
     * Gets the middle voice aggregation.
     *
     * @return The middle voice aggregation.
     */
    public middleVoiceAgr getMiddleVoiceAgr(){
        return this.middleVoiceAgr;
    }
    /**
     * Sets the coefficient of the vote.
     * The coefficient of which shows the strength of the voter's vote
     *
     * @param koefHol The coefficient of the vote.
     */
    public void setKoefHol(int koefHol){
        this.koefHol=koefHol;
    }
    /**
     * Gets the role of the voter.
     *
     * @return The role of the voter.
     */
    public String getRol(){
        return "Votera";
    }

    /**
     * Gets the coefficient of the vote.
     *
     * @return The coefficient of the vote.
     */
    public int getKoefHol(){
        return this.koefHol;
    }


}
