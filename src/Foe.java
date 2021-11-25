public class Foe extends AnimatedThing {
    private Camera cam;

    public Foe(double x, double y, String file, Camera camera) {
        super(x, y, file,35,25,250,15,5,-60,0.2);
        cam = camera;
    }

    @Override
    public void movementUpdate(double time) {
        getSprite().setFitHeight(1.5*spriteHeight);
        getSprite().setFitWidth(1.5*spriteWidth);
        xPos = xPos - X_VELOCITY*time;
        getSprite().setX(xPos);
        //getSprite().setX(yPos);
    }
}
