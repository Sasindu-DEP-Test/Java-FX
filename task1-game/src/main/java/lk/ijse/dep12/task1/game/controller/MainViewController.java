package lk.ijse.dep12.task1.game.controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    static long score = 0;
    public ImageView lblKiller;
    public static ImageView lblKillerStatic;
    public AnchorPane root;
    public static AnchorPane rootStatic;
    public ImageView lblAnimal;
    public Label lblScore;
    public static Label lblScoreStatic;

    public MainViewController() {
    }

    public void initialize() {

        lblKiller.setOpacity(0.7);

        lblScoreStatic = lblScore;
        lblKillerStatic = lblKiller;
        rootStatic = root;
        double animalInitialPoint = lblAnimal.getLayoutY();

        Platform.runLater(() -> {
            root.getScene().setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.RIGHT) {
                    if (lblKiller.getLayoutX() <= 0) {
                        lblKiller.setLayoutX(root.getPrefWidth());
                    }
                    lblKiller.setLayoutX(lblKiller.getLayoutX() - 5);
                }

                if (lblAnimal.getLayoutY() == animalInitialPoint && keyEvent.getCode() == KeyCode.SPACE) {

                    lblAnimal.setLayoutY(lblAnimal.getLayoutY() - 100);
                    System.out.println(lblKiller.getLayoutX());
                }

                /*System.out.println(lblKiller.getLayoutX() + ":" + lblKiller.getLayoutY());
                System.out.println(lblAnimal.getLayoutX() + ":" + lblAnimal.getLayoutY());
                System.out.println(lblAnimal.getLayoutX() + ":" + lblAnimal.getLayoutY());*/

                if (lblAnimal.getLayoutY() == lblKiller.getLayoutY() && (lblAnimal.getLayoutX() + 60 >= lblKiller.getLayoutX() && lblAnimal.getLayoutX() - 70 <= lblKiller.getLayoutX())) {
                    System.out.println("Game Over");
                    try {
                        onGameOver();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                } else if ((lblAnimal.getLayoutX() + 60 >= lblKiller.getLayoutX() && lblAnimal.getLayoutX() - 70 <= lblKiller.getLayoutX())) {
                    score++;
                    System.out.println("Score : " + score);
                    lblScore.setText(score + "");
                }
            });

            root.getScene().setOnKeyReleased(keyEvent -> {
                lblAnimal.setLayoutY(animalInitialPoint);
            });
        });
    }

    public void onGameOver() throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ApplicationModelWindow.fxml"))));
        stage.setTitle("Game Over");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        stage.centerOnScreen();
    }

    public static void PlayAgain() {
        score = 0;
        lblScoreStatic.setText("000");
        lblKillerStatic.setLayoutX(rootStatic.getPrefWidth() + 100);
    }

}
