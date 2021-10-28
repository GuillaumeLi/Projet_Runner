import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application{

    private static final Image SCENERY = new Image("desert.png",800,400,true,true);

    final private ImageView ImageViewSceneryLeft = new ImageView(SCENERY);

    public void start(Stage primaryStage){
        primaryStage.setTitle("Demo");
        Group root = new Group();
        Group root2 = new Group();
        Scene scene = new Scene(root, 600, 400);


        //Heros hero = new Heros(300,300,"heros.png");


        //root.getChildren().add(ImageViewSceneryLeft);
        //root.getChildren().add(hero.getSprite());

        //Camera cam = new Camera(50,100);
        GameScene gs = new GameScene(root2);

        primaryStage.setScene(gs);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
        // write your code here
    }
}