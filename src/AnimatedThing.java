import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

abstract public class AnimatedThing {
    private double xPos;
    private double yPos;

    private double xAcceleration;
    private double yAcceleration;
    private double xVelocity = 2;
    private double yVelocity = 2;

    private double yForce = 10;

    private final double gravity=10;
    private final double friction=3;
    private final double mass=60;

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
        attitude = 2;
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

    public double getXPos() {
        return xPos;
    }

    public ImageView getSprite() {
        return sprite;
    }

    public void update(double time) {
        index = (int)((time%(maxIndex*duration))/duration);
        //System.out.println(index);
        //System.out.println(time);
        sprite.setViewport(new Rectangle2D(initialX+(index*frameOffset),initialY,spriteWidth,spriteHeight));
        //System.out.println(attitude);

        switch (attitude) {
            case 1 : //Hero is still
                sprite.setX(xPos);
                break;
            case 2 : //Hero is running
                xPos = xPos + 2;
                sprite.setX(xPos);
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
                    sprite.setY(yPos);
                    sprite.setX(xPos);
                    sprite.setViewport(new Rectangle2D(0,160,spriteWidth,spriteHeight));
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
                    sprite.setY(yPos);
                    sprite.setX(xPos);
                    sprite.setViewport(new Rectangle2D(frameOffset,160,spriteWidth,spriteHeight));
                }
                else {
                    attitude = 2;
                }
                break;
        }

    }

    public double getxVelocity(){
        return xVelocity;
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

}
