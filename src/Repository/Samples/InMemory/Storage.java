package Repository.Samples.InMemory;

import Models.Datable;
import Models.Route;
import Models.Station;
import Models.Train;
import Utils.Coordinates;
import Utils.Time;

import javax.xml.crypto.Data;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class Storage<T extends Datable> {
    private Set<T> items;

    public Set<T> getItems(){
        return items;
    }
    public Storage() {
        items = new HashSet<>();
    }

    public void add(T obj){
        items.add(obj);
    }

    public void remove(T obj){
        items.remove(obj);
    }
}
