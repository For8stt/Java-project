package gui.Controlers;


import UserPack.VotingSystem;
import gui.GuiForProgram;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class conForLogin extends GuiForProgram  {


    @FXML
    TextField nameTextField;
    @FXML
    TextField passwordTextField;
    @FXML
    Label LabelError;

    @FXML
    RadioButton rButton;
    @FXML
    Label rReg;
    @FXML
    Button butReg;
    @FXML
    Button loginButton;
    @FXML
    RadioButton rExpert;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private VotingSystem votingSystem;
    private  boolean expert;



    public void setVotingSystem(VotingSystem votingSystem) {
        this.votingSystem = votingSystem;
    }
    public void SetUnvisiable(){
        butReg.setVisible(false);
        rExpert.setVisible(false);
    }
    public void radioExpert(ActionEvent event){
        if (rExpert.isSelected()){
            expert =true;
        }else {
            expert=false;
        }
    }
    public void radioRegister(ActionEvent event){
        if (rButton.isSelected()){
            rReg.setText("Registration");
            loginButton.setVisible(false); // Робимо кнопку логіну невидимою
            butReg.setVisible(true);
            rExpert.setVisible(true);
        }else {
            rReg.setText("");
            loginButton.setVisible(true); // Робимо кнопку логіну видимою
            butReg.setVisible(false);
            rExpert.setVisible(false);
        }
        LabelError.setText("");
    }
    public void registretion(ActionEvent event)throws IOException{
        try {
            String username = nameTextField.getText();
            String password = passwordTextField.getText();
            if (username.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException("riadok je empty");
            }
            boolean ciJeUser = votingSystem.registrationCrtUsr(username, password, expert);
            if (ciJeUser) {
                LabelError.setText("you are registrated");
            } else {
                LabelError.setText("This username already exists");
            }
            nameTextField.clear();
            passwordTextField.clear();
            rExpert.setSelected(false);
        }catch (IllegalArgumentException ex){
            Alert a = new Alert(Alert.AlertType.ERROR);
            System.out.println(ex.getMessage());
            a.setTitle("Error");
            a.setContentText("All fields must have values.");
            a.showAndWait();
        }
    }

    public void login(ActionEvent event) throws IOException {

        String username=nameTextField.getText();
        String password=passwordTextField.getText();


//        VotingSystem vote=new VotingSystem();
//        vote.creatingObjects();
        if (votingSystem.loginCheckHost(username,password)){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/View/votingPlace1.fxml"));
            root=loader.load();




            conForVotingPlace conforVotingplace=loader.getController();
            conforVotingplace.setVotingSystem(votingSystem);
            conforVotingplace.setUnvisidbleHost();


            conforVotingplace.displayNamePassword(username,password,votingSystem.getHost().getRol());


            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene= new Scene(root);
            stage.setScene(scene);
            stage.show();

        }else if (votingSystem.loginCheck(username,password)){
//        FXMLLoader loader = new FXMLLoader(conForLogin.class.getResource("view/votingPlace1.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/View/votingPlace1.fxml"));
        root=loader.load();




        conForVotingPlace conforVotingplace=loader.getController();
        conforVotingplace.setVotingSystem(votingSystem);
        conforVotingplace.setUnvisidbleVoter();


        conforVotingplace.displayNamePassword(username,password,votingSystem.voterJe().getRol());


        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

        } else {
            nameTextField.clear();
            passwordTextField.clear();
            LabelError.setText("Incorrect username or password");

            System.out.println("Incorrect username or password");
        }
    }

}
