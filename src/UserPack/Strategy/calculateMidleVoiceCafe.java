package UserPack.Strategy;

import UserPack.SimpleVoter;
import UserPack.VotingSystem;

import java.util.ArrayList;

/**
 * A strategy for calculating the middle voice for cafe voting.
 * implements interface methods {@link middleVoiceStrategy}
 * Pattern: "Strategy"
 */
public class calculateMidleVoiceCafe implements middleVoiceStrategy{

    /**
     * Calculates the middle voice for cafe voting based on the provided voting system and user.
     * It iterates through the cafes voted for by the user and calculates the average vote,
     * taking into account the user's coefficient of influence if applicable.
     * The result is rounded to one decimal place and stored in the user's middle voice aggregator.
     *
     * @param votingSystem The voting system used for calculation.
     * @param akyUser      The user for whom the middle voice is calculated.
     */
    @Override
    public void calculateMidleVoice(VotingSystem votingSystem, int akyUser) {
        ArrayList<ArrayList<Boolean>> votesCafes = votingSystem.getVotesCafes();
        ArrayList<ArrayList<Integer>> votesHodCafes = votingSystem.getVotesHodCafes();

        int sum = 0;
        int numberOfVotes = 0;
        for (int i = 0; i < votingSystem.getKolkoCafes(); i++) {
            if (votesCafes.get(akyUser).get(i)) {
                if (votingSystem.getVoter(akyUser) instanceof SimpleVoter) {
                    sum += votesHodCafes.get(akyUser).get(i);
                    numberOfVotes++;
                }else {
                    sum += votesHodCafes.get(akyUser).get(i);
                    numberOfVotes+=votingSystem.getVoter(akyUser).getKoefHol();
                }
            }
        }

        if (numberOfVotes == 0) {
            votingSystem.getVoter(akyUser).getMiddleVoiceAgr().setMiddleVoiceCafe(0);
        }else {
            float res=(float)sum/numberOfVotes;
            res=Math.round(res*10)/10.0f;
            votingSystem.getVoter(akyUser).getMiddleVoiceAgr().setMiddleVoiceCafe(res);
        }

    }
}
