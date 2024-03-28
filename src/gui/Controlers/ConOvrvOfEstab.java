package gui.Controlers;


import UserPack.VotingSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

 public class ConOvrvOfEstab{
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private TextArea OverviewRest;
    @FXML
    private Label myLabel;
    @FXML
    private ChoiceBox<String> myChoiseBox;
    @FXML
    private Button bShowBar;

    private VotingSystem votingSystem;
    public void setVotingSystem(VotingSystem votingSystem) {
        this.votingSystem = votingSystem;
    }
    public void setTextAreaNotWrite(){
        OverviewRest.setEditable(false);
        OverviewRest.setDisable(true);
    }
//    private int kolko;
//    AmericanRestaurant amer=new AmericanRestaurant();
//    AsianRestaurant asian=new AsianRestaurant();

//    public void switchToVotingPlace(ActionEvent event)throws IOException {
//        root= FXMLLoader.load(getClass().getResource("/gui/View/votingPlace1.fxml"));
//        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
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

         stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        ///чомй я його сторюю якщо я вже його передав
//        if (votingSystem== null){
//            votingSystem = new VotingSystem();
//            System.out.println("novy votingSystem");
//        }
//
//
//        kolko = votingSystem.getKolko();
////        myChoiseBox.getItems().addAll(food);
////        myChoiseBox.getItems().add(asian.getAsianName());
//        myChoiseBox.getItems().add(amer.getAmericanName());
//        for (int i=0;i<kolko;i++){
//            myChoiseBox.getItems().add(votingSystem.getRestaurant(i).getNameRestaurant());
//        }
//
//        myChoiseBox.setOnAction(this::getFood);
//    }

    public void setChoiseBox()throws IOException {

//        kolko = votingSystem.getKolkoRest();

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
//        if ("American Restaurant".equals(selection)){
//            OverviewRest.setText(amer.displayInfo());
//        }else if ("Asian Restaurant".equals(selection)){
//            OverviewRest.setText(asian.displayInfo());
//        }
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


