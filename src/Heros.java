import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Heros extends AnimatedThing{
    private int posX;
    private int posY;
    private Image spriteSheet;
    private ImageView sprite;

    public Heros(int x, int y,String file) {
        super(file,x,y,75,100,20,15,5,75);
/*        posX = x;
        posY = y;
        spriteSheet = new Image(file);
        sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(20,15,60,80));
        sprite.setX(posX);
        sprite.setY(posY);*/
    }

    /*public ImageView getSprite(){
        return sprite;
    }*/

}
