package ru.vsu.lab1;

@FunctionalInterface
public interface IPersonChecker {
    public boolean check(Person p, Object value);
}
