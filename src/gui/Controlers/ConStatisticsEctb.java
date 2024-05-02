package gui.Controlers;

import UserPack.VotingSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
/**
 * Controller class for the Statistics of Establishment view.
 */
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
    @FXML
    private TextArea middleVoiceAll;
    @FXML
    private Label middleAll;


    private VotingSystem votingSystem;
    /**
     * Sets the VotingSystem instance.
     * @param votingSystem The VotingSystem instance
     */
    public void setVotingSystem(VotingSystem votingSystem) {
        this.votingSystem = votingSystem;
    }
    /**
     * Sets visibility options for the statistics display.
     */
    public void SetUnvisiable(){
        barChart.setVisible(true);
        statisticasVoters.setVisible(false);
        middleVoiceAll.setVisible(false);
        middleAll.setVisible(false);
    }

    /**
     * Handles the action of switching between different statistics display options.
     * @param event The ActionEvent triggering the method
     */
    public void rStatisticsChange(ActionEvent event){
        if (rChange.isSelected()){
            barChart.setVisible(false);
            middleVoiceAll.setVisible(true);
            middleAll.setVisible(true);
            middleVoiceAll.setEditable(false);
            statisticasVoters.setVisible(true);
            statisticasVoters.setEditable(false);
            setTextStatisticasVoters();
            resultsOfBuuton.setText("");
        }else {
            middleVoiceAll.setVisible(false);
            middleAll.setVisible(false);
            barChart.setVisible(true);
            statisticasVoters.setVisible(false);
            resultsOfBuuton.setText("");

        }

    }
    /**
     * Sets the text for the middle voice display.
     * @param text1 Text for the first part of the display
     * @param text2 Text for the second part of the display
     */
    public void setTextmiddleVoiceAll(String text1, String text2){
        middleVoiceAll.setText("Rest: "+text1+"\n"+"Cafe: "+text2);
    }
    /**
     * Sets the text for the statistics of voters display.
     */
    public void setTextStatisticasVoters(){
        statisticasVoters.setText(votingSystem.setStatistics());
    }
    /**
     * Sets up the BarChart with establishment statistics.
     */
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
    /**
     * Switches to the voting place view.
     * @param event The ActionEvent triggering the method
     * @throws IOException If an error occurs during the process
     */
    public void switchToVotingPlace(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/View/votingPlace1.fxml"));
        root = loader.load();

        conForVotingPlace votingPlace1Controller = loader.getController();
        votingPlace1Controller.setVotingSystem(votingSystem);
        votingPlace1Controller.setUnvisidbleHost();

        votingPlace1Controller.akyUserJe(votingSystem.getAkyUser());

        statisticBP.setCenter(root);

    }
    /**
     * Saves the voting data.
     * @param event The ActionEvent triggering the method
     */
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
    /**
     * Loads the voting data.
     * @param event The ActionEvent triggering the method
     */
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
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("WARNING");
            a.setContentText("No previous votes have been uploaded to the file");
            a.showAndWait();
        }
    }
    /**
     * Resets the voting data.
     * @param event The ActionEvent triggering the method
     */
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
