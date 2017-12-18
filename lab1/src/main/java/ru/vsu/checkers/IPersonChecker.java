package ru.vsu.checkers;

import ru.vsu.entities.Person;

@FunctionalInterface
public interface IPersonChecker {
    public boolean check(Person p, Object value);
}
