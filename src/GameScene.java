import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;

public class GameScene extends Scene {
    private Camera cam;
    private StaticThing leftBackground;
    private StaticThing rightBackground;
    private StaticThing heart;
    private Heros hero;
    private int numberOfLives;

    public GameScene(Group root) {
        super(root);
        cam = new Camera(1000,0);
        leftBackground = new StaticThing(800,400, "desert.png");
        rightBackground = new StaticThing(800,400, "desert.png");
        heart = new StaticThing(50,50,"heart.png");
        hero = new Heros(300,300,"heros.png");
        root.getChildren().add(rightBackground.getSprite());
        root.getChildren().add(leftBackground.getSprite());
        root.getChildren().add(heart.getSprite());
        root.getChildren().add(hero.getSprite());

        numberOfLives = 3;

        render();
    }

    public void render() {
        double offset = cam.getPosX()%leftBackground.getWidth();
        leftBackground.getSprite().setViewport(new Rectangle2D(offset,0, leftBackground.getHeight()-offset, leftBackground.getWidth()));
        rightBackground.getSprite().setViewport(new Rectangle2D(0,offset, rightBackground.getHeight()-offset, leftBackground.getWidth()));
        heart.getSprite().setViewport(new Rectangle2D(0,0,heart.getHeight(), heart.getWidth()));
    }


}