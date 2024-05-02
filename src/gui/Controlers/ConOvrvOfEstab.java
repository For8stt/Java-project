package gui.Controlers;


import UserPack.VotingSystem;
import javafx.application.Platform;
import javafx.concurrent.Task;
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

/**
 * Controller class for the Overview of Establishment view.
 */
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
    /**
     * Sets the VotingSystem instance.
     * @param votingSystem The VotingSystem instance
     */
    public void setVotingSystem(VotingSystem votingSystem) {
        this.votingSystem = votingSystem;
    }
    /**
     * Disables editing of the TextArea.
     */
    public void setTextAreaNotWrite(){
        OverviewRest.setEditable(false);
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

        votingPlace1Controller.akyUserJe(votingSystem.getAkyUser());
        if (votingSystem.getAkyUser()==-2){
            votingPlace1Controller.setUnvisidbleHost();
        }else {
            votingPlace1Controller.setUnvisidbleVoter();
        }

        overviewBP.setCenter(root);
    }
    /**
     * Sets the items of the ChoiceBox based on the restaurants and cafes in the system.
     * @throws IOException If an error occurs during the process
     */

    public void setChoiseBox()throws IOException {

        for (int i=0;i<votingSystem.getKolkoRest();i++){
            myChoiseBox.getItems().add(votingSystem.getRestaurant(i).getNameRestaurant());
        }
        for (int i=0;i<votingSystem.getKolkoCafes();i++){
            myChoiseBox.getItems().add(votingSystem.getCafe(i).getNameCafe());
        }

        myChoiseBox.setOnAction(this::getFood);
    }
    /**
     * Displays the information of the selected restaurant or cafe.
     * @param event The ActionEvent triggering the method
     * @throws IOException If an error occurs during the process
     */
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
    /**
     * Gets the selected restaurant or cafe from the ChoiceBox.
     * @param event The ActionEvent triggering the method
     */
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
    /**
     * Displays the menu of the selected restaurant or cafe.
     * @param event The ActionEvent triggering the method
     * @throws IOException If an error occurs during the process
     */
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
//    public void showBar(ActionEvent event)throws IOException{
//        String selection = myChoiseBox.getValue();
//
//        for (int i=0;i<votingSystem.getKolkoRest();i++) {
//            if (votingSystem.getRestaurant(i).getNameRestaurant().equals(selection)) {
//                OverviewRest.setText(votingSystem.getRestaurant(i).getBar());
//            }
//        }
//    }
//     public void showBar(ActionEvent event) {
//         String selection = myChoiseBox.getValue();
//
//         Thread thread = new Thread(() -> {
//             for (int i = 0; i < votingSystem.getKolkoRest(); i++) {
//                 if (votingSystem.getRestaurant(i).getNameRestaurant().equals(selection)) {
//                     String barInfo = votingSystem.getRestaurant(i).getBar();
//
//                     Platform.runLater(() -> OverviewRest.setText(barInfo));
//
//                     break;
//                 }
//             }
//         });
//
//         thread.start();
//     }


    /**
     * Displays the bar information of the selected restaurant.
     * This method runs in a separate thread.
     */
     public void showBar(ActionEvent event) {
         String selection = myChoiseBox.getValue();

         Task<String> task = new Task<String>() {
             @Override
             protected String call() throws Exception {
                 for (int i = 0; i < votingSystem.getKolkoRest(); i++) {
                     if (votingSystem.getRestaurant(i).getNameRestaurant().equals(selection)) {
                         return votingSystem.getRestaurant(i).getBar();
                     }
                 }
                 return null;
             }
         };

         task.setOnSucceeded(e -> {
             String barInfo = task.getValue();
             OverviewRest.setText(barInfo);
         });

         Thread thread = new Thread(task);
         thread.start();
     }

 }


