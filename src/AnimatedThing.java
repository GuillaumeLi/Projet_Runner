import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

abstract public class AnimatedThing {

    private Image spriteSheet;
    private ImageView sprite;

    private int spriteHeight;
    private int spriteWidth;
    private int initialX;
    private int initialY;

    private int index;
    private int maxIndex;
    private int frameOffset;
    private double duration;

    public AnimatedThing(String filename, int width, int height, int initialX, int initialY, int maxIndex, int frameOffset, double duration){
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

    public ImageView getSprite() {
        return sprite;
    }

}
