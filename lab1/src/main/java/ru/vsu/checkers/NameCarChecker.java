package ru.vsu.checkers;

import ru.vsu.entities.Car;

public class NameCarChecker implements ICarChecker {
    @Override
    public boolean check(Car p, Object value) {
        return p.getName().equals(value);

    }
}
