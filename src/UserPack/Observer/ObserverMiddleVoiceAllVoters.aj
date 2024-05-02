package UserPack.Observer;


import UserPack.VotingSystem;
import gui.Controlers.ConEvltOfEstabl;
import gui.Controlers.ConStatisticsEctb;




import java.util.ArrayList;
import java.util.List;

/**
 * Aspect to observe and manage middle voice calculations for all voters.
 * {@code after() returning(VotingSystem g): call(VotingSystem.new())} Aspect initialization after creating a new VotingSystem object. This method is called after
 * creating a new object of type VotingSystem. It initializes the votingSystem variable with the new object and creates an instance of
 * ObserverMiddleVoice to observe this voting system. Then, the aspect adds this observer to the list of observers of the votingSystem.
 * {@code before(ConStatisticsEctb x): call(void gui.Controlers.conForVotingPlace.sw2(ConStatisticsEctb)) && args(x)} Aspect intercepts before switching to the statistics view.
 * This method is called before switching to the statistics page. It adds the statistics controller to the ObserverMiddleVoice observer.
 * {@code after(): execution(void gui.Controlers.conForVotingPlace.switchToStatistics(javafx.event.ActionEvent)} Aspect intercepts after switching to the statistics view or loading data.
 * This method is called after performing certain operations, such as switching to the statistics page, creating a new vote in ConStatisticsEctb, or loading data. It notifies all observers about voting in restaurants
 * {@code before(ConEvltOfEstabl x): call(void gui.Controlers.conForVotingPlace.sw1(ConEvltOfEstabl)) && args(x)} Aspect intercepts before switching to the evaluation view
 * This method is called before switching to the evaluation page. It adds the evaluation controller to the ObserverMiddleVoice observer.
 * {@code after(): execution(void gui.Controlers.conForVotingPlace.switchToEvaluation(javafx.event.ActionEvent)) ||execution(void gui.Controlers.ConEvltOfEstabl.newHodnota(javafx.event.ActionEvent))} Aspect intercepts after switching to the evaluation view or performing a new evaluation.
 * This method is called after performing operations, such as switching to the evaluation page or creating a new vote in ConEvltOfEstabl. It notifies all observers about voting in the evaluation section
 */
public aspect ObserverMiddleVoiceAllVoters {

    /**
     * Declare necessary variables
     */
    VotingSystem votingSystem;
    public ObserverMiddleVoice observerMiddleVoice;

    transient private List<VotersFollower> VotingSystem.clashFollowerss = new ArrayList<>();
    /**
     * Method for the VotingSystem to follow a follower.
     * @param clashFollowerr The follower to be added.
     */
    public void VotingSystem.followClashh(VotersFollower clashFollowerr) {
        clashFollowerss.add(clashFollowerr);
    }


    after() returning(VotingSystem g): call(VotingSystem.new()) {
        votingSystem = g;

        observerMiddleVoice = new ObserverMiddleVoice(votingSystem);
        votingSystem.followClashh(observerMiddleVoice);
        System.out.println("1");
    }

    /**
     * Method to notify observers about voters' activities.
     */
    public void VotingSystem.notifyObserverss() {
        for (VotersFollower c : clashFollowerss)
            c.inform();
    }
    /**
     * Method to notify observers specifically about evaluations.
     */
    public void VotingSystem.notifyObserverssEvl() {
        for (VotersFollower c : clashFollowerss)
            c.informForEvl();
    }

    before(ConStatisticsEctb x): call(void gui.Controlers.conForVotingPlace.sw2(ConStatisticsEctb)) && args(x) {
        observerMiddleVoice.addControler(x);
        System.out.println("Before switchToStatistics");
    }

    after(): execution(void gui.Controlers.conForVotingPlace.switchToStatistics(javafx.event.ActionEvent))
            || execution(void gui.Controlers.ConStatisticsEctb.newholos(javafx.event.ActionEvent))
            || execution(void gui.Controlers.ConStatisticsEctb.loadButt(javafx.event.ActionEvent)){
        System.out.println("After switchToStatistics or loadClean");
        votingSystem.notifyObserverss();
    }

    before(ConEvltOfEstabl x): call(void gui.Controlers.conForVotingPlace.sw1(ConEvltOfEstabl)) && args(x) {
        observerMiddleVoice.addControlerEvl(x);
        System.out.println("Before switchToEvaluation");

    }


    after(): execution(void gui.Controlers.conForVotingPlace.switchToEvaluation(javafx.event.ActionEvent))
    ||execution(void gui.Controlers.ConEvltOfEstabl.newHodnota(javafx.event.ActionEvent)) {
        System.out.println("After switchToEvaluation or do newHodnota");
        votingSystem.notifyObserverssEvl();
    }



}
