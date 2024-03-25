package lk.ijse.dep12.task3.pos_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewController {
    public TextField txtUserName;
    public static String UserName;


    public TextField txtPassword;
    public AnchorPane root;

    public void initialize(){
        UserName=txtUserName.getText();
    }
    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {


        if(txtUserName.getText().equals("admin") && txtPassword.getText().equals("admin")){
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/MainView.fxml")));
            Stage stage = new Stage();
            stage.setScene(scene);
            ((Stage)root.getScene().getWindow()).close();
            stage.show();
            stage.centerOnScreen();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Failed");
            alert.setContentText("Username or Password is incorrect. Try Again");
            alert.showAndWait();
        }
    }
}
