package ru.vsu.sorters;

import ru.vsu.comparator.IComparator;

import ru.vsu.entities.Person;
import ru.vsu.repositories.PersonRepository;


public class SelectionSorter<T> implements ISorter<T> {

    @Override
    public T[] sort(T[] personList, int size, IComparator comparator) {
        for (int i = 0; i < size; i++) {
            T min = personList[i];
            int min_i = i;
            for (int j = i + 1; j < size; j++) {
                if (comparator.compare(min, personList[j]) > 0) {
                    min = personList[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                T tmp = personList[i];
                personList[i] = personList[min_i];
                personList[min_i] = tmp;
            }
        }
        return personList;
    }
}