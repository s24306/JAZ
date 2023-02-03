package main.java.org.example.queries.filters;

import main.java.org.example.model.Person;
import main.java.org.example.queries.search.SearchParameters;

@FunctionalInterface
public interface DualPredicate{

    public boolean check(SearchParameters s, Person p);
}
