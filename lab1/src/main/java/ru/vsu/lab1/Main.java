package ru.vsu.lab1;



/**
 * Я здесь главная
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        LocalDate a= new LocalDate(2004,12,25);
        int b=a.getDayOfMonth();
        System.out.println(b);
    }
}
