package ru.vsu.lab1;

public class IdPersonChecker implements IPersonChecker {
    @Override
    public boolean check(Person p, Object value) {
        return p.getId().equals(value);

    }
}