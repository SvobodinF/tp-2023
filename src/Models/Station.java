package Models;
import Utils.Coordinates;
import Utils.Time;

public class Station {
    private Coordinates coordinates;
    private Time waitTime;
    private Time arriveTime;

    private long id;

    public Station(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.waitTime = new Time(0,10);
    }

    public Station(Coordinates coordinates, Time waitTime) {
        this.coordinates = coordinates;
        this.waitTime = waitTime;
    }

    public Station(Coordinates coordinates, Time arriveTime, Time waitTime) {
        this.arriveTime = arriveTime;
        this.coordinates = coordinates;
        this.waitTime = waitTime;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setArriveTime(Time time, long id){
        arriveTime = time;
        this.id = id;
    }

    public Time getArriveTime(){
        return arriveTime;
    }

    public Time getDepartureTime(){
        return Time.getTime(new Time(arriveTime.getHours(), arriveTime.getMinutes()),
                new Time(waitTime.getHours(), waitTime.getMinutes()));
    }

    @Override
    public String toString() {
        return "Станция " + "(" + "id: " + id + "): \n" +
                coordinates +
                ", время отправления: " + getDepartureTime() +
                ", время прибытия: " + arriveTime;
    }
}
