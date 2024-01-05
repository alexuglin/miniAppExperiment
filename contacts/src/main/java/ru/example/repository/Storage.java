package ru.example.repository;

import java.util.List;
import java.util.function.Predicate;

public interface Storage<T> {

    void add(T value);

    void addAll(List<T> values);

    List<T> search(T value);

    List<T> searchBy(Predicate<T> predicate);

    boolean remove(T value);

    boolean removeIf(Predicate<T> predicate);

    long getCount();

    List<T> findBy(Pagination pagination);
}
