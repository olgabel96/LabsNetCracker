package ru.vsu.sorters;

import ru.vsu.comparator.IComparator;

import ru.vsu.entities.Person;
import ru.vsu.repositories.PersonRepository;

public interface ISorter<T> {
    T[] sort(T[] List, int kol, IComparator comparator);
}
