package gui.Controlers;

import UserPack.VotingSystem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConEvltOfEstabl implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ChoiceBox<String> restauraciaJe;
    @FXML
    private Label SelectRest;
    @FXML
    private TextField hodnotaRest;
    @FXML
    private Label ciUrobil;


    @FXML
    private Spinner<Integer> mySpinner;
    @FXML
    private Label myLabel;
    int currentValue;
    private VotingSystem votingSystem;
    public void setVotingSystem(VotingSystem votingSystem) {
        this.votingSystem = votingSystem;
    }

//    public void switchToVotingPlace(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("/gui/View/votingPlace1.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
public void switchToVotingPlace(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/View/votingPlace1.fxml"));
     root = loader.load();

    conForVotingPlace votingPlace1Controller = loader.getController();
    votingPlace1Controller.setVotingSystem(votingSystem);

    votingPlace1Controller.akyUserJe(votingSystem.getAkyUser());
    votingPlace1Controller.setUnvisidbleVoter();

     stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> valueFactory=
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,5);

        valueFactory.setValue(1);

        mySpinner.setValueFactory(valueFactory);

        currentValue= mySpinner.getValue();
        myLabel.setText(Integer.toString(currentValue));
        mySpinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                currentValue= mySpinner.getValue();
                myLabel.setText(Integer.toString(currentValue));
            }
        });
    }


    public void setChoiseBox()throws IOException{
        for (int i=0;i<votingSystem.getKolkoRest();i++){
            restauraciaJe.getItems().add(votingSystem.getRestaurant(i).getNameRestaurant());
        }
        for (int i=0;i<votingSystem.getKolkoCafes();i++){
            restauraciaJe.getItems().add(votingSystem.getCafe(i).getNameCafe());
        }

        restauraciaJe.setOnAction(this::getRestName);
    }
    public void getRestName(ActionEvent event){
        String nameRest=restauraciaJe.getValue();
        SelectRest.setText(nameRest);
    }
    public void showHodnota(ActionEvent event)throws IOException{
        String selection = restauraciaJe.getValue();
        for (int i=0;i<votingSystem.getKolkoRest();i++) {
            if (votingSystem.getRestaurant(i).getNameRestaurant().equals(selection)) {
//                hodnotaRest.setText("hodnota jeho je: "+votingSystem.getRestaurant(i).getHodnota());
                hodnotaRest.setText("hodnota jeho je: "+votingSystem.getRestaurant(i).getHodnotaRew());

                ciUrobil.setText("");
            }
        }

        for (int i=0;i<votingSystem.getKolkoCafes();i++) {
            if (votingSystem.getCafe(i).getNameCafe().equals(selection)) {
                hodnotaRest.setText("hodnota jeho je: "+votingSystem.getCafe(i).getHodnotaRew());

                ciUrobil.setText("");
            }
        }
    }
    public void newHodnota(ActionEvent event)throws IOException{
        int hodnota=mySpinner.getValue();
        String selection = restauraciaJe.getValue();
        boolean isCafe= votingSystem.isCafe(selection);

        if (isCafe){
            for (int i = 0; i < votingSystem.getKolkoCafes(); i++) {
                if (votingSystem.hasVoted(votingSystem.getAkyUser(), i,isCafe)) {
                    ciUrobil.setText("you have already voted ");
                }
                if (votingSystem.getCafe(i).getNameCafe().equals(selection)) {
                    if (!(votingSystem.hasVoted(votingSystem.getAkyUser(), i,isCafe))) {
                        ciUrobil.setText("evaluation accepted ");
                    }
                    float result = votingSystem.hodnoteRest(hodnota, votingSystem.getAkyUser(), i,isCafe);
                    votingSystem.getCafe(i).setHodnotaRew(result);
                    hodnotaRest.setText("hodnota jeho je: " + votingSystem.getCafe(i).getHodnotaRew());

                }


            }
        }else {
            for (int i = 0; i < votingSystem.getKolkoRest(); i++) {
                if (votingSystem.hasVoted(votingSystem.getAkyUser(), i,isCafe)) {
                    ciUrobil.setText("you have already voted ");
                }
                if (votingSystem.getRestaurant(i).getNameRestaurant().equals(selection)) {
                    if (!(votingSystem.hasVoted(votingSystem.getAkyUser(), i,isCafe))) {
                        ciUrobil.setText("evaluation accepted ");
                    }
                    float result = votingSystem.hodnoteRest(hodnota, votingSystem.getAkyUser(), i,isCafe);
                    votingSystem.getRestaurant(i).setHodnotaRew(result);
                    hodnotaRest.setText("hodnota jeho je: " + votingSystem.getRestaurant(i).getHodnotaRew());

//                votingSystem.getRestaurant(i).setHodnota(result);
//                hodnotaRest.setText("hodnota jeho je: "+votingSystem.getRestaurant(i).getHodnota());

                }


            }
        }

    }
}