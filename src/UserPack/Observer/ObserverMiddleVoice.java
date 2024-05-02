package UserPack.Observer;

import UserPack.VotingSystem;
import gui.Controlers.ConEvltOfEstabl;
import gui.Controlers.ConStatisticsEctb;

/**
 * Observes voters' activities and reacts accordingly.
 * Pattern: "Observer"
 */
public class ObserverMiddleVoice implements VotersFollower{
    private VotingSystem votingSystem;
    private ConStatisticsEctb statisticsController;
    private ConEvltOfEstabl evaluationController;

    private float midleVoicefigureRest;
    private float midleVoicefigureCafe;
    /**
     * Adds a statistics controller to the observer.
     *
     * @param statisticsController The statistics controller to be added.
     */
    public void addControler(ConStatisticsEctb statisticsController){
        this.statisticsController = statisticsController;
    }
    /**
     * Adds an evaluation controller to the observer.
     *
     * @param evaluationController The evaluation controller to be added.
     */
    public void addControlerEvl(ConEvltOfEstabl evaluationController){
        this.evaluationController = evaluationController;
    }
    /**
     * Initializes the observer with the specified voting system.
     *
     * @param votingSystem The voting system to observe.
     */

    public ObserverMiddleVoice(VotingSystem votingSystem){
        this.votingSystem=votingSystem;

    }

    /**
     * Informs the observer about voters' activities.
     * It calculates the middle voice figures for both restaurants and cafes based on the voting system,
     * and then updates the statistics controller with the calculated figures.
     */
    public void inform() {
        midleVoicefigureRest=votingSystem.calculateMidleVoicefiguresRestResultObserver();
        midleVoicefigureCafe= votingSystem.calculateMidleVoicefiguresCafeResultObserver();
        statisticsController.setTextmiddleVoiceAll(Float.toString(midleVoicefigureRest),Float.toString(midleVoicefigureCafe));
    }

    /**
     * Informs the observer specifically about evaluations.
     * It calculates the middle voice figures for both restaurants and cafes based on the voting system,
     * and then updates the evaluation controller with the calculated figures.
     */
    public void informForEvl() {
        midleVoicefigureRest=votingSystem.calculateMidleVoicefiguresRestResultObserver();
        midleVoicefigureCafe= votingSystem.calculateMidleVoicefiguresCafeResultObserver();
        evaluationController.setTextmiddleVoiceAll(Float.toString(midleVoicefigureRest),Float.toString(midleVoicefigureCafe));
    }
}
