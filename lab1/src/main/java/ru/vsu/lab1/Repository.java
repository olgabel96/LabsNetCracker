package ru.vsu.lab1;

public interface Repository<T> {
    public boolean add(T item);
    public boolean delete(int index);
    public T get(int index);
    public T[] getAll();
    public int indexOf(T p);
}
