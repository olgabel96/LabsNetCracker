package ru.vsu.lab1;

public class ComparePersonsById implements IPersonComparator {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getId().compareTo(p2.getId());
    }
}
