package Models;

import java.util.Dictionary;

public interface Datable {
    long getId();
    void construct(Dictionary<String, Object> dictionary);
    String getData();
}
