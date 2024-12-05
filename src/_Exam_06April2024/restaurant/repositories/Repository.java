package _Exam_06April2024.restaurant.repositories;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getCollection();

    void add(T entity);

    boolean remove(T entity);

    T byName(String name);
}