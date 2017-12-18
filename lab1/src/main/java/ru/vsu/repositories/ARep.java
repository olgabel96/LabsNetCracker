package ru.vsu.repositories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.vsu.entities.Person;

public abstract class ARep implements Repository<Person> {
    private static final Logger LOGGER = LogManager.getLogger(PersonRepository.class.getName());
    private static final int MAX_CAPACITY = Integer.MAX_VALUE - 1;
    Person[] rep;
    int size;
    /**
     * The size of the rep (the number of elements it contains).
     */
    int kol;

    /**
     * Appends element to the end of this list.
     *
     * @param item element to be appended to this list
     * @return true if success
     */
    @Override
    public boolean add(Person item) {
        LOGGER.debug("add method is called");
        if (kol < size) {
            rep[kol] = item;
            kol++;
        } else {
            if (MAX_CAPACITY - size > 0) {
                LOGGER.info("Repository size increased");
                size = size + 2;
                Person[] rep2;
                rep2 = new Person[size];

                System.arraycopy(rep, 0, rep2, 0, kol);
                rep2[kol] = item;
                kol++;
                rep = rep2;
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
    public Person get(int index) {

        LOGGER.debug("get method is called");
        if (index < size) {
            return rep[index];
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
    public Person[] getAll() {
        LOGGER.debug("getAll method is called");
        return rep;
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index  index of the element to replace
     * @param person element to be stored at the specified position
     * @return true if success
     */
    public boolean set(int index, Person person) {
        LOGGER.debug("set method of PersonRepository is called");
        if (index < size && index >= 0) {
            this.rep[index] = person;
            return true;
        }
        return false;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param p element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    public boolean contains(Person p) {
        return indexOf(p) >= 0;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     */
    @Override
    public int indexOf(Person p) {
        LOGGER.debug("indexOf method is called");
        for (int i = 0; i < size; i++) {
            if (p.equals(rep[i])) {
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


}
