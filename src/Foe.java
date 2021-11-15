public class Foe extends AnimatedThing {

    public Foe(double x, double y, String file) {
        super(x, y, file,35,25,250,15,5,-60,0.2);
    }

    @Override
    public void movementUpdate() {
        getSprite().setFitHeight(2*spriteHeight);
        getSprite().setFitWidth(2*spriteWidth);
        getSprite().setX(250);
        getSprite().setY(300);
    }
}
