package lk.ijse.dep12.task1.game.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ApplicationModalWindowController{
    public Label lblScoreApplicationWindow;
    public AnchorPane root;


    public void initialize(){
        lblScoreApplicationWindow.setText(String.valueOf(MainViewController.score));
    }

    public void btnQuitOnAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void btnPlayAgainOnAction(ActionEvent actionEvent) {
        ((Stage)root.getScene().getWindow()).close();
        MainViewController.PlayAgain();
    }

}
