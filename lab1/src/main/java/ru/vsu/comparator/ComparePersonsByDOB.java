package ru.vsu.comparator;

import ru.vsu.entities.Person;

public class ComparePersonsByDOB implements IComparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if(p1.getBirthDate().isEqual(p2.getBirthDate())){
            return 0;
        }else{
            if(p1.getBirthDate().isAfter(p2.getBirthDate())){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
}
