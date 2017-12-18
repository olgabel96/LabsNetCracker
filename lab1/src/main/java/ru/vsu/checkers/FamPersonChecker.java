package ru.vsu.checkers;

import ru.vsu.entities.Person;

public class FamPersonChecker implements IPersonChecker {
    @Override
    public boolean check(Person p, Object value) {
        return p.getFam().equals(value);
    }
}
