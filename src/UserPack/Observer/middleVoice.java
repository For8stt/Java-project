package UserPack.Observer;
/**
 * An interface representing the middle voice functionality.
 */
public interface middleVoice {
    /**
     * Sets the middle voice figure for restaurants.
     *
     * @param midleVoicefigure The middle voice figure to set.
     */
    void setMiddleVoiceRest(float midleVoicefigure);
    /**
     * Gets the middle voice figure for restaurants.
     *
     * @return The middle voice figure for restaurants.
     */
    float getMiddleVoiceRest();
    /**
     * Sets the middle voice figure for cafes.
     *
     * @param midleVoicefigure The middle voice figure to set.
     */
    void setMiddleVoiceCafe(float midleVoicefigure);

    /**
     * Gets the middle voice figure for cafes.
     *
     * @return The middle voice figure for cafes.
     */
    float getMiddleVoiceCafe();
}
