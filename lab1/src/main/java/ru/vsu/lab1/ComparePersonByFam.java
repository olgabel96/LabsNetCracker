package ru.vsu.lab1;

public class ComparePersonByFam implements PersonComparator {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getFam().compareTo(p2.getFam());
    }
}
