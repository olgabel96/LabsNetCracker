package ru.vsu.entities;

import org.joda.time.LocalDate;
import org.joda.time.Period;

import java.util.UUID;

public class Car {
    private LocalDate GreateDate;
    private String Name;
    private String id;

    public Car(LocalDate greateDate, String name) {
        GreateDate = greateDate;
        this.Name = name;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Person{" +
                "BirthDate=" + GreateDate +
                ", fam='" + Name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public LocalDate getGreateDate() {
        return GreateDate;
    }

    public void setGreateDate(LocalDate birthDate) {
        GreateDate = birthDate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String fam) {
        this.Name = fam;
    }

    public String getId(){ return id;}


    public int getAge(){
        Period period = new Period(GreateDate, LocalDate.now());
        return period.getYears();
    }
}
