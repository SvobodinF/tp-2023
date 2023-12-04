package Utils;

public class Coordinates {
    private float x;
    private float y;

    public Coordinates(float x, float y){
        this.x = x;
        this.y = y;
    }

    public static float distance(Coordinates from, Coordinates to){
        return (float)Math.sqrt(Math.pow(to.x - from.x, 2) + Math.pow(to.y - from.y, 2));
    }

    @Override
    public String toString() {
        return "Координаты: (" + x + ";" + y + ")";
    }
}
