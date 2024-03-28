package gui;


import UserPack.VotingSystem;
import gui.Controlers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

//public class GuiForProgram extends Application{
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(GuiForProgram.class.getResource("View/login.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
//        Parent loginController = fxmlLoader.getController();
//        stage.setTitle("Voting");
//        stage.setScene(scene);
//        stage.show();
//    }
//    public static void main(String[] args) {
//       launch();
//    }
//}

public class GuiForProgram extends Application {
    private VotingSystem votingSystem; // Додайте поле для об'єкту VotingSystem

    @Override
    public void start(Stage stage) throws IOException {
        // Створіть об'єкт VotingSystem
        votingSystem = new VotingSystem();

        // Завантажте FXML і передайте об'єкт VotingSystem кожному контролеру
        FXMLLoader fxmlLoader = new FXMLLoader(GuiForProgram.class.getResource("View/login.fxml"));
        Parent root = fxmlLoader.load();

        conForLogin loginController = fxmlLoader.getController(); // Отримайте контролер
        loginController.setVotingSystem(votingSystem); // Передайте об'єкт VotingSystem
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
