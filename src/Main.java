import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application{

    public void start(Stage primaryStage){
        primaryStage.setTitle("Demo");
        Group root = new Group();
        Group welcome = new Group();

        Scene welcomeScene = new Scene(welcome,800,400);


        //first scene to start the game
        Button start = new Button("Start");
        welcome.getChildren().add(start);

        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GameScene gs = new GameScene(root);
                primaryStage.setScene(gs);
            }
        });

        primaryStage.setScene(welcomeScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        // write your code here
    }
}