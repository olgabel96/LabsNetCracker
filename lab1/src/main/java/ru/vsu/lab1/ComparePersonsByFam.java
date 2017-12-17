package ru.vsu.lab1;

public class ComparePersonsByFam implements IPersonComparator {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getFam().compareTo(p2.getFam());
    }
}
