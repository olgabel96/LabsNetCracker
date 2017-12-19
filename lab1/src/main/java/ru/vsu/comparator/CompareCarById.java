package ru.vsu.comparator;

import ru.vsu.entities.Car;

public class CompareCarById implements IComparator<Car> {
    @Override
    public int compare(Car p1, Car p2) {
        return p1.getId().compareTo(p2.getId());
    }
}
