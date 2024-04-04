package gui.Controlers;


import UserPack.VotingSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

 public class ConOvrvOfEstab{
    private Parent root;

    @FXML
    private TextArea OverviewRest;
    @FXML
    private Label myLabel;
    @FXML
    private ChoiceBox<String> myChoiseBox;
    @FXML
    private Button bShowBar;
    @FXML
    private BorderPane overviewBP;

    private VotingSystem votingSystem;
    public void setVotingSystem(VotingSystem votingSystem) {
        this.votingSystem = votingSystem;
    }
    public void setTextAreaNotWrite(){
        OverviewRest.setEditable(false);
    }
    public void switchToVotingPlace(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/View/votingPlace1.fxml"));
         root = loader.load();

        conForVotingPlace votingPlace1Controller = loader.getController();
        votingPlace1Controller.setVotingSystem(votingSystem);

        votingPlace1Controller.akyUserJe(votingSystem.getAkyUser());
        if (votingSystem.getAkyUser()==-2){
            votingPlace1Controller.setUnvisidbleHost();
        }else {
            votingPlace1Controller.setUnvisidbleVoter();
        }

        overviewBP.setCenter(root);
    }


    public void setChoiseBox()throws IOException {

        for (int i=0;i<votingSystem.getKolkoRest();i++){
            myChoiseBox.getItems().add(votingSystem.getRestaurant(i).getNameRestaurant());
        }
        for (int i=0;i<votingSystem.getKolkoCafes();i++){
            myChoiseBox.getItems().add(votingSystem.getCafe(i).getNameCafe());
        }

        myChoiseBox.setOnAction(this::getFood);
    }
    public void showInfRes(ActionEvent event)throws IOException{
        String selection = myChoiseBox.getValue();

        for (int i=0;i<votingSystem.getKolkoRest();i++) {
            if (votingSystem.getRestaurant(i).getNameRestaurant().equals(selection)) {
                OverviewRest.setText(votingSystem.getRestaurant(i).displayInfo());
            }
        }
        for (int i=0;i<votingSystem.getKolkoCafes();i++) {
            if (votingSystem.getCafe(i).getNameCafe().equals(selection)) {
                OverviewRest.setText(votingSystem.getCafe(i).displayInfo());
            }
        }
    }
    public void getFood(ActionEvent event){
        String myFood= myChoiseBox.getValue();
        myLabel.setText(myFood);

        int selectedIndex = myChoiseBox.getSelectionModel().getSelectedIndex();

        if (selectedIndex < votingSystem.getKolkoRest()) {

            bShowBar.setVisible(true);
        } else {
            bShowBar.setVisible(false);
        }
    }
    public void showMenu(ActionEvent event)throws IOException{
        String selection = myChoiseBox.getValue();

        for (int i=0;i<votingSystem.getKolkoRest();i++) {
            if (votingSystem.getRestaurant(i).getNameRestaurant().equals(selection)) {
                OverviewRest.setText(votingSystem.getRestaurant(i).getMenuRes());
            }
        }
        for (int i=0;i<votingSystem.getKolkoCafes();i++) {
            if (votingSystem.getCafe(i).getNameCafe().equals(selection)) {
                OverviewRest.setText(votingSystem.getCafe(i).getMenuCafe());
            }
        }
    }
    public void showBar(ActionEvent event)throws IOException{
        String selection = myChoiseBox.getValue();

        for (int i=0;i<votingSystem.getKolkoRest();i++) {
            if (votingSystem.getRestaurant(i).getNameRestaurant().equals(selection)) {
                OverviewRest.setText(votingSystem.getRestaurant(i).getBar());
            }
        }
    }
}


