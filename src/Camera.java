public class Camera {
    private double posX;
    private double posY;
    private Heros hero;

    private double acceleration;
    private double velocity;

    private double friction = 100;
    final private double mass = 50;
    final private double k = 50;

    public Camera(double x, double y, Heros hero) {
        posX = x;
        posY = y;
        this.hero = hero;
    }

    public double getPosX(){
        return posX;
    }

    public void update(double time) {
        //acceleration = (k/mass)*(hero.getPosX()-posX)-((friction/mass)*velocity);
        acceleration = 0.15*(hero.getXPos()-posX)-0.4*velocity;
        velocity = velocity + acceleration * 0.16;
        posX = posX + velocity * 0.16;
        //System.out.println(posX);
        //posX = posX + time;
        //System.out.println(hero.getXPos());
    }

    @Override
    public String toString() {
        return "position x : "+posX+"\nposition y : "+posY;
    }

}
