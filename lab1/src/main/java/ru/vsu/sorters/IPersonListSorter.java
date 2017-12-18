package ru.vsu.sorters;

import ru.vsu.comparator.IPersonComparator;
import ru.vsu.entities.Person;
import ru.vsu.repositories.PersonRepository;

public interface IPersonListSorter {
    Person[] sort(Person[] personList, int size, IPersonComparator comparator);
}
