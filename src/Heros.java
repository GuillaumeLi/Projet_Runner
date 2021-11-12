import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Heros extends AnimatedThing{
    //Hero's characteristics
    private int xPos;
    private int yPos;
    private int xVelocity;
    private int attitude;

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
    }

    @Override
    public void movementUpdate() {
        switch (attitude) {
            case 1 : //Hero is still
                this.getSprite().setX(xPos);
                this.getSprite().setY(yPos);
                break;
            case 2 : //Hero is running
                xPos = xPos + 2;
                this.getSprite().setX(xPos);
                this.getSprite().setY(yPos);
                break;
            case 3 : //Hero is jumping up
                if(yPos > 150){

                    //yAcceleration = (yForce + gravity - yVelocity) / mass;
                    //yAcceleration = (yForce + gravity - yVelocity / friction) / mass;
                    //yVelocity = yVelocity + yAcceleration;

                    //yPos = yPos - yVelocity;
                    //yVelocity = yVelocity - ((mass*yVelocity/friction)+gravity);

                    //System.out.println("velocity :"+yVelocity);
                    //System.out.println("acceleration :"+yAcceleration);
                    //System.out.println("position : "+yPos);

                    //xPos = xPos + xVelocity;
                    //xVelocity = xVelocity - (friction*xVelocity/mass);
                    yPos = yPos - 5;
                    xPos = xPos + 2;
                    this.getSprite().setY(yPos);
                    this.getSprite().setX(xPos);
                    this.getSprite().setViewport(new Rectangle2D(0,160,SPRITE_WIDTH,SPRITE_HEIGHT));
                }
                else {
                    attitude = 4;
                }
                break;
            case 4 : //Hero is jumping down
                if(yPos < 250){
                    //yAcceleration = (yForce + gravity - yVelocity) / mass;
                    //yVelocity = yVelocity + yAcceleration;
                    //yPos = yPos + yVelocity;
                    //yVelocity = yVelocity - (mass*yVelocity/friction)+gravity;
                    yPos = yPos + 5;
                    //xPos = xPos + xVelocity;
                    //xVelocity = xVelocity - (mass*xVelocity/friction);
                    xPos = xPos + 2;
                    this.getSprite().setY(yPos);
                    this.getSprite().setX(xPos);
                    this.getSprite().setViewport(new Rectangle2D(FRAME_OFFSET,160,SPRITE_WIDTH,SPRITE_HEIGHT));
                }
                else {
                    attitude = 2;
                }
                break;
        }
    }

    public void jump() {
        attitude = 3;
/*        accelerationX = (forceX - velocityX / friction) / mass;
        accelerationY = (forceY + gravity - velocityY / friction) / mass;

        velocityX = velocityX + accelerationX;
        velocityY = velocityY + accelerationY;

        positionX = positionX + velocityX;
        positionY = positionY + velocityY;*/
    }

    public double getXPos() {
        return xPos;
    }

}
