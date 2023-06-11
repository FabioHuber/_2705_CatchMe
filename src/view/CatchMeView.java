package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CatchMeView {
    private Label pointsLabel;
    private Label timeLabel;
    private FlowPane buttons;
    private VBox root;

    private Scene mainScene;

    private Button[] buttonsArray;

    private HBox topBar;

    private Button startStopButton;

    public CatchMeView() {
        startStopButton = new Button("Start");
        pointsLabel = new Label("Points: 0");
        timeLabel = new Label("Press Start to start the game!");

        createMainScene();
    }

    private void createMainScene() {
        buttons = new FlowPane();
        topBar = new HBox();

        topBar.setSpacing(10);
        topBar.setPrefHeight(50);;

        topBar.getChildren().addAll(pointsLabel, timeLabel);

        root = new VBox();
        root.getChildren().addAll(topBar, buttons, startStopButton);

        buttons.setAlignment(Pos.CENTER);
        topBar.setAlignment(Pos.CENTER);
        root.setAlignment(Pos.TOP_CENTER);

        startStopButton.setPrefSize(90, 40);

        root.setSpacing(15);

        mainScene = new Scene(root, 500, 500);
    }

    public void addButtons(int amount) {
        buttonsArray = new Button[amount];
        for (int i = 0; i < amount; i++) {
            buttonsArray[i] = new Button();
            buttons.getChildren().add(buttonsArray[i]);
            buttonsArray[i].setPrefSize(100, 100);
        }
    }

    public Label getPointsLabel() {
        return pointsLabel;
    }

    public Label getTimeLabel() {
        return timeLabel;
    }

    public Button getStartStopButton() {
        return startStopButton;
    }

    public Button[] getButtonsArray() {
        return buttonsArray;
    }

    public Scene getMainScene() {
        return mainScene;
    }
}
