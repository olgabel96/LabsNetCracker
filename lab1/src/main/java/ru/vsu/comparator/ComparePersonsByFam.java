package ru.vsu.comparator;

import ru.vsu.entities.Person;

public class ComparePersonsByFam implements IComparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getFam().compareTo(p2.getFam());
    }
}
