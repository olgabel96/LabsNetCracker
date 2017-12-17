package ru.vsu.lab1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
