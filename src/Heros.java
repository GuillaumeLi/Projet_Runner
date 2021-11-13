import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Heros extends AnimatedThing{
    //Hero's characteristics
    private double xPos;
    private double yPos;
    private double xVelocity;
    private double yVelocity;
    private double xAcceleration;
    private double yAcceleration;
    private static double X_FORCE = 10;
    private static double Y_FORCE = 5;
    private static final double MASS = 60;
    private int attitude;
    private boolean isGrounded;

    //World's characteristics
    private static final double GRAVITY = 3;
    private static final double FRICTION = 3;

    //Hero's sprites characteristics
    private static final int SPRITE_WIDTH = 85;
    private static final int SPRITE_HEIGHT = 100;
    private static final int FRAME_OFFSET = 85;
    private static final int MAX_INDEX = 6;
    private static final double DURATION = 0.2;
    private static final int INITIAL_X = 0;
    private static final int INITIAL_Y = 0;

    //Constructor
    public Heros(int x, int y,String file) {
        super(file,SPRITE_WIDTH,SPRITE_HEIGHT,INITIAL_X,INITIAL_Y,MAX_INDEX,FRAME_OFFSET,DURATION);
        xPos = x;
        yPos = y;
        attitude = 2;
        xVelocity = 2;
        yVelocity = 2;
        isGrounded = true;
    }

    @Override
    public void movementUpdate() {
        switch (attitude) {
            case 1 : //Hero is still
                this.getSprite().setX((int)xPos);
                this.getSprite().setY((int)yPos);
                break;
            case 2 : //Hero is running
                xPos = xPos + 2;
                this.getSprite().setX((int)xPos);
                this.getSprite().setY((int)yPos);
                break;
            case 3 : //Hero is jumping up
                if(yPos > 150){

                    xAcceleration = (X_FORCE - xVelocity / FRICTION) / MASS;
                    yAcceleration = (Y_FORCE + GRAVITY - yVelocity / FRICTION) / MASS;

                    xVelocity = yVelocity + xAcceleration;
                    yVelocity = yVelocity + yAcceleration;

                    xPos = xPos + xVelocity;
                    yPos = yPos - yVelocity;


                    //yAcceleration = (yForce + gravity - yVelocity) / mass;
                    //yAcceleration = (yForce + gravity - yVelocity / friction) / mass;
                    //yVelocity = yVelocity + yAcceleration;

                    //yPos = yPos - yVelocity;
                    //yVelocity = yVelocity - ((mass*yVelocity/friction)+gravity);

                    System.out.println("acceleration y :"+yAcceleration);
                    System.out.println("velocity y :"+yVelocity);
                    System.out.println("position y : "+yPos);

                    //xPos = xPos + xVelocity;
                    //xVelocity = xVelocity - (friction*xVelocity/mass);
                    //yPos = yPos - 5;
                    //xPos = xPos + 2;
                    this.getSprite().setY((int)yPos);
                    this.getSprite().setX((int)xPos);
                    this.getSprite().setViewport(new Rectangle2D(0,160,SPRITE_WIDTH,SPRITE_HEIGHT));
                }
                else {
                    yVelocity = 2;
                    attitude = 4;
                }
                break;
            case 4 : //Hero is jumping down
                if(yPos < 250){
                    //Update Hero's acceleration
                    xAcceleration = (X_FORCE - xVelocity / FRICTION) / MASS;
                    yAcceleration = (Y_FORCE + GRAVITY - yVelocity / FRICTION) / MASS;
                    //Update Hero's velocity
                    xVelocity = yVelocity + xAcceleration;
                    yVelocity = yVelocity + yAcceleration;
                    //Update Hero's position
                    xPos = xPos + xVelocity;
                    yPos = yPos + yVelocity;

                    //yAcceleration = (yForce + gravity - yVelocity) / mass;
                    //yVelocity = yVelocity + yAcceleration;
                    //yPos = yPos + yVelocity;
                    //yVelocity = yVelocity - (mass*yVelocity/friction)+gravity;
                    //yPos = yPos + 5;
                    //xPos = xPos + xVelocity;
                    //xVelocity = xVelocity - (mass*xVelocity/friction);
                    //xPos = xPos + 2;
                    this.getSprite().setY((int)yPos);
                    this.getSprite().setX((int)xPos);
                    this.getSprite().setViewport(new Rectangle2D(FRAME_OFFSET,160,SPRITE_WIDTH,SPRITE_HEIGHT));
                }
                else {
                    yVelocity = 2;
                    attitude = 2;
                    isGrounded = true;
                }
                break;
        }
    }

    public void jump() {
        if(isGrounded == true){
            attitude = 3;
            isGrounded = false;
        }
    }

    public double getXPos() {
        return xPos;
    }

}
