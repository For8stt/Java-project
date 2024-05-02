package UserPack;

import UserPack.Observer.middleVoice;

import java.io.Serializable;

/**
 * Represents a middle voice aggregator.
 * Serialization is used {@link Serializable}
 * implements interface methods {@link middleVoice}
 */
public class middleVoiceAgr implements middleVoice, Serializable {
    /** The middle voice figure for restaurants. */
    protected float midleVoicefigureRest;
    /** The middle voice figure for cafes. */
    protected float midleVoicefigureCafe;

    /**
     * Constructor for creating a middle voice aggregator.
     *
     * @param midleVoicefigureRest The middle voice figure for restaurants.
     * @param midleVoicefigureCafe The middle voice figure for cafes.
     */
    public middleVoiceAgr(float midleVoicefigureRest, float midleVoicefigureCafe){
        this.midleVoicefigureRest=midleVoicefigureRest;
        this.midleVoicefigureCafe=midleVoicefigureCafe;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMiddleVoiceRest(float midleVoicefigureRest) {
        this.midleVoicefigureRest=midleVoicefigureRest;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public float getMiddleVoiceRest() {
        return this.midleVoicefigureRest;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setMiddleVoiceCafe(float midleVoicefigureCafe) {
        this.midleVoicefigureCafe=midleVoicefigureCafe;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public float getMiddleVoiceCafe() {
        return this.midleVoicefigureCafe;
    }
}
