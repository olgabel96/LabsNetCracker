package ru.vsu.comparator;

import ru.vsu.entities.Car;

public class CompareCarByName implements IComparator<Car> {
    @Override
    public int compare(Car p1, Car p2) {
        return p1.getName().compareTo(p2.getName());
    }
}
