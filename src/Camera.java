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

    public double getPosY(){
        return posY;
    }

    public void update(double time) {
        //double t = time / 1000000;
        acceleration = (k/mass)*(hero.getPosX()-posX)+(friction/mass)*velocity;
        velocity = Math.abs(acceleration * time);
        posX = velocity * time;
        //System.out.println(posX);
        System.out.println(posX);
    }

    @Override
    public String toString() {
        return "position x : "+posX+"\nposition y : "+posY;
    }

}
