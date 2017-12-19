package ru.vsu.checkers;

import ru.vsu.entities.Car;

public class DOCCarChecker implements ICarChecker {
    @Override
    public boolean check(Car p, Object value) {
        return p.getGreateDate().equals(value);
    }
}
