import javafx.scene.Group;
import javafx.scene.Scene;

public class GameScene extends Scene {
    private Camera cam;
    private StaticThing leftBackground;
    private StaticThing rightBackground;
    private int numberOfLives;

    public GameScene(Group root, int height, int width, Camera camera,String filename1, String filename2) {
        super(root, height, width);
        cam = camera;
        leftBackground = new StaticThing(cam.getPosX(), cam.getPosY(), filename1,50,50);
        rightBackground = new StaticThing(cam.getPosY(),cam.getPosX(),filename2,50,50);
        numberOfLives = 3;
    }
}