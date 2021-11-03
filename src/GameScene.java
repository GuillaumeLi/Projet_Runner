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

    private double offset;

    public GameScene(Group root) {
        super(root,800,400);
        leftBackground = new StaticThing(400,800, "desert.png");
        rightBackground = new StaticThing(400,800, "desert.png");
        heart = new StaticThing(50,50,"heart.png");
        hero = new Heros(30,250,"heros.png");
        camera = new Camera(800,0,hero);
        numberOfLives = 3;

        root.getChildren().add(rightBackground.getSprite());
        root.getChildren().add(leftBackground.getSprite());
        root.getChildren().add(heart.getSprite());
        root.getChildren().add(hero.getSprite());

        render();
        timer.start();
    }

    public void render() {
        offset = camera.getPosX()%leftBackground.getWidth();
        if (offset<=0) {
            Math.abs(offset);
        }
        //leftBackground.getSprite().setViewport(new Rectangle2D(offset, 0,leftBackground.getWidth()-offset, leftBackground.getHeight()));
        //rightBackground.getSprite().setViewport(new Rectangle2D(rightBackground.getWidth()-offset,0, offset,rightBackground.getHeight()));
        leftBackground.getSprite().setViewport(new Rectangle2D(0,0, offset, leftBackground.getHeight()));
        rightBackground.getSprite().setViewport(new Rectangle2D(offset,0, rightBackground.getWidth()-offset,rightBackground.getHeight()));
        //rightBackground.getSprite().setX(rightBackground.getWidth()-offset);
        leftBackground.getSprite().setX(leftBackground.getWidth()-offset);
        heart.getSprite().setViewport(new Rectangle2D(0,0,heart.getHeight(), heart.getWidth()));
    }

    final long startNanoTime = System.nanoTime();
    AnimationTimer timer = new AnimationTimer() {
        public void handle(long time) {
            double t = Math.abs((startNanoTime - time)/1000000000.0);
            //double t = time / 800000000.0;
            hero.update(t);
            camera.update(t);
            render();
            //System.out.println(t);
            //System.out.println(startNanoTime);
            System.out.println(offset);
        }
    };

    public void update(double time) {

    }

}