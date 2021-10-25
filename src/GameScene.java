import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;

public class GameScene extends Scene {
    private Camera camera;
    private StaticThing leftBackground;
    private StaticThing rightBackground;
    private StaticThing heart;
    private Heros hero;
    private int numberOfLives;

    public GameScene(Group root) {
        super(root);
        camera = new Camera(1000,0);
        leftBackground = new StaticThing(800,400, "desert.png");
        rightBackground = new StaticThing(800,400, "desert.png");
        heart = new StaticThing(50,50,"heart.png");
        hero = new Heros(30,250,"heros.png");
        numberOfLives = 3;

        root.getChildren().add(rightBackground.getSprite());
        root.getChildren().add(leftBackground.getSprite());
        root.getChildren().add(heart.getSprite());
        root.getChildren().add(hero.getSprite());

        render();
        timer.start();
    }

    public void render() {
        double offset = camera.getPosX()%leftBackground.getWidth();
        leftBackground.getSprite().setViewport(new Rectangle2D(offset,0, leftBackground.getHeight()-offset, leftBackground.getWidth()));
        rightBackground.getSprite().setViewport(new Rectangle2D(0,offset, rightBackground.getHeight()-offset, leftBackground.getWidth()));
        heart.getSprite().setViewport(new Rectangle2D(0,0,heart.getHeight(), heart.getWidth()));
    }

    AnimationTimer timer = new AnimationTimer() {
        public void handle(long time) {
            //final long startNanoTime = System.nanoTime();
            //double t = (startNanoTime - time)/10000.0;
            double t = time / 800000000.0;
            hero.update(t);
            camera.update(time);
            //gameScene.update(time);
        }
    };

    public void update(double time) {

    }

}