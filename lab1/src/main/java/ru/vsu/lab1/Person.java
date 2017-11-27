package ru.vsu.lab1;

import org.joda.time.LocalDate;

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
        int year=LocalDate.now().getYear()-BirthDate.getYear();
        if(LocalDate.now().getMonthOfYear()<BirthDate.getMonthOfYear()){
            year--;
        }
        if(LocalDate.now().getMonthOfYear()==BirthDate.getMonthOfYear()){
            if(LocalDate.now().getDayOfMonth()<BirthDate.getDayOfMonth()){
                year--;
            }
        }
        return year;
    }
}
