package ru.vsu.lab1;

import org.joda.time.LocalDate;

public class Person {
    private LocalDate BirthDate;
    private String fam;
    private int id;

    public Person(LocalDate birthDate, String fam, int id) {
        BirthDate = birthDate;
        this.fam = fam;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
