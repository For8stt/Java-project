package gui;


import UserPack.VotingSystem;
import gui.Controlers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class GuiForProgram extends Application {
    private VotingSystem votingSystem;

    @Override
    public void start(Stage stage) throws IOException {
        votingSystem = new VotingSystem();

        FXMLLoader fxmlLoader = new FXMLLoader(GuiForProgram.class.getResource("View/login.fxml"));
        Parent root = fxmlLoader.load();

        conForLogin loginController = fxmlLoader.getController();
        loginController.setVotingSystem(votingSystem);
        loginController.SetUnvisiable();



        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Voting");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
