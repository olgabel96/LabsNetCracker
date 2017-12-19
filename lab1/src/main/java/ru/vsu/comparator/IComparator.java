package ru.vsu.comparator;

import ru.vsu.entities.Person;

public interface IComparator<T> {
    public int compare(T p1, T p2);
}
