import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

abstract public class AnimatedThing {
    //Object's position
    protected double xPos;
    protected double yPos;

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
    }

    public void update(double time) {
        index = (int)((time%(maxIndex*duration))/duration);
        sprite.setViewport(new Rectangle2D(initialX+(index*frameOffset),initialY,spriteWidth,spriteHeight));
        this.movementUpdate();
    }

    abstract public void movementUpdate();

    public Rectangle2D getHitBox() {
        return new Rectangle2D(xPos,yPos,spriteWidth,spriteHeight);
    }

    public boolean intersect (AnimatedThing object) {
        return object.getHitBox().intersects(this.getHitBox());
    }

    public ImageView getSprite() {
        return sprite;
    }

    public double getXPos() {
        return xPos;
    }

}
