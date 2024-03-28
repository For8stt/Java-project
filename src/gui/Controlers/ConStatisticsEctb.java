package gui.Controlers;

import UserPack.VotingSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ConStatisticsEctb {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private BarChart<String,Float> barChart;
    @FXML
    private RadioButton rChange;
    @FXML
    private TextArea statisticasVoters;


    private VotingSystem votingSystem;
    public void setVotingSystem(VotingSystem votingSystem) {
        this.votingSystem = votingSystem;
    }
    public void SetUnvisiable(){
        barChart.setVisible(true);
        statisticasVoters.setVisible(false);
    }
    public void rStatisticsChange(ActionEvent event){
        if (rChange.isSelected()){
            barChart.setVisible(false);
            statisticasVoters.setVisible(true);
        }else {
            barChart.setVisible(true);
            statisticasVoters.setVisible(false);

        }
    }
    public void setTextStatisticasVoters(){



    }
    public void SetBarChart(){
        XYChart.Series series=new XYChart.Series<>();
        series.setName("Establishment statistics");
        for (int i = 0; i < votingSystem.getKolkoRest(); i++) {
//            series.getData().add(new XYChart.Data(votingSystem.getRestaurant(i).getNameRestaurant(),votingSystem.getRestaurant(i).getHodnota()));
            series.getData().add(new XYChart.Data(votingSystem.getRestaurant(i).getNameRestaurant(),votingSystem.getRestaurant(i).getHodnotaRew()));

        }
        for (int i = 0; i < votingSystem.getKolkoCafes(); i++) {
//            series.getData().add(new XYChart.Data(votingSystem.getRestaurant(i).getNameRestaurant(),votingSystem.getRestaurant(i).getHodnota()));
            series.getData().add(new XYChart.Data(votingSystem.getCafe(i).getNameCafe(),votingSystem.getCafe(i).getHodnotaRew()));

        }
        barChart.getData().add(series);
    }
    public void switchToVotingPlace(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/View/votingPlace1.fxml"));
        root = loader.load();

        conForVotingPlace votingPlace1Controller = loader.getController();
        votingPlace1Controller.setVotingSystem(votingSystem);
        votingPlace1Controller.setUnvisidbleHost();

        votingPlace1Controller.akyUserJe(votingSystem.getAkyUser());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}
