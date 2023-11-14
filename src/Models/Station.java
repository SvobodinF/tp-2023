package Models;
import Utils.Coordinates;
import Utils.Time;

public class Station {
    private Coordinates coordinates;
    private Time departureTime;
    private Time arriveTime;

    public Station(Coordinates coordinates, Time departureTime, Time arriveTime) {
        this.coordinates = coordinates;
        this.departureTime = departureTime;
        this.arriveTime = arriveTime;
    }
}
