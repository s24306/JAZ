package org.example;

import org.example.model.Person;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class PeopleCleaner {

    public List<Person> getPeopleWithBooksOnly(List<Person> people){
        for (Person person : new ArrayList<>(people)) {

            if (person.getBooks().isEmpty()) {
                people.remove(person);
            }
        }
        return people;
    }
}