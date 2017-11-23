package ru.vsu.lab1;

import org.joda.time.LocalDate;

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
        System.out.println(myPerson.getAge());
        System.out.println(myFriend.getAge());
        System.out.println(myPerson.getId());
        System.out.println(myFriend.getId());
    }
}
