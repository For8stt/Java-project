package gui.Controlers;

import UserPack.VotingSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;


public class conForVotingPlace {
    private Parent root;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label rolLabel;
    @FXML
    private BorderPane votingPlaceBP;

    @FXML
    private Label passwordLabel;
    @FXML
    private Button switchToEvaluation;
    @FXML
    private Button switchToStatistics;

    private VotingSystem votingSystem;
    public void setVotingSystem(VotingSystem votingSystem) {
        this.votingSystem = votingSystem;
    }


    public void displayNamePassword(String username,String password,String rol){
        usernameLabel.setText("Your Username: " + username);
        passwordLabel.setText("Your Password: " + password);
        rolLabel.setText("Title: "+rol);
    }
    public void akyUserJe(int i){
        if (i==-2){
            displayNamePassword(votingSystem.getHost().getUsername(),votingSystem.getHost().getPassword(), votingSystem.getHost().getRol());
        }else {
            displayNamePassword(votingSystem.getVoter(i).getUsername(),votingSystem.getVoter(i).getPassword(),votingSystem.getVoter(i).getRol());
        }
    }
    public void setUnvisidbleHost(){
        switchToEvaluation.setVisible(false);
    }
    public void setUnvisidbleVoter(){
        switchToStatistics.setVisible(false);
    }

public void switchToEvaluation(ActionEvent event) throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/View/EvaluationOfEstablishments.fxml"));
    root = loader.load();

    ConEvltOfEstabl evaluationController = loader.getController();
    evaluationController.setVotingSystem(votingSystem);
    evaluationController.setChoiseBox();

    votingPlaceBP.setCenter(root);

}

public void switchToOverview(ActionEvent event) throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/View/OverviewOfEstablishment.fxml"));
    root = loader.load();

    ConOvrvOfEstab overviewController = loader.getController();
    overviewController.setVotingSystem(votingSystem);

    overviewController.setChoiseBox();
    overviewController.setTextAreaNotWrite();





    votingPlaceBP.setCenter(root);

}

public void switchToLogin(ActionEvent event) throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/View/login.fxml"));
     root = loader.load();

    conForLogin loginController = loader.getController();
    loginController.setVotingSystem(votingSystem);
    loginController.SetUnvisiable();

    votingPlaceBP.setCenter(root);
}

    public void switchToStatistics(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/View/statisticOfEstablishment.fxml"));
        root = loader.load();

        ConStatisticsEctb statisticsController = loader.getController();
        statisticsController.setVotingSystem(votingSystem);
        statisticsController.SetBarChart();
        statisticsController.SetUnvisiable();

        votingPlaceBP.setCenter(root);
    }
}
