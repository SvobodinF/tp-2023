package Models;
import Utils.Coordinates;
import Utils.Time;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class Route implements Datable {
    private List<Station> stations;
    private String name;
    private Train train;
    private long id;

    public Route(){
    }
    public Route(String name, Train train, long id) {
        stations = new ArrayList<>();

        this.name = name;
        this.train = train;
        this.id = id;
    }

    public void AddStation(Station station){
        if (station.getArriveTime() == null){
            station.setArriveTime(setArriveTime(stations.size() -1, station), stations.size());
        }

        stations.add(station);
    }

    public void AddStationByIndex(Station station, int index){
        for (int i = index; i < stations.size(); i++){
            stations.get(i).setArriveTime(setArriveTime(index -1, station), i);
        }

        stations.add(index, station);
    }

    private Time setArriveTime(int index, Station station){
        Station lastStation = stations.get(index);

        float distance = Coordinates.distance(lastStation.getCoordinates(), station.getCoordinates());
        float time = distance / train.getSpeed() * 60;

        return Time.getTime(lastStation.getDepartureTime(), Time.getTime(time));
    }

    public Station getDepartureStation() {
        if (stations.size() == 0)
            return null;

        return stations.get(0);
    }

    public Station getArriveStation(){
        if (stations.size() == 0)
            return null;

        return stations.get(stations.size() - 1);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void construct(Dictionary<String, Object> dictionary) {
        id = (long)dictionary.get("id");
        name = (String)dictionary.get("name");
        train = (Train) dictionary.get("train");
    }

    @Override
    public String getData() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Station station : stations) {
            stringBuilder.append(station).append(",\n");
        }

        return "Маршрут " + "(" + "id: " + id + "): "
                + name + "\n"
                + train +
                "Станции: \n" + stringBuilder;
    }

    public String getName() {
        return name;
    }

    public Train getTrain() {
        return train;
    }
}
