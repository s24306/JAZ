package org.example;

import org.example.model.Book;
import org.example.model.Person;
import org.example.model.Samples;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Random;

public class BooksDistributor {

    public void distributeBooksThroughPeople(){

        for (Person person: Samples.getSampleListOfPeople())
        {
            if (Samples.getAvailableBooks().size()>0) {
                int index = getRandomIndex();
                Book theirBook = Samples.getAvailableBooks().get(index);
                person.getBooks().add(theirBook);
                theirBook.setOwner(person);
                Samples.bookDistributed(theirBook);
            }
        }

    }
    private int getRandomIndex(){
        return new Random().nextInt(Samples.getAvailableBooks().size());
    }


}








