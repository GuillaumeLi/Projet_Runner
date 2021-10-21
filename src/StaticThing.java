import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {
    private double height;
    private double width;

    private ImageView sprite;

    public StaticThing (double height, double width, String filename) {
        this.height = height;
        this.width = width;
        Image tmpImage = new Image(filename);
        sprite = new ImageView(tmpImage);
    }

    public ImageView getSprite() {
        return sprite;
    }

    public double getWidth() { return width; }

    public double getHeight() {
        return height;
    }
}
