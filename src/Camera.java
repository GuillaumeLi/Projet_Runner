public class Camera {
    //Camera characteristics
    private double posX;
    private double posY;
    private double acceleration;
    private double velocity;
    private double friction = 50;
    final private double mass = 50;
    final private double k = 100;

    private Heros hero;

    //Constructor
    public Camera(double x, double y, Heros hero) {
        posX = x;
        posY = y;
        this.hero = hero;
    }

    //Updating the camera's position on the scene
    public void update(double time) {
        //Spring's equation
        acceleration = (k/mass)*(hero.getXPos()-posX)-(friction/mass)*velocity;
        velocity = velocity + acceleration * 0.05;
        posX = posX + velocity * 0.05;

        //"center" the camera on the hero
        hero.getSprite().setX(hero.getSprite().getX()-posX+30);
    }

    //Getting the camera's x position
    public double getPosX(){
        return posX;
    }

    //Printing the camera's position
    @Override
    public String toString() {
        return "position x : "+posX+"\nposition y : "+posY;
    }

}
