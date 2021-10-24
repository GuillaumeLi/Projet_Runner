import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

abstract public class AnimatedThing {
    private double x;
    private double y;
    private ImageView sprite;
    private int attitude;

    private int index;
    private double duration;
    private int maxIndex;
    private double windowSize;
    private double frameOffset;

    public AnimatedThing(String filename, double time){
        Image tmpImage = new Image(filename);
        sprite = new ImageView(tmpImage);
        //sprite.setViewport(new Rectangle2D(index));
    }

    public ImageView getSprite() {
        return sprite;
    }
}
