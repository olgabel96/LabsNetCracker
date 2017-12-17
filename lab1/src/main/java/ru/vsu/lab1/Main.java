package ru.vsu.lab1;

import org.joda.time.LocalDate;

import java.util.ArrayList;

/**
 * Я здесь главная
 */
public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        //LocalDate a= new LocalDate(2004,12,25);
        //int b=a.getDayOfMonth();
        //System.out.println(b);
        Person myPerson=new Person(new LocalDate(1996,03,14),"Belonogova");
        Person myFriend=new Person(new LocalDate(1995,12,8),"Voronkov");
        Person myTestPerson1=new Person(new LocalDate(2004,02,21),"Morozov");
        Person myTestPerson2=new Person(new LocalDate(1972,06,28),"Ivanov");
        Person myTestPerson3=new Person(new LocalDate(1952,10,12),"Petrov");
        System.out.println(myPerson.getAge());
        System.out.println(myFriend.getAge());
        PersonRepository myRep=new PersonRepository();
        myRep.add(myPerson);
        myRep.add(myFriend);
        myRep.add(myTestPerson1);
        myRep.add(myTestPerson2);
        myRep.add(myTestPerson3);
        myRep.printRep();
        System.out.println();
        myRep.delete(3);
        myRep.printRep();

        System.out.println(myRep.getKolPerson());

        myRep.sortByFam();
        myRep.printRep();
    }
}
