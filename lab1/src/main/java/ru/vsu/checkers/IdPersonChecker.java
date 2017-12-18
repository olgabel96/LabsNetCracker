package ru.vsu.checkers;

import ru.vsu.entities.Person;

public class IdPersonChecker implements IPersonChecker {
    @Override
    public boolean check(Person p, Object value) {
        return p.getId().equals(value);

    }
}