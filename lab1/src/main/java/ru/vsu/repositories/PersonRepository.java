package ru.vsu.repositories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.LocalDate;
import ru.vsu.checkers.DOBPersonChecker;
import ru.vsu.checkers.FamPersonChecker;
import ru.vsu.checkers.IPersonChecker;
import ru.vsu.checkers.IdPersonChecker;
import ru.vsu.comparator.ComparePersonsByDOB;
import ru.vsu.comparator.ComparePersonsByFam;
import ru.vsu.comparator.ComparePersonsById;
import ru.vsu.entities.Person;
import ru.vsu.lab1.Configurator;
import ru.vsu.lab1.*;
import ru.vsu.sorters.IPersonListSorter;

import java.util.Iterator;


public class PersonRepository extends ARep implements Iterable<Person> {

    private static final Logger LOGGER = LogManager.getLogger(PersonRepository.class.getName());
    private IPersonListSorter sorter = Configurator.getInstance().getSorter();


    public PersonRepository() {
        this.size = 2;
        this.kol = 0;
        this.rep = new Person[size];
    }

    public PersonRepository(int capacity) {
        this.size = capacity;
        this.kol = 0;
        this.rep = new Person[size];
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int getKolPerson() {
        LOGGER.debug("getKolPerson method called");
        return kol;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        LOGGER.debug("isEmpty method called");
        return kol == 0;
    }


/*
    public void addPerson(Person newPerson) {
        if (kolPerson < size) {
            rep[kolPerson] = newPerson;
            kolPerson++;
        } else {
            size = size + 2;
            Person[] rep2;
            rep2 = new Person[size];
            System.arraycopy(rep, 0, rep2, 0, kolPerson);
            rep2[kolPerson] = newPerson;
            kolPerson++;
            rep = rep2;
        }
    }
*/

    /**
     * Print rep
     * */
    public void printRep(){
        for(int i=0;i<kol;i++){
            System.out.println(rep[i].toString());
        }
    }

    /**
     * Sorts the specified array of objects by id
     * use {@link #setSorter(IPersonListSorter)} method to determine the sorting method
     */
    public void sortById() {
        LOGGER.debug("sortById method of PersonRepository is called");
        this.rep = sorter.sort(this.rep, kol, new ComparePersonsById());
    }

    /**
     * Sorts the specified array of objects by name
     * use {@link #setSorter(IPersonListSorter)} method to determine the sorting method
     */
    public void sortByFam() {
        LOGGER.debug("sortByFam method of PersonRepository is called");
        this.rep = sorter.sort(this.rep, kol, new ComparePersonsByFam());
    }


    /**
     * Sorts the specified array of objects by birth date
     * use {@link #setSorter(IPersonListSorter)} method to determine the sorting method
     */
    public void sortByDOB() {
        LOGGER.debug("sortByDOB method of PersonRepository is called");
        this.rep = sorter.sort(this.rep, kol, new ComparePersonsByDOB());
    }

    /**
     * Set sorting method to repository
     *
     * @param sorter
     */
    public void setSorter(IPersonListSorter sorter) {
        LOGGER.debug("setSorter method of PersonRepository is called");
        this.sorter = sorter;
    }


    /**
     * if this list contains the specified elements
     *
     * @param checker to determine the sorting property
     * @param value   whose presence in this list is to be tested
     */
    private PersonRepository search(IPersonChecker checker, Object value) {
        LOGGER.debug("search method of PersonRepository is called");
        PersonRepository found = new PersonRepository();
        for (Person p : this) {
            if (checker.check(p, value)) {
                found.add(p);
            }
        }
        return found;
    }

    /**
     * if this repository contains persons with specified id
     *
     * @param id whose presence in this list is to be tested
     * @return PersonRepository with list of Persons found
     */
    public PersonRepository searchById(String id) {
        LOGGER.debug("searchById method of PersonRepository is called");
        return search(new IdPersonChecker(), id);
    }

    /**
     * if this repository contains persons with specified name
     *
     * @param name whose presence in this list is to be tested
     * @return PersonRepository with list of Persons found
     */
    public PersonRepository searchByFam(String name) {
        LOGGER.debug("searchByFam method of PersonRepository is called");
        return search(new FamPersonChecker(), name);
    }

    /**
     * if this repository contains persons with specified birthDate
     *
     * @param birthDate whose presence in this list is to be tested
     * @return PersonRepository with list of Persons found
     */
    public PersonRepository searchByDOB(LocalDate birthDate) {
        LOGGER.debug("searchByDOB method of PersonRepository is called");
        return search(new DOBPersonChecker(), birthDate);
    }



    @Override
    public Iterator<Person> iterator() {
        return new PersonrepositoryIterator();
    }

    class PersonrepositoryIterator implements Iterator<Person> {

        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex != kol;
        }

        @Override
        public Person next() {
            return rep[currentIndex++];
        }
    }
}
