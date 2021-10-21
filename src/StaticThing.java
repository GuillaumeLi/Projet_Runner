import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {
    private double posX;
    private double posY;

    private ImageView sprite;

    public StaticThing (double x, double y, String filename, double height, double width) {
        this.posX = x;
        this.posY = y;
        Image tmpImage = new Image(filename);
        ImageView sprite = new ImageView(tmpImage);
        sprite.setViewport(new Rectangle2D(x,y,height,width));
        sprite.setX(posX);
        sprite.setY(posY);
    }

    public ImageView getSprite() {
        return sprite;
    }

}
