package ru.vsu.lab1;

public interface Repository<T> {
    public void add(T item);
    public void delete(int index);
}
