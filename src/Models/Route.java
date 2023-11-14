package Models;
import java.util.LinkedList;

public class Route {
    private LinkedList<Station> stations;
    private String name;
    private Train train;
    public Route(String name, LinkedList<Station> stations, Train train) {
        this.name = name;
        this.stations = stations;
        this.train = train;
    }

    public Station getDeparture() {
        return stations.getFirst();
    }

    public Station getArrive(){
        return stations.getLast();
    }
}
