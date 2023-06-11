package controller;

import model.CatchMeModel;
import view.CatchMeView;

public class CatchMeController {
    private CatchMeView view;
    private CatchMeModel model;

    public CatchMeController(CatchMeView view) {
        this.view = view;
        model = new CatchMeModel();

        createButtons(15);

        //Actions
        for (int i = 0; i < view.getButtonsArray().length; i++) {
            int finalI = i;
            view.getButtonsArray()[i].setOnAction(e -> {
                if(view.getButtonsArray()[finalI].getText() == "Catch Me!")
                    onButtonClicked(finalI);
                else {
                    model.setPoints(model.getPoints() - 10);
                    view.getPointsLabel().setText("Points: " + model.getPoints());
                }
            });
        }

        view.getStartStopButton().setOnAction(e -> {
            if(view.getStartStopButton().getText() == "Start"){
                view.getButtonsArray()[model.pickRandomButton()].setText("Catch Me!");
                view.getStartStopButton().setText("Stop");
            }else{
                for (int i = 0; i < view.getButtonsArray().length; i++) {
                    model.setPoints(0);
                    view.getPointsLabel().setText("Points: " + model.getPoints());
                    view.getButtonsArray()[i].setText(null);
                    view.getStartStopButton().setText("Start");
                    view.getTimeLabel().setText("Press Start to start the game!");
                }
            }
        });
    }

    private void createButtons(int amount) {
        view.addButtons(amount);
        model.addButtons(amount);
    }

    public void onButtonClicked(int i){
        if(model.getTime() <= 1.5)
            model.setPoints(model.getPoints()+10);
        else
            model.setPoints(model.getPoints()-5);

        view.getPointsLabel().setText("Points: " + model.getPoints());

        model.setAvgTime();
        view.getTimeLabel().setText(String.format("Last round: %.1f / Avg. Time: %.2f", model.getTime(), model.getAvgTime()));
        model.setTime(0);
        model.setStartTime();

        view.getButtonsArray()[i].setText(null);

        view.getButtonsArray()[model.pickRandomButton()].setText("Catch Me!");
    }
}
