package lk.ijse.dep12.task4.media_player.controller;

import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainViewController {


    public AnchorPane root;
    double mousePointX;
    double mousePointY;

    public void rootOnMousePressed(MouseEvent mouseEvent) {
        mousePointX = mouseEvent.getX();
        mousePointY = mouseEvent.getY();
    }
    public void rootOnMouseDragged(MouseEvent mouseEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setX(mouseEvent.getSceneX()-mousePointX);
        stage.setY(mouseEvent.getSceneY()-mousePointY);
        //root.setLayoutX(mouseEvent.getSceneX()-mousePointX);
        //root.setLayoutY(mouseEvent.getSceneY()-mousePointY);
    }


    public void btnExitOnAction(ActionEvent actionEvent) {

        ((Stage)root.getScene().getWindow()).close();
    }
}
