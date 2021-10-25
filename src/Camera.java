public class Camera {
    private double posX;
    private double posY;


    public Camera(double x, double y) {
        posX = x;
        posY = y;
    }

    public double getPosX(){
        return posX;
    }

    public double getPosY(){
        return posY;
    }

    public void update(double time) {

    }

    @Override
    public String toString() {
        return "position x : "+posX+"\nposition y : "+posY;
    }

}
