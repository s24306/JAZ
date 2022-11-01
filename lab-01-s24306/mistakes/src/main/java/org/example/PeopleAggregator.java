package org.example;

import org.example.model.Gender;
import org.example.model.Person;
import org.example.model.Samples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleAggregator {

    public Map<Gender, List<Person>> aggregatePeopleByGender(){
        List<Person> listOfMen = new ArrayList<>();
        List<Person> listOfWomen = new ArrayList<>();
        Map<Gender, List<Person>> aggregatedByGender = new HashMap<>();
        aggregatedByGender.put(Gender.FEMALE, listOfWomen);
        aggregatedByGender.put(Gender.MALE, listOfMen);
        for (Person person : Samples.getSampleListOfPeople()) {
            if (person.getGender() == Gender.MALE) {
                aggregatedByGender.get(Gender.MALE).add(person);
            }
            if (person.getGender() == Gender.FEMALE) {
                aggregatedByGender.get(Gender.FEMALE).add(person);
            }
        }
        return aggregatedByGender;
    }
}
