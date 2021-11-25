import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

abstract public class AnimatedThing {
    //Object's position
    protected double xPos;
    protected double yPos;
    protected static final double X_VELOCITY = 0.5;

    //Object's sprite
    private Image spriteSheet;
    private ImageView sprite;

    //Sprite's characteristics
    protected int spriteWidth;
    protected int spriteHeight;
    protected int frameOffset;
    private int index;
    protected int maxIndex;
    protected double duration;
    protected int initialX;
    protected int initialY;

    //Constructor
    public AnimatedThing(double xPos, double yPos, String filename, int width, int height, int initialX, int initialY, int maxIndex, int frameOffset, double duration){
        this.xPos = xPos;
        this.yPos = yPos;
        spriteHeight = height;
        spriteWidth = width;
        this.maxIndex = maxIndex;
        this.initialX = initialX;
        this.initialY = initialY;
        this.frameOffset = frameOffset;
        this.duration = duration;
        spriteSheet = new Image(filename);
        sprite = new ImageView(spriteSheet);
        sprite.setX(xPos);
        sprite.setY(yPos);
    }

    //Allows to update the game scene
    public void update(double time) {
        //Updating the hero's and foe's sprite
        index = (int)((time%(maxIndex*duration))/duration);
        sprite.setViewport(new Rectangle2D(initialX+(index*frameOffset),initialY,spriteWidth,spriteHeight));
        this.movementUpdate(time);
    }

    //Method for hero's and foe's movement
    abstract public void movementUpdate(double time);

    //Getting hero's and foe's hit box
    public Rectangle2D getHitBox() {
        return new Rectangle2D(xPos,yPos,spriteWidth,spriteHeight);
    }

    //Watch if they are colliding
    public boolean intersect (AnimatedThing object) {
        return object.getHitBox().intersects(this.getHitBox());
    }

    //Getting the current sprite
    public ImageView getSprite() {
        return sprite;
    }

    //Getting the x position
    public double getXPos() {
        return xPos;
    }

}
