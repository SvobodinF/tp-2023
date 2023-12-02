package Models;
import java.util.LinkedList;

public class Route implements Datable {
    private LinkedList<Station> stations;
    private String name;
    private Train train;
    private int id;
    public Route(String name, LinkedList<Station> stations, Train train, int id) {
        this.name = name;
        this.stations = stations;
        this.train = train;
        this.id = id;
    }

    public Station getDeparture() {
        return stations.getFirst();
    }

    public Station getArrive(){
        return stations.getLast();
    }

    @Override
    public long getId() {
        return id;
    }
}
