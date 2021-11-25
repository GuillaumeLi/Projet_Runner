import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Heros extends AnimatedThing{
    //Hero's characteristics
    //private static final double X_VELOCITY = 0.5;
    private double yVelocity;
    private double yAcceleration = 40;
    private static final int X_FORCE = 2;
    private static final double MASS = 60;
    private int attitude;
    private boolean isGrounded;

    //Hero's power
    private double invincibility = 25000.0;
    private boolean invincible = false;
    private double invincibilityTime;

    //World's characteristics
    private static final double GRAVITY = 0.1;
    private static final double DELTA_TIME = 0.018;

    //Constructor
    public Heros(double x, double y,String file) {
        super(x,y,file,85,100,0,0,6,85,0.2);
        attitude = 2;
        isGrounded = true;
    }

    /**
     * Definition of every hero's attitude
     * Updating hero's position on the scene
     */
    @Override
    public void movementUpdate(double time) {

        //Substract time to invicibility, if it reaches negative value the hero can't lose live
        if(invincibility > 0) {
            invincibility = invincibility - time;
        }
        else {
            invincible = true;
        }

        switch (attitude) {
            case 1 : //Hero is still
                this.getSprite().setX((int)xPos);
                this.getSprite().setY((int)yPos);
                break;

            case 2 : //Hero is running and accelerate by the time
                //xPos = xPos + 10;
                xPos = xPos + X_VELOCITY * time;
                this.getSprite().setX((int)xPos);
                this.getSprite().setY((int)yPos);
                break;

            case 3 : //Hero is jumping

                //Updating hero's position values
                //xPos = xPos + 10 + X_FORCE;
                xPos = xPos + X_VELOCITY * time + X_FORCE;
                yVelocity = yVelocity + yAcceleration * GRAVITY;
                yPos = yVelocity * GRAVITY + yPos;

                //Updating hero's position on the game scene
                getSprite().setX((int)xPos);
                getSprite().setY((int)yPos);

                //Showing hero's jumps sprites
                if(yVelocity < 0){
                    this.getSprite().setViewport(new Rectangle2D(0,160,spriteWidth,spriteHeight));
                }
                else {
                    this.getSprite().setViewport(new Rectangle2D(frameOffset,160,spriteWidth,spriteHeight));
                }

                //When the jump is over hero is running
                if (yPos>250) {
                    yVelocity = 0;
                    yPos = 250;
                    isGrounded = true;
                    attitude = 2;
                }

                break;
        }
    }

    //This method makes the hero jump and if he's already jumping cannot jump
    public void jump() {
        if(isGrounded == true){
            attitude = 3;
            yVelocity = -100;
            isGrounded = false;
        }
    }

    //The hero is invincible and if there's collision don't lose live
    public boolean isInvincible(double duration) {

        if(invincibilityTime < 0){
            invincibilityTime = invincibilityTime - DELTA_TIME;
            System.out.println(invincibilityTime);
            if(duration > 0) {
                invincible = true;
            }
            else {
                invincible = false;
            }
        }
        return invincible;
    }

    public static double getxVelocity() {
        return X_VELOCITY;
    }
}
