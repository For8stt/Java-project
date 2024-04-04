package gui.Controlers;

import UserPack.VotingSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ConStatisticsEctb {
    private Parent root;

    @FXML
    private BorderPane statisticBP;
    @FXML
    private BarChart<String,Float> barChart;
    @FXML
    private RadioButton rChange;
    @FXML
    private TextArea statisticasVoters;
    @FXML
    private Label resultsOfBuuton;


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
            statisticasVoters.setEditable(false);
            setTextStatisticasVoters();
            resultsOfBuuton.setText("");
        }else {
            barChart.setVisible(true);
            statisticasVoters.setVisible(false);
            resultsOfBuuton.setText("");

        }
    }
    public void setTextStatisticasVoters(){
        statisticasVoters.setText(votingSystem.setStatistics());
    }
    public void SetBarChart(){
        XYChart.Series series=new XYChart.Series<>();
        series.setName("Establishment statistics");
        for (int i = 0; i < votingSystem.getKolkoRest(); i++) {
            series.getData().add(new XYChart.Data(votingSystem.getRestaurant(i).getNameRestaurant(),votingSystem.getRestaurant(i).getHodnotaRew()));
        }
        for (int i = 0; i < votingSystem.getKolkoCafes(); i++) {
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

        statisticBP.setCenter(root);

    }
    public void saveButt(ActionEvent event){
        try {
            votingSystem.save();
            resultsOfBuuton.setText("vote saved ");
        } catch (IOException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
    }
    public void loadButt(ActionEvent event){
        try {
            votingSystem.load();
            resultsOfBuuton.setText("voting is uploaded ");
            barChart.getData().clear();
            SetBarChart();
            if (rChange.isSelected()){
                setTextStatisticasVoters();
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
    public void newholos(ActionEvent event){
        votingSystem.obnulyt();
        resultsOfBuuton.setText("voting is cleared");
        barChart.getData().clear();
        SetBarChart();
        if (rChange.isSelected()){
            setTextStatisticasVoters();
        }
    }
}
