package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Samples {

    private static List<Person> people = new ArrayList<>(List.of(
            new Person("Clark", "Kent", Gender.MALE),
            new Person("Lois", "Lane", Gender.FEMALE),
            new Person("Slade", "Wilson", Gender.MALE),
            new Person("Jessica", "Jones", Gender.FEMALE),
            new Person("Bruce", "Wayne", Gender.MALE),
            new Person("Harley", "Quin", Gender.FEMALE)
    ));

    private static List<Book> allBooks = new ArrayList<>(List.of(
            new Book("SuperMan"),
            new Book("Batman"),
            new Book("Titans"),
            new Book("Suicide Squad")
    ));

    private static List<Book> availableBooks = new ArrayList<>(allBooks);

    public static void bookDistributed(Book book){
        availableBooks.remove(book);
    }

    public static List<Person> getSampleListOfPeople() {
        return people;
    }

    public static void printAvailableBooks() {
        for (Book book : availableBooks){
            System.out.println(book.getTitle());
        }
    }

    public static List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public static List<Book> getAllBooks() {
        return allBooks;
    }
}
