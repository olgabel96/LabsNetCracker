package ru.vsu.comparator;

import ru.vsu.entities.Person;

public class ComparePersonsById implements IPersonComparator {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getId().compareTo(p2.getId());
    }
}
