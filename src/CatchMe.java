import controller.CatchMeController;
import javafx.application.Application;
import javafx.stage.Stage;
import view.CatchMeView;

public class CatchMe extends Application {

    private CatchMeController controller;
    private CatchMeView view;

    public CatchMe() {
        view = new CatchMeView();
        controller = new CatchMeController(view);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(view.getMainScene());
        primaryStage.show();
    }

}