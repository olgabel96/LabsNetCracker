package ru.vsu.sorters;

import ru.vsu.comparator.IComparator;

import ru.vsu.entities.Person;
import ru.vsu.repositories.PersonRepository;

public class BubbleSorter<T> implements ISorter<T> {
    @Override
    public T[] sort(T[] personList, int size, IComparator comparator) {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(personList[j], personList[j + 1]) > 0) {
                    T tmp = personList[j];
                    personList[j] = personList[j + 1];
                    personList[j + 1] = tmp;
                }
            }
        }
        return personList;
    }
}
