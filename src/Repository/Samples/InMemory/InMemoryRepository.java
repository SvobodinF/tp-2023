package Repository.Samples.InMemory;

import Models.Datable;
import Repository.Repositoreble;
import java.util.List;
import java.util.Objects;

public class InMemoryRepository<T extends Datable> implements Repositoreble<T> {

    private final Storage<T> storage;

    public InMemoryRepository(Storage<T> storage) {
        this.storage = storage;
    }

    @Override
    public T get(Long id) {
        return storage.getItems().stream()
                .filter(b -> Objects.equals(b.getId(), id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<T> getAll() {
        return  storage.getItems().stream().toList();
    }

    @Override
    public void add(T obj) {
        storage.add(obj);
    }

    @Override
    public void remove(T obj) {
        storage.remove(obj);
    }

    @Override
    public void edit(T obj) {

    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }
}
