package ru.vsu.repositories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.vsu.entities.Person;
import ru.vsu.sorters.BubbleSorter;
import ru.vsu.sorters.ISorter;

import java.util.Iterator;

public abstract class ARep<T> implements IRepository<T>, Iterable<T> {
    protected ISorter sorter=new BubbleSorter();
    protected Object[] rep;
    private static final Logger LOGGER = LogManager.getLogger(PersonRepository.class.getName());
    protected static final int MAX_CAPACITY = Integer.MAX_VALUE - 1;
    protected static final int DEFAULT_CAPACITY = 2;

    //int size;
    /**
     * The size of the rep (the number of elements it contains).
     */
    int kol;

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int getKol() {
        return kol;
    }

    public void setSorter(ISorter sorter) {
        this.sorter = sorter;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return kol==0;
    }

    /**
     * Appends element to the end of this list.
     *
     * @param item element to be appended to this list
     * @return true if success
     */
    @Override
    public boolean add(T item) {
        LOGGER.debug("add method is called");
        if (kol < rep.length) {
            rep[kol++] = item;

        } else {
            if (MAX_CAPACITY - kol> 0) {
                LOGGER.info("Repository size increased");
                Object[] rep2 = new Object[kol+2];
                for (int i = 0; i < kol; i++) {
                    rep2[i] = rep[i];
                }
                rep2[kol++] = item;
                this.rep = rep2;

            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public T get(int index) {

        LOGGER.debug("get method is called");
        if (index < kol) {
            return (T)rep[index];
        } else {
            return null;
        }
    }

    /**
     * Returns an Array
     *
     * @return Array
     */
    @Override
    public T[] getAll() {
        LOGGER.debug("getAll method is called");
        return (T[])rep;
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index  index of the element to replace
     * @param item element to be stored at the specified position
     * @return true if success
     */
    @Override
    public boolean set(int index, T item) {
        LOGGER.debug("set method of PersonRepository is called");
        if (index < kol && index >= 0) {
            this.rep[index] = item;
            return true;
        }
        return false;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param item element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(T item) {
        return indexOf(item) >= 0;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     */
    @Override
    public int indexOf(T item) {
        LOGGER.debug("indexOf method is called");
        for (int i = 0; i < kol; i++) {
            if (item.equals(rep[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return true if the element was removed from the list
     */
    @Override
    public boolean delete(int index) {

        boolean isFind = false;
        int indexDel = -1;
        for (int j = 0; j < kol && !isFind; j++) {
            if (j==index) {
                isFind = true;
                indexDel = j;
            }
        }
        if (indexDel != -1) {
            for (int j = indexDel; j < kol - 1; j++) {
                rep[j] = rep[j + 1];
            }
            kol--;
            rep[kol] = null;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RepositoryIterator();
    }

    class RepositoryIterator implements Iterator<T> {

        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex != kol;
        }

        @Override
        public T next() {
            return (T)rep[currentIndex++];
        }
    }

}
