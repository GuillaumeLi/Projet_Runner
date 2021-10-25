import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

abstract public class AnimatedThing {
    private double xPos;
    private double yPos;
    private Image spriteSheet;
    private ImageView sprite;
    private int attitude;

    private int spriteHeight;
    private int spriteWidth;
    private int initialX;
    private int initialY;

    private int index;
    private double duration;
    private int maxIndex;
    private double windowSize;
    private int frameOffset;

    public AnimatedThing(String filename, double x, double y, int width, int height, int initialX, int initialY, int maxIndex, int frameOffset){
        xPos = x;
        yPos = y;
        spriteHeight = height;
        spriteWidth = width;
        this.maxIndex = maxIndex;
        this.initialX = initialX;
        this.initialY = initialY;
        this.frameOffset = frameOffset;
        spriteSheet = new Image(filename);
        sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(this.initialX,this.initialY,spriteWidth,spriteHeight));
        sprite.setX(xPos);
        sprite.setY(yPos);
    }

    public ImageView getSprite() {
        return sprite;
    }

    public int getIndex(double time) {
        return index = (int)((time%(maxIndex*duration))/duration);
    }

    public void update(double time) {
        sprite.setViewport(new Rectangle2D(initialX+(this.getIndex(time)*frameOffset),initialY,spriteWidth,spriteHeight));
    }
}
