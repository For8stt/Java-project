package UserPack.Strategy;

import UserPack.VotingSystem;

/**
 * An interface for middle voice calculation strategies.
 * Strategies for calculating the average vote.
 * Pattern: "Strategy"
 */
public interface middleVoiceStrategy {
    /**
     * Calculates the middle voice based on the provided voting system and user.
     *
     * @param votingSystem The voting system used for calculation.
     * @param akyUser      The user for whom the middle voice is calculated.
     */
    void calculateMidleVoice(VotingSystem votingSystem, int akyUser);
}
