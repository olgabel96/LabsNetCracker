package ru.vsu.checkers;

import ru.vsu.entities.Car;

@FunctionalInterface
public interface ICarChecker {
    public boolean check(Car p, Object value);
}
