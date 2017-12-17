package ru.vsu.lab1;

import org.joda.time.LocalDate;

public class DOBPersonChecker implements IPersonChecker {
    @Override
    public boolean check(Person p, Object value) {
        return p.getBirthDate().equals(value);
    }
}