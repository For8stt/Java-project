package UserPack.Observer;

/**
 * Interface for objects that observe voters' activities and react accordingly.
 * Pattern: "Observer"
 */
public interface VotersFollower {
    /**
     * Informs the observer about voters' activities.
     */
    void inform();
    /**
     * Informs the observer specifically about evaluations.
     */
    void informForEvl();
}
