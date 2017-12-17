package ru.vsu.lab1;

import org.joda.time.LocalDate;
import org.joda.time.Period;
import java.util.UUID;

public class Person {
    private LocalDate BirthDate;
    private String fam;
    private String id;

    public Person(LocalDate birthDate, String fam) {
        BirthDate = birthDate;
        this.fam = fam;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Person{" +
                "BirthDate=" + BirthDate +
                ", fam='" + fam + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getId() {
        return id;
    }

    public int getAge(){
        Period period = new Period(BirthDate, LocalDate.now());
        return period.getYears();
    }
}
