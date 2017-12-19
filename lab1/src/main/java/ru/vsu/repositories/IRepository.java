package ru.vsu.repositories;

public interface IRepository<T> {
    int getKol();
    boolean isEmpty();
    boolean add(T item);
    boolean delete(int index);
    boolean set(int index, T item);
    boolean contains(T item);
    T get(int index);
    T[] getAll();
    int indexOf(T item);
}
