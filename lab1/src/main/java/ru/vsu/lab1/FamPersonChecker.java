package ru.vsu.lab1;

public class FamPersonChecker implements IPersonChecker{
    @Override
    public boolean check(Person p, Object value) {
        return p.getFam().equals(value);
    }
}
