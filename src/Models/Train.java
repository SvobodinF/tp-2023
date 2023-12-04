package Models;

public class Train {
    private int number;
    private float speed;
    public Train(int number, float speed){
        this.number = number;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Поезд: \n" +
                "Номер поезда: " + number +
                "\nСкорость: " + speed + "км/ч\n";
    }

    public float getSpeed() {
        return speed;
    }
}
