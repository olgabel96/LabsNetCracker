package ru.vsu.checkers;

import ru.vsu.entities.Person;


public class DOBPersonChecker implements IPersonChecker {
    @Override
    public boolean check(Person p, Object value) {
        return p.getBirthDate().equals(value);
    }
}