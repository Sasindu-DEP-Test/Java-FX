package lk.ijse.dep12.task3.pos_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {
    public Label lblUser;
    public AnchorPane root;

    public void initialize(){
        lblUser.setText(LoginViewController.UserName);
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"))));
        ((Stage)root.getScene().getWindow()).close();
        stage.show();
        stage.centerOnScreen();
    }
}
