package gui;


import UserPack.VotingSystem;
import gui.Controlers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The main class responsible for starting the GUI application.
 */
public class GuiForProgram extends Application {
    private VotingSystem votingSystem;

    /**
     * The entry point for launching the JavaFX application.
     * @param stage The primary stage for the application
     * @throws IOException If an error occurs during loading the FXML file
     */
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
        stage.setResizable(false);
        stage.show();
    }

    /**
     * The main method responsible for launching the application.
     * @param args The command-line arguments
     */
    public static void main(String[] args) {
        launch();
    }
}
