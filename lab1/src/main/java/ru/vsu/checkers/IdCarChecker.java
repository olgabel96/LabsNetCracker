package ru.vsu.checkers;

import ru.vsu.entities.Car;

public class IdCarChecker implements ICarChecker {
    @Override
    public boolean check(Car p, Object value) {
        return p.getId().equals(value);

    }
}
