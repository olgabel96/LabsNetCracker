package ru.vsu.sorters;

import ru.vsu.comparator.IComparator;

import ru.vsu.entities.Person;
import ru.vsu.repositories.PersonRepository;


public class InsertionSorter<T> implements ISorter<T> {

    @Override
    public T[] sort(T[] personList, int size, IComparator comparator) {
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (comparator.compare(personList[j - 1], personList[j]) > 0) {
                    T tmp = personList[j];
                    personList[j] = personList[j - 1];
                    personList[j - 1] = tmp;
                }
            }
        }
        return personList;
    }
}
