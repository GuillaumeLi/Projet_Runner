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
    private int maxIndex;
    private int frameOffset;
    private double duration;
    private double windowSize;

    public AnimatedThing(String filename, double x, double y, int width, int height, int initialX, int initialY, int maxIndex, int frameOffset, double duration){
        xPos = x;
        yPos = y;
        attitude = 1;
        spriteHeight = height;
        spriteWidth = width;
        this.maxIndex = maxIndex;
        this.initialX = initialX;
        this.initialY = initialY;
        this.frameOffset = frameOffset;
        this.duration = duration;
        spriteSheet = new Image(filename);
        sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(this.initialX,this.initialY,spriteWidth,spriteHeight));
        sprite.setX(xPos);
        sprite.setY(yPos);
    }

    public ImageView getSprite() {
        return sprite;
    }

    public void update(double time) {
        index = (int)((time%(maxIndex*duration))/duration);
        //System.out.println(index);
        //System.out.println(time);
        sprite.setViewport(new Rectangle2D(initialX+(index*frameOffset),initialY,spriteWidth,spriteHeight));
        xPos = xPos + 2;
        sprite.setX(xPos);
    }

    public double getXPos() {
        return xPos;
    }
}
