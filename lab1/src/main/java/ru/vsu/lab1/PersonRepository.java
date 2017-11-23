package ru.vsu.lab1;

public class PersonRepository {
    Person[] rep;
    int size=1;

    public PersonRepository(Person[] rep, int size) {
        this.rep = rep;
        this.size = size;
    }

    public Person[] getRep() {
        return rep;
    }

    public void setRep(Person[] rep) {
        this.rep = rep;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


}
