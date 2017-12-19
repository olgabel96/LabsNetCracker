package ru.vsu.comparator;

import ru.vsu.entities.Car;

public class CompareCarByDOC implements IComparator<Car> {
    @Override
    public int compare(Car p1, Car p2) {
        if(p1.getGreateDate().isEqual(p2.getGreateDate())){
            return 0;
        }else{
            if(p1.getGreateDate().isAfter(p2.getGreateDate())){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
}
