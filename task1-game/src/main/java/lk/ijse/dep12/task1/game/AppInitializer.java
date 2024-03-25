package lk.ijse.dep12.task1.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {


        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/MainView.fxml")));
        primaryStage.setScene(scene);
        primaryStage.setTitle("Jump and Win Game");
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.centerOnScreen();

    }
}
