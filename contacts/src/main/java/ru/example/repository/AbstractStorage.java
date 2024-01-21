package ru.example.repository;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public abstract class AbstractStorage<T> implements Storage<T> {

    private final CopyOnWriteArraySet<T> storage = new CopyOnWriteArraySet<>();

    @Override
    public void add(T value) {
        storage.add(value);
    }

    @Override
    public void addAll(List<T> values) {
        storage.addAll(values);
    }

    @Override
    public List<T> search(T value) {
        if (Objects.isNull(value)) {
            return null;
        }
        return storage.stream().filter(v -> v.equals(value)).collect(Collectors.toList());
    }

    @Override
    public List<T> searchBy(Predicate<T> predicate) {
        return storage.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public boolean contains(T value) {
        return storage.contains(value);
    }

    @Override
    public boolean remove(T value) {
        return storage.remove(value);
    }

    @Override
    public boolean removeIf(Predicate<T> predicate) {
        return storage.removeIf(predicate);
    }

    @Override
    public long getCount() {
        return storage.size();
    }

    @Override
    public List<T> findBy(Pagination pagination) {
        return storage.stream().skip(pagination.getOffset() * pagination.getCount()).collect(Collectors.toList());
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage);
    }
}
