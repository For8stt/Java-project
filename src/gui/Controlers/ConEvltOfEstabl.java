package gui.Controlers;

import UserPack.Strategy.calculateMidleVoiceCafe;
import UserPack.Strategy.calculateMidleVoiceRest;
import UserPack.VotingSystem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for the establishment evaluation view.
 */
public class ConEvltOfEstabl implements Initializable {
    private Parent root;
    @FXML
    private ChoiceBox<String> restauraciaJe;
    @FXML
    private Label SelectRest;
    @FXML
    private TextField hodnotaRest;
    @FXML
    private TextField middleVoiceRest;
    @FXML
    private TextField middleVoiceCafe;
    @FXML
    private Label ciUrobil;
    @FXML
    private BorderPane evaluationBP;

    @FXML
    private Spinner<Integer> mySpinner;
    @FXML
    private Label myLabel;
    @FXML
    private TextArea middleVoiceAll;



    int currentValue;
    private VotingSystem votingSystem;
    /**
     * Sets the VotingSystem instance.
     * @param votingSystem The VotingSystem instance
     */
    public void setVotingSystem(VotingSystem votingSystem) {
        this.votingSystem = votingSystem;
    }
    /**
     * Sets the text in the TextArea for displaying middle voices for both restaurants and cafes.
     * @param text1 Text for restaurants
     * @param text2 Text for cafes
     */
    public void setTextmiddleVoiceAll(String text1, String text2){
        middleVoiceAll.setText("Rest: "+text1+"\n"+"Cafe: "+text2);
        middleVoiceAll.setEditable(false);
    }
    /**
     * Switches to the voting place view.
     * @param event The ActionEvent triggering the method
     * @throws IOException If an error occurs during loading the FXML file
     */
public void switchToVotingPlace(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/View/votingPlace1.fxml"));
     root = loader.load();

    conForVotingPlace votingPlace1Controller = loader.getController();
    votingPlace1Controller.setVotingSystem(votingSystem);

    votingPlace1Controller.akyUserJe(votingSystem.getAkyUser());
    votingPlace1Controller.setUnvisidbleVoter();

    evaluationBP.setCenter(root);
}
    /**
     * Initializes the Spinner and sets its value factory.
     * @param url The location used to resolve relative paths for the root object
     * @param resourceBundle The resources used to localize the root object
     */

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


    /**
     * Sets the items in the ChoiceBox.
     * @throws IOException If an error occurs during the process
     */
    public void setChoiseBox()throws IOException{
        for (int i=0;i<votingSystem.getKolkoRest();i++){
            restauraciaJe.getItems().add(votingSystem.getRestaurant(i).getNameRestaurant());
        }
        for (int i=0;i<votingSystem.getKolkoCafes();i++){
            restauraciaJe.getItems().add(votingSystem.getCafe(i).getNameCafe());
        }

        restauraciaJe.setOnAction(this::getRestName);
    }
    /**
     * Gets the name of the selected restaurant/cafe.
     * @param event The ActionEvent triggering the method
     */
    public void getRestName(ActionEvent event){
        String nameRest=restauraciaJe.getValue();
        SelectRest.setText(nameRest);
    }
    /**
     * Shows the rating of the selected restaurant/cafe.
     * @param event The ActionEvent triggering the method
     * @throws IOException If an error occurs during the process
     */
    public void showHodnota(ActionEvent event)throws IOException{
        String selection = restauraciaJe.getValue();
        for (int i=0;i<votingSystem.getKolkoRest();i++) {
            if (votingSystem.getRestaurant(i).getNameRestaurant().equals(selection)) {
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
    /**
     * Sets a new rating for the selected restaurant/cafe.
     * @param event The ActionEvent triggering the method
     * @throws IOException If an error occurs during the process
     */
    public void newHodnota(ActionEvent event)throws IOException{
        try {
            int hodnota = mySpinner.getValue();
            String selection = restauraciaJe.getValue();
            if (selection == null || selection.isEmpty()) {
                throw new IllegalArgumentException("riadok je prazdny");
            }


            boolean isCafe = votingSystem.isCafe(selection);



            if (isCafe) {
                for (int i = 0; i < votingSystem.getKolkoCafes(); i++) {
                    if (votingSystem.hasVoted(votingSystem.getAkyUser(), i, isCafe)) {
                        ciUrobil.setText("you have already voted ");
                    }
                    if (votingSystem.getCafe(i).getNameCafe().equals(selection)) {
                        if (!(votingSystem.hasVoted(votingSystem.getAkyUser(), i, isCafe))) {
                            ciUrobil.setText("evaluation accepted ");
                        }
                        float result = votingSystem.hodnoteRest(hodnota, votingSystem.getAkyUser(), i, isCafe);
                        votingSystem.getCafe(i).setHodnotaRew(result);
                        hodnotaRest.setText("hodnota jeho je: " + votingSystem.getCafe(i).getHodnotaRew());

                    }


                }
            } else {
                for (int i = 0; i < votingSystem.getKolkoRest(); i++) {
                    if (votingSystem.hasVoted(votingSystem.getAkyUser(), i, isCafe)) {
                        ciUrobil.setText("you have already voted ");
                    }
                    if (votingSystem.getRestaurant(i).getNameRestaurant().equals(selection)) {
                        if (!(votingSystem.hasVoted(votingSystem.getAkyUser(), i, isCafe))) {
                            ciUrobil.setText("evaluation accepted ");
                        }
                        float result = votingSystem.hodnoteRest(hodnota, votingSystem.getAkyUser(), i, isCafe);
                        votingSystem.getRestaurant(i).setHodnotaRew(result);
                        hodnotaRest.setText("hodnota jeho je: " + votingSystem.getRestaurant(i).getHodnotaRew());

                    }


                }
            }
            if (isCafe){
                votingSystem.setcalculatVoice(new calculateMidleVoiceCafe(),votingSystem.getAkyUser());
//                middleVoiceCafe.setText("your middle voice: "+ votingSystem.getVoter(votingSystem.getAkyUser()).getMiddleVoiceCafe());
                middleVoiceCafe.setText("your middle voice: "+ votingSystem.getVoter(votingSystem.getAkyUser()).getMiddleVoiceAgr().getMiddleVoiceCafe());

            }else {
                votingSystem.setcalculatVoice(new calculateMidleVoiceRest(),votingSystem.getAkyUser());

                middleVoiceRest.setText("your middle voice: "+ votingSystem.getVoter(votingSystem.getAkyUser()).getMiddleVoiceAgr().getMiddleVoiceRest());
//                middleVoiceRest.setText("your middle voice: "+ votingSystem.getVoter(votingSystem.getAkyUser()).getMiddleVoiceRest());
            }
        }catch (IllegalArgumentException ex){
            Alert a = new Alert(Alert.AlertType.ERROR);
            System.out.println(ex.getMessage());
            a.setTitle("Error");
            a.setContentText("You have to choose a restaurant.");
            a.showAndWait();
        }

    }
}