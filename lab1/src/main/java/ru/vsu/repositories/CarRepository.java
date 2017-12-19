package ru.vsu.repositories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.LocalDate;
import ru.vsu.checkers.*;
import ru.vsu.comparator.*;
import ru.vsu.entities.Car;
import ru.vsu.entities.Person;
import ru.vsu.lab1.Configurator;
import ru.vsu.sorters.ISorter;

public class CarRepository extends ARep<Car> {
    private static final Logger LOGGER = LogManager.getLogger(PersonRepository.class.getName());
    private ISorter sorter = Configurator.getInstance().getSorter();


    public CarRepository() {
        this.kol = 0;
        this.rep = new Person[DEFAULT_CAPACITY];
    }



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
     *
     */
    public void sortById() {
        LOGGER.debug("sortById method of PersonRepository is called");
        this.rep = sorter.sort(this.rep, kol, new CompareCarById());
    }

    /**
     * Sorts the specified array of objects by name
     *
     */
    public void sortByName() {
        LOGGER.debug("sortByFam method of PersonRepository is called");
        this.rep = sorter.sort(this.rep, kol, new CompareCarByName());
    }


    /**
     * Sorts the specified array of objects by birth date
     *
     */
    public void sortByDOC() {
        LOGGER.debug("sortByDOB method of PersonRepository is called");
        this.rep = sorter.sort(this.rep, kol, new CompareCarByDOC());
    }




    /**
     * if this list contains the specified elements
     *
     * @param checker to determine the sorting property
     * @param value   whose presence in this list is to be tested
     */
    private CarRepository search(ICarChecker checker, Object value) {
        LOGGER.debug("search method of PersonRepository is called");
        CarRepository found = new CarRepository();
        for (Car p : this) {
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
    public CarRepository searchById(String id) {
        LOGGER.debug("searchById method of PersonRepository is called");
        return search(new IdCarChecker(), id);
    }

    /**
     * if this repository contains persons with specified name
     *
     * @param name whose presence in this list is to be tested
     * @return PersonRepository with list of Persons found
     */
    public CarRepository searchByName(String name) {
        LOGGER.debug("searchByFam method of PersonRepository is called");
        return search(new NameCarChecker(), name);
    }

    /**
     * if this repository contains persons with specified birthDate
     *
     * @param birthDate whose presence in this list is to be tested
     * @return PersonRepository with list of Persons found
     */
    public CarRepository searchByDOC(LocalDate birthDate) {
        LOGGER.debug("searchByDOB method of PersonRepository is called");
        return search(new DOCCarChecker(), birthDate);
    }


}
