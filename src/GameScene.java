import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.Random;

public class GameScene extends Scene {
    private Camera camera;
    private StaticThing leftBackground;
    private StaticThing rightBackground;
    //private StaticThing heart;
    private Heros hero;
    private int numberOfLives;

    private StaticThing [] heart;
    private Foe [] enemyList;
    private ArrayList<Foe> foeList = new ArrayList<>();
    private Foe foetest;

    private boolean noCollision = true;

    private static final int HEART_OFFSET = 20;
    private static final int MAX_ENEMIES = 20;
    private static final int MIN_ENEMIES = 15;
    private static final int ENEMY_DISTANCE = 800;

    public GameScene(Group root) {
        super(root,800,400);
        leftBackground = new StaticThing(400,800, "./Image/desert.png");
        rightBackground = new StaticThing(400,800, "./Image/desert.png");
        //heart = new StaticThing(50,50,"./Image/heart.png");
        hero = new Heros(30,250,"./Image/heros.png");
        camera = new Camera(800,0,hero);
        numberOfLives = 2;

        Random random = new Random();
        int enemyNumber = MIN_ENEMIES + random.nextInt(MAX_ENEMIES-MIN_ENEMIES);
        System.out.println("number : "+enemyNumber);
        enemyList = new Foe[enemyNumber];

        for(int i=0;i<enemyNumber;i++){
            enemyList[i] = new Foe(hero.getXPos()+(i*ENEMY_DISTANCE),300,"./Image/ennemy_walk.png",camera);
        }
        foetest = new Foe(hero.getXPos()+800,300,"./Image/ennemy_walk.png", camera);
        foeList.add(foetest);

        root.getChildren().add(rightBackground.getSprite());
        root.getChildren().add(leftBackground.getSprite());
        //root.getChildren().add(heart.getSprite());
        root.getChildren().add(hero.getSprite());
        root.getChildren().add(foetest.getSprite());

        this.setOnMouseClicked((event)-> {
            System.out.println("Jump");
            hero.jump();
        });

        render();
        timer.start();
    }

    public void render() {
        double offset = camera.getPosX()%leftBackground.getWidth();
        leftBackground.getSprite().setViewport(new Rectangle2D(offset,0, leftBackground.getWidth(), leftBackground.getHeight()));
        rightBackground.getSprite().setViewport(new Rectangle2D(0,0, rightBackground.getWidth(),rightBackground.getHeight()));
        rightBackground.getSprite().setX(rightBackground.getWidth()-offset);
        /*
        for(int i=0; i<numberOfLives; i++) {
            StaticThing heart = new StaticThing(50,50,"./Image/heart.png");
            heart.getSprite().setViewport(new Rectangle2D(0,0,heart.getHeight(), heart.getWidth()));
        }
         */
    }

    final long startNanoTime = System.nanoTime();
    AnimationTimer timer = new AnimationTimer() {
        public void handle(long time) {
            double t = Math.abs((startNanoTime - time)/1000000000.0);
            hero.update(t);
            camera.update(t);
            render();
            foetest.update(t);

            //System.out.println("hero x : "+hero.getXPos());
            //System.out.println("foe x : "+foetest.getXPos());
            System.out.println(noCollision);

            if(hero.isInvincible(2)){
                System.out.println("invincible");
            }
            else {
                for (Foe foe : foeList) {
                    if(hero.intersect(foe)) {
                        if (noCollision) {
                            System.out.println("collision                                 collision");
                            numberOfLives--;
                            noCollision = false;
                        }
                    }
                    else {
                        noCollision = true;
                    }
                }
            }
        }
    };

}